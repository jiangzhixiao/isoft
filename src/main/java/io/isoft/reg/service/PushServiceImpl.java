package io.isoft.reg.service;

import flex.messaging.MessageDestination;
import flex.messaging.services.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.messaging.MessageTemplate;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component("pushService")
public class PushServiceImpl implements PushService{
	private static final Logger logger = Logger.getLogger(PushServiceImpl.class);
	public static final Long DEFAULT_ALERM_INTERVAL = 15000l;
	public static final String PREFIX_DESTINATION = "USER_";
	private List<String> userCodes;
	private List<Thread> alermThreads;
	
	@Autowired
    MessageTemplate messageTemplate;
//    @Autowired
//    private JmsMessagingTemplate jmsMessagingTemplate;
	private final WarnService warnService;
	private final static String SERVICE_ID = "message-service";
	@Autowired
	public PushServiceImpl(WarnService warnService)
	{
		this.warnService = warnService;
//		this.messageTemplate = messageTemplate;
//		this.jmsMessagingTemplate = jmsMessagingTemplate;
		userCodes = Collections.synchronizedList(new ArrayList<String>());
		alermThreads = Collections.synchronizedList(new ArrayList<Thread>());
	}

	public List getUserCodeList()
	{
		return userCodes;
	}
	
	public void start(String id) throws RuntimeException {

		if (userCodeExists(id))
		{
			throw new RuntimeException("user code already exists");
		}
//		jmsMessagingTemplate.convertAndSend(PREFIX_DESTINATION+id, "订阅成功"); //activeMq  Subscribe
		
		// 动态创建destination
		//flex/messaging-config.xml的root element
		MessageService messageService = (MessageService)messageTemplate.getMessageBroker().getService(SERVICE_ID);
		MessageDestination destination = (MessageDestination) messageService.createDestination(PREFIX_DESTINATION+id);

		if (messageService.isStarted())
		{
			destination.start();
			logger.info(destination+"消息服务已启动");
		}
		AlermMsgThread thread = new AlermMsgThread(id);
		thread.start();
		userCodes.add(id);
		alermThreads.add(thread);
	}
	
	public void stop(String id){
		Thread t = getAlermThread(id);
		if(t != null){
			((AlermMsgThread)t).setRunning(false);
			alermThreads.remove(t);
			userCodes.remove(id);
			t = null;
			
			MessageService service = (MessageService)messageTemplate.getMessageBroker().getService(SERVICE_ID);
			MessageDestination destination = (MessageDestination) service.getDestination(PREFIX_DESTINATION+id);
			destination.stop();
			service.removeDestination(PREFIX_DESTINATION+id);
			logger.info("消息服务已停止");
		}
	}
	
	private boolean userCodeExists(String id)
	{
		int size = userCodes.size();
		for (int i=0; i<size; i++)
		{
			if ( userCodes.get(i).equals(id) ) 
			{
				return true;
			}
		}
		return false;
	}
	
	private Thread getAlermThread(String id){
		for(Thread t : alermThreads){
			if(id.equals(((AlermMsgThread)t).getBizId())){
				return t;
			}
		}
		return null;
	}
		
	/**
	 * 一个简单的Timer
	 * 
	 *
	 */
	public class AlermMsgThread extends Thread {
		
		private String bizId;
		private Long alermInterval;
		private boolean running = true;
		
		public String getBizId() {
			return bizId;
		}

		public boolean isRunning() {
			return running;
		}

		public void setRunning(boolean running) {
			this.running = running;
		}

		public AlermMsgThread(String id){
			super();
			this.bizId = id;
		}
		
		public AlermMsgThread(String id,Long alermInterval){
			super();
			this.bizId = id;
			this.alermInterval = alermInterval;
		}

		public void run() {
			Long _interval = alermInterval == null||alermInterval<=0?DEFAULT_ALERM_INTERVAL:alermInterval;
			while (running) {
				Object body = "jzx";//null;//monitorService.findLastRYWarnResult(bizId);
				messageTemplate.send(PREFIX_DESTINATION+bizId, body);
				logger.debug(body);
				try {
					Thread.sleep(_interval);
				} catch (InterruptedException e) {
				}

			}
		}
	}
}

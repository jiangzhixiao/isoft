package io.isoft.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PushTask {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	@Autowired
	private JmsTemplate jmsTopicTemplate;
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Scheduled(cron = "*/5 * 16-20 * * *") //17-20点之间，每五秒执行一次
    public void reportCurrentTime() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
        jmsMessagingTemplate.convertAndSend("USER_ceshi22", "测试主题");
    }
    
    @Scheduled(cron = "*/10 * * * * *")
    public void reportCurrentTime2() {
        System.out.println("reportCurrentTime2：" + dateFormat.format(new Date()));
        jmsTopicTemplate.setPubSubDomain(true);
        jmsTopicTemplate.convertAndSend("moonshot", dateFormat.format(new Date()));
    }
    

}

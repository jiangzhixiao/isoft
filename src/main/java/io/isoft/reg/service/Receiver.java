package io.isoft.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.messaging.MessageTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	@Autowired
	 MessageTemplate messageTemplate;
	 
   @JmsListener(destination = "USER_ceshi22", containerFactory = "myJmsContainerFactory")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        
        //
//        MessageBroker msgBroker = (MessageBroker)messageTemplate.getMessageBroker();
//        AsyncMessage msg = new AsyncMessage();  
//        String clientID = UUIDUtils.createUUID();
//        msg.setDestination("USER_ceshi");  
//        msg.setClientId(clientID);  
//        msg.setMessageId(UUIDUtils.createUUID());  
//        msg.setTimestamp(System.currentTimeMillis());  
//        /* 设置消息信息，发布到客户端去 */  
//        msg.setBody(message);  
//        msgBroker.routeMessageToService(msg, null); 
  }
   
   @JmsListener(destination = "test.Topic", containerFactory = "myJmsContainerFactory")
   public void receiveMessage2(String message) {
       System.out.println("receiveMessage2 监听成功，获得的消息是： <" + message + ">");
 }
   
}

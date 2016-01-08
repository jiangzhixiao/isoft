package io.isoft;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * Created by jzx on 2015/7/01.
 */
@Configuration
@ConditionalOnWebApplication
public class JMSConfiguration {
	 @Bean
	    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory) {
	        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
	        factory.setConnectionFactory(connectionFactory);
//	        factory.setPubSubDomain(true);
	        return factory;
	    }
}

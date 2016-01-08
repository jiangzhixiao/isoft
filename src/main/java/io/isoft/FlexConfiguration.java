package io.isoft;

import flex.messaging.HttpFlexSession;
import flex.messaging.MessageBroker;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.flex.config.BeanIds;
import org.springframework.flex.config.MessageBrokerConfigProcessor;
import org.springframework.flex.config.RemotingAnnotationPostProcessor;
import org.springframework.flex.core.MessageBrokerFactoryBean;
import org.springframework.flex.messaging.MessageTemplate;
import org.springframework.flex.servlet.MessageBrokerHandlerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import javax.servlet.Filter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by jzx on 2015/7/01.
 */
@Configuration
@ConditionalOnWebApplication
public class FlexConfiguration {

    @Bean
    public ServletListenerRegistrationBean<HttpFlexSession> flexSession(){
        return new ServletListenerRegistrationBean(new HttpFlexSession());
    }

    /**
     * 1. Parsing the BlazeDS XML configuration files and applying their settings to a newly created MessageBroker
     * 2. Starting the MessageBroker and its services
     * @return
     */
    @Bean(name = BeanIds.MESSAGE_BROKER)
    public MessageBrokerFactoryBean messageBrokerFactoryBean(ApplicationContext applicationContext){
        MessageBrokerFactoryBean messageBrokerFactoryBean = new MessageBrokerFactoryBean();
        messageBrokerFactoryBean.setServicesConfigPath("classpath:flex/services-config.xml");

        // http://docs.spring.io/spring-flex/docs/1.6.x/reference/html/#security-filter-config
        Map<String, MessageBrokerConfigProcessor> beansOfType = applicationContext.getBeansOfType(MessageBrokerConfigProcessor.class);
        if(beansOfType!=null&&beansOfType.size()>0){
            messageBrokerFactoryBean.setConfigProcessors(new HashSet<MessageBrokerConfigProcessor>(beansOfType.values()));
        }

        return messageBrokerFactoryBean;
    }

    /**
     * {@link org.springframework.web.servlet.HandlerAdapter} for routing HTTP messages to a Spring-managed {@link MessageBroker}.
     */
    @Bean(name = BeanIds.MESSAGE_BROKER_HANDLER_ADAPTER)
    public MessageBrokerHandlerAdapter messageBrokerHandlerAdapter(){
        return new MessageBrokerHandlerAdapter();
    }

    /**
     * Maps request paths at /messagebroker/* to the BlazeDS MessageBroker
     */
    @Bean(name = BeanIds.HANDLER_MAPPING_SUFFIX)
    public SimpleUrlHandlerMapping messagebrokerHandlerMapping(MessageBroker messageBroker)
    {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(Integer.MIN_VALUE);
        mapping.setUrlMap(Collections.singletonMap("/messagebroker/*", messageBroker));
        return mapping;
    }

    @Bean(name = BeanIds.REMOTING_ANNOTATION_PROCESSOR)
    public RemotingAnnotationPostProcessor remotingAnnotationPostProcessor(){
        return new RemotingAnnotationPostProcessor();
    }
    
    @Bean(name = "messageTemplate")
    public MessageTemplate messageTemplate(){
        return new MessageTemplate();
    }
    
    @Bean(name = "messagebrokerFilter")
    public Filter messagebrokerFilter() {
      return new StreamingFilter();
    }
    
    @Bean
    public FilterRegistrationBean  messagebrokerFilterRegistration() {
    	 FilterRegistrationBean registration = new FilterRegistrationBean();
         registration.setFilter(messagebrokerFilter());
         registration.addUrlPatterns("/messagebroker/*");
         registration.setName("messagebrokerFilter");
         return registration;
    }

}

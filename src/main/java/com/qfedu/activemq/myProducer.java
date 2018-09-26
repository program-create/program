package com.qfedu.activemq;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @Author Amos
 * @Date 2018/9/26 0026 15:41
 */
public class myProducer {
    private JmsTemplate jmsTemplate;

    public JmsTemplate getJmsTemplate () {
        return jmsTemplate;
    }

    public void setJmsTemplate (JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(final String msg){
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage (Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }
}

package com.example.week12_mq.config;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Connection;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Session;

@Component
public class ActiveMQConfig implements ExceptionListener {



    @Bean
    public Session createActiveMqSession() throws JMSException {
        Connection connection = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616").createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        return session;
    }




    @Override
    public void onException(JMSException e) {

    }
}

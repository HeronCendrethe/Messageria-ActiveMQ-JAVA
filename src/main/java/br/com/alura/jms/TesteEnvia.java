package br.com.alura.jms;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TesteEnvia {

    public static void main(String...args) throws NamingException, JMSException {

        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection =  factory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Destination destination = (Destination) context.lookup("financeiro");
        MessageProducer producer = session.createProducer(destination);
        Message message = session.createTextMessage("Ola tudo bem? esta e uma mensagem!");
        producer.send(message);
        connection.close();

    }

}

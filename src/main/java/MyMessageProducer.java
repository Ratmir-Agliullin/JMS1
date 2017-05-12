import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by admin on 12.05.2017.
 */
public class MyMessageProducer {

    private static final String QUEUE_NAME = "MyQueue";
    private Connection createConnection() throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
      return   connectionFactory.createConnection();
    }

    public void SendMessage(String message){
        Connection connection = null;
        try {
            connection = createConnection();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        try {
            connection.start();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        Session session = null;
        try {
            session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            Destination destination = session.createQueue(QUEUE_NAME);
            MessageProducer messageProducer = session.createProducer(destination);
            messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            TextMessage textMessage = session.createTextMessage(message);

            messageProducer.send(textMessage);

            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }



    }
}

/**
 * Created by admin on 12.05.2017.
 */
public class MyServer {
    private static MyMessageProducer producer=new MyMessageProducer();
    private static MyMessageConsumer consumer=new MyMessageConsumer();

    public static void getMessage(){
        consumer.receiveMessage();
    }

    public static void SendMessage(String message){
        producer.SendMessage(message);
    }

    public static void main(String[] args) {

        while (true) {
            getMessage();
            SendMessage("Здарова!");
        }
    }
}

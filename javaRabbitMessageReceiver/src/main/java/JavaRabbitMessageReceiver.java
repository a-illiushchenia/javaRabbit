import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import jsonPojo.MainCommand;

public class JavaRabbitMessageReceiver {

    private static final String EXCHANGE_NAME = "topic_logs";
    private static final String queueName = "methods.point.query.control_123";

    private static final String userName = "tkp";
    private static final String password = "tkp";
    private static final String virtualHost = "/";
    private static final String hostName = "10.60.61.51";
    private static final int portNumber = 5672;

    public static void main(String[] argv) throws Exception {
        Integer sleep = Integer.parseInt(argv[0]);

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(userName);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);
        factory.setHost(hostName);
        factory.setPort(portNumber);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, EXCHANGE_NAME, "#");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            MainCommand mainCommand = new Gson().fromJson(message, MainCommand.class);
            System.out.println(" [x] Received '" + mainCommand.getNumber());

            try {
                if(sleep > 0){
                    Thread.sleep(sleep);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    }
}
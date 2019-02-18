import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import messageCreator.IOCreateCampaign.jsonPojo1.MainCommand;

public class JavaRabbitMessageReceiver {

    private static String exchangeName = "default_exchange";
    private static String queueName = "methods.point.query.control";

    private static String hostName = "";
    private static int portNumber = 5672;
    private static String virtualHost = "/";
    private static String userName = "";
    private static String password = "";

    private static int sleep = 0;

    public static void main(String[] argv) throws Exception {

        hostName = argv[0];
        userName = argv[1];
        password = argv[2];

        sleep = Integer.parseInt(argv[3]);


        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(userName);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);
        factory.setHost(hostName);
        factory.setPort(portNumber);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(exchangeName, "topic");
        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, exchangeName, "#");

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
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import messageCreator.CreateMessageFactory;
import messageCreator.MessageCreator;

public class JavaRabbitMessageEmiter {

    private static final String exchangeName = "default_exchange";
    private static final String messageRoutingKey = "RK";

    private static String hostName = "";
    private static int portNumber = 5672;
    private static String virtualHost = "/";
    private static String userName = "";
    private static String password = "";

    private static int sleep = 0;
    private static int count = 0;

    private static String messageCreatorType = "Empty";
    private static int randomCreatorStrLength = 10;

    public static void main(String[] argv) throws Exception {

        hostName = argv[0];
        userName = argv[1];
        password = argv[2];

        messageCreatorType = argv[3];
        randomCreatorStrLength = Integer.parseInt(argv[4]);
        sleep = Integer.parseInt(argv[5]);
        count = Integer.parseInt(argv[6]);

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(userName);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);
        factory.setHost(hostName);
        factory.setPort(portNumber);
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.exchangeDeclare(exchangeName, "topic");

            for(int i = 0; i <= count; i++) {
                MessageCreator mainCommand = new CreateMessageFactory().getMessageCreator(messageCreatorType);

                if(messageCreatorType.equals("Random")){
                    mainCommand.setParams(i, randomCreatorStrLength);
                }else {
                    mainCommand.setParams(i);
                }
                String message = mainCommand.create();
                channel.basicPublish(exchangeName, messageRoutingKey, null, message.getBytes("UTF-8"));
                System.out.println(" [x] Sent '" + i);
                if(sleep > 0) {
                    Thread.sleep(sleep);
                }
            }
        }
    }
    //..
}
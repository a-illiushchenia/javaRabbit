import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import executors.MainCommandCreator;
import jsonPojo.MainCommand;

public class JavaRabbitMessageEmiter {

    private static final String EXCHANGE_NAME = "topic_logs";
    private static final String MESSAGE_ROUTING_KEY = "RK";

    private static final int SCRIPT_COUNT = 100;
    private static final int OPERATOR_COUNT = 300;
    private static final int TASK_COUNT = 100000;
    private static final int SCHEDULE_COUNT = 20;
    private static final int SCHEMA_LEVEL = 6;
    private static final int SCHEMA_LEVEL_NODE_COUNT = 3;

    private static final String HOST_NAME = "10.60.61.51";
    private static final int PORT_NUMBER = 5672;
    private static final String VIRTUAL_HOST = "/";
    private static final String USER_NAME = "tkp";
    private static final String PASSWORD = "tkp";



    public static void main(String[] argv) throws Exception {

        int userName = Integer.parseInt(argv[0]);
        int sleep = Integer.parseInt(argv[0]);
        int count = Integer.parseInt(argv[1]);

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(USER_NAME);
        factory.setPassword(PASSWORD);
        factory.setVirtualHost(VIRTUAL_HOST);
        factory.setHost(HOST_NAME);
        factory.setPort(PORT_NUMBER);
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.exchangeDeclare(EXCHANGE_NAME, "topic");

            MainCommand mainCommand = new MainCommandCreator().createMainCommand(SCRIPT_COUNT, OPERATOR_COUNT, TASK_COUNT, SCHEDULE_COUNT, SCHEMA_LEVEL, SCHEMA_LEVEL_NODE_COUNT);

            for(int i = 0; i <= count; i++) {
                mainCommand.setNumber(i);
                String mainCommandJson = new Gson().toJson(mainCommand);
                String message = mainCommandJson;
                channel.basicPublish(EXCHANGE_NAME, MESSAGE_ROUTING_KEY, null, message.getBytes("UTF-8"));
                System.out.println(" [x] Sent '" + i);
                if(sleep > 0) {
                    Thread.sleep(sleep);
                }
            }
        }
    }
    //..
}
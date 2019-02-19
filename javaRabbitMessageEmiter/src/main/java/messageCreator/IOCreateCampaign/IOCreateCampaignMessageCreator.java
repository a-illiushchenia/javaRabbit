package messageCreator.IOCreateCampaign;

import com.google.gson.Gson;
import messageCreator.IOCreateCampaign.jsonPojo.*;
import messageCreator.MainMessage;
import messageCreator.MessageCreator;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class IOCreateCampaignMessageCreator implements MessageCreator {

    private int scriptCount = 100;
    private int operatorCount = 300;
    private int taskCount = 10000;
    private int scheduleCount = 20;
    private int schemaLevel = 6;
    private int schemaLevelNodeCount = 3;

    private MainMessage mainMessage = new MainMessage();
    private static MainCommand mainCommand = null;

    @Override
    public String create() {
        if(mainCommand == null){
            createMainCommand();
        }
        mainMessage.setContent(toJson(mainCommand));
        return toJson(mainMessage);
    }

    @Override
    public void setParams(Object... params) {
        mainMessage.setOrder((int) params[0]);

        for(int i = 1; i < params.length; i++) {
            switch (i){
                case 1: scriptCount = (int)params[1]; break;
                case 2: operatorCount = (int)params[2]; break;
                case 3: taskCount = (int)params[3]; break;
                case 4: scheduleCount = (int)params[4]; break;
                case 5: schemaLevel = (int)params[5]; break;
                case 6: schemaLevelNodeCount = (int)params[6]; break;
            }
        }
    }

    public void createMainCommand() {

        mainCommand = new MainCommand();

        mainCommand.setScripts(getScripts(scriptCount));
        mainCommand.setOperators(getOperators(operatorCount));
        mainCommand.setTasks(getTasks(taskCount));
        mainCommand.setSchedules(getSchedules(scheduleCount));
        List<Schema> schemaList = new ArrayList<>();
        schemaList.add(getSchema(schemaLevel, schemaLevelNodeCount));
        mainCommand.setSchemas(schemaList);
    }



    private Schema getSchema(int schemaLevel, int schemaLevelNodeCount) {

        Schema schema = new Schema();

        schema.setId(Integer.MAX_VALUE);
        schema.setComments(RandomStringUtils.randomAlphabetic(255));
        schema.setAction("TransferToMember");
        schema.setRecord_id(Integer.MAX_VALUE);
        schema.setDtmf(9);
        schema.setResult(RandomStringUtils.randomAlphabetic(255));
        schema.setGroup_id(Integer.MAX_VALUE);
        schema.setMember_id(Integer.MAX_VALUE);
        schema.setItem_id(Integer.MAX_VALUE);


        schemaLevel -= 1;
        if (schemaLevel > 0) {
            List<Schema> schemas = new ArrayList<>();
            for (int i = 1; i <= schemaLevelNodeCount; i++) {
                schemas.add(getSchema(schemaLevel, schemaLevelNodeCount));
            }
            schema.setSubitems(schemas);
        }

        return schema;
    }

    private List<Integer> getScripts(int scriptCount) {
        List<Integer> scripts = new ArrayList<>();
        for (int i = 1; i <= scriptCount; i++) {
            scripts.add(Integer.MAX_VALUE);
        }
        return scripts;
    }

    private List<Operator> getOperators(int operatorCount) {
        List<Operator> operators = new ArrayList<Operator>();

        for (int i = 0; i <= operatorCount; i++) {
            operators.add(new Operator(Integer.MAX_VALUE, RandomStringUtils.randomAlphabetic(128)));
        }

        return operators;
    }

    private List<Task> getTasks(int taskCount) {
        List<Task> tasks = new ArrayList<Task>();

        for (int i = 0; i <= taskCount; i++) {
            tasks.add(new Task(
                    RandomStringUtils.randomAlphabetic(255),
                    RandomStringUtils.randomAlphabetic(64),
                    RandomStringUtils.randomAlphabetic(255),
                    RandomStringUtils.randomAlphabetic(255)));
        }

        return tasks;
    }

    private List<Schedule> getSchedules(int scheduleCount) {
        List<Schedule> schedules = new ArrayList<Schedule>();

        for (int i = 0; i <= scheduleCount; i++) {
            schedules.add(new Schedule((short) 7, (short) 24, (short) 59, (short) 24, (short) 59));
        }

        return schedules;
    }
}

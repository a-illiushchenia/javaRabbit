package executors;

import jsonPojo.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class MainCommandCreator {

    public MainCommand createMainCommand(int scriptCount, int operatorCount, int taskCount, int scheduleCount, int schemaLevel, int schemaLevelNodeCount) {
        MainCommand mainCommandResult = new MainCommand();

        mainCommandResult.setScripts(getScripts(scriptCount));
        mainCommandResult.setOperators(getOperators(operatorCount));
        mainCommandResult.setTasks(getTasks(taskCount));
        mainCommandResult.setSchedules(getSchedules(scheduleCount));
        List<Schema> schemaList = new ArrayList<>();
        schemaList.add(getSchema(schemaLevel, schemaLevelNodeCount));
        mainCommandResult.setSchemas(schemaList);

        return mainCommandResult;
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

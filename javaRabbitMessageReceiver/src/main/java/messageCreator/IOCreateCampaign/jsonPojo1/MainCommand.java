package messageCreator.IOCreateCampaign.jsonPojo1;

import java.util.List;
import java.util.Objects;

public class MainCommand {
    private int number;
    private Campaign campaign;
    private List<Integer> scripts;
    private List<Operator> operators;
    private List<Task> tasks;
    private List<Schedule> schedules;
    private List<Schema> schema;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public List<Integer> getScripts() {
        return scripts;
    }

    public void setScripts(List<Integer> scripts) {
        this.scripts = scripts;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Schema> getSchema() {
        return schema;
    }

    public void setSchemas(List<Schema> schema) {
        this.schema = schema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainCommand that = (MainCommand) o;
        return Objects.equals(campaign, that.campaign) &&
                Objects.equals(scripts, that.scripts) &&
                Objects.equals(operators, that.operators) &&
                Objects.equals(tasks, that.tasks) &&
                Objects.equals(schedules, that.schedules) &&
                Objects.equals(schema, that.schema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(campaign, scripts, operators, tasks, schedules, schema);
    }

    @Override
    public String toString() {
        return "MainCommand{" +
                "campaign=" + campaign +
                ", scripts=" + scripts +
                ", operators=" + operators +
                ", tasks=" + tasks +
                ", schedules=" + schedules +
                ", schema=" + schema +
                '}';
    }
}

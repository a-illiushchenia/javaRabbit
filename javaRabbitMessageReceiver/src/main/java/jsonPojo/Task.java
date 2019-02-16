package jsonPojo;

import java.util.Objects;

public class Task {
    private String name;
    private String number;
    private String organization;
    private String position;

    public Task(String name, String number, String organization, String position) {
        this.name = name;
        this.number = number;
        this.organization = organization;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) &&
                Objects.equals(number, task.number) &&
                Objects.equals(organization, task.organization) &&
                Objects.equals(position, task.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, organization, position);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", organization='" + organization + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

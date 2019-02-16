package jsonPojo;

import java.util.Objects;

public class Schedule {
    private Short day_of_week;
    private Short start_hour;
    private Short start_min;
    private Short end_hour;
    private Short end_min;

    public Schedule(Short day_of_week, Short start_hour, Short start_min, Short end_hour, Short end_min) {
        this.day_of_week = day_of_week;
        this.start_hour = start_hour;
        this.start_min = start_min;
        this.end_hour = end_hour;
        this.end_min = end_min;
    }

    public Short getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(Short day_of_week) {
        this.day_of_week = day_of_week;
    }

    public Short getStart_hour() {
        return start_hour;
    }

    public void setStart_hour(Short start_hour) {
        this.start_hour = start_hour;
    }

    public Short getStart_min() {
        return start_min;
    }

    public void setStart_min(Short start_min) {
        this.start_min = start_min;
    }

    public Short getEnd_hour() {
        return end_hour;
    }

    public void setEnd_hour(Short end_hour) {
        this.end_hour = end_hour;
    }

    public Short getEnd_min() {
        return end_min;
    }

    public void setEnd_min(Short end_min) {
        this.end_min = end_min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(day_of_week, schedule.day_of_week) &&
                Objects.equals(start_hour, schedule.start_hour) &&
                Objects.equals(start_min, schedule.start_min) &&
                Objects.equals(end_hour, schedule.end_hour) &&
                Objects.equals(end_min, schedule.end_min);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day_of_week, start_hour, start_min, end_hour, end_min);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "day_of_week=" + day_of_week +
                ", start_hour=" + start_hour +
                ", start_min=" + start_min +
                ", end_hour=" + end_hour +
                ", end_min=" + end_min +
                '}';
    }
}

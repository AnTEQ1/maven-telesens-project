package com.academy.telesens.lesson6.ht;

import java.util.Objects;

public class CustomDateTimeExt extends CustomDateTime{
    private int ms;

    public CustomDateTimeExt() {
        this.ms = 356;
    }

    public CustomDateTimeExt(int year, int month, int day, int hour, int minute, int second, int ms) {
        super(year, month, day, hour,minute,second);
        this.ms = ms;
    }

    public CustomDateTimeExt(CustomDateTimeExt customDateTimeExt){
        super(customDateTimeExt.getDay(), customDateTimeExt.getMonth(), customDateTimeExt.getYear(),
                customDateTimeExt.getHour(), customDateTimeExt.getMinute(), customDateTimeExt.getSecond());
        this.ms = customDateTimeExt.ms;
    }

    public void setMs(int ms){
        this.ms = ms;
    }

    public int getMs() {
        return ms;
    }

    @Override
    public String toString() {
        return "CustomDateTime{" +
                "day=" + this.getDay() +
                ", month=" + this.getMonth() +
                ", year=" + this.getYear() +
                ", hour=" + this.getHour() +
                ", minute=" + this.getMinute() +
                ", second=" + this.getSecond() +
                ", ms=" + ms +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CustomDateTimeExt that = (CustomDateTimeExt) o;
        return ms == that.ms;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ms);
    }

    @Override
    public String getFormattedDate() {
        return super.getFormattedDate() + String.format(".%03d", ms);
    }
}

package com.example.library.util;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class TimeRange {
    private Clock from;
    private Clock to;

    public TimeRange(Clock from, Clock to) {
        this.from = from;
        this.to = to;
    }

    public TimeRange() {
        this.from = Clock.systemDefaultZone();
        this.to = Clock.systemDefaultZone();
    }

    public Clock getFrom() {
        return from;
    }

    public void setFrom(Clock from) {
        this.from = from;
    }

    public Clock getTo() {
        return to;
    }

    public void setTo(Clock to) {
        this.to = to;
    }

    public long difference(Instant from, Instant to){
        ZoneId zone = ZoneId.systemDefault();

        ZonedDateTime todayInZone = from.atZone(zone);
        ZonedDateTime expirationInZone = to.atZone(zone);
        long daysTilExp = todayInZone.toLocalDate().until(expirationInZone, ChronoUnit.MINUTES);
        return daysTilExp;
    }

    @Override
    public String toString() {
        Instant instantFrom = from.instant();
        Instant instantTo = to.instant();
        return "TimeRange{" +
                "from=" + instantFrom +
                ", to=" + instantTo +
                '}';
    }
}
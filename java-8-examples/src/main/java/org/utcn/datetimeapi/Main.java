package org.utcn.datetimeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // M1: create specific date using LocalDate
        final LocalDate pastDate = LocalDate.of(2020, 5, 13);
        final LocalDate futureLocalDate = LocalDate.of(2020, 12, 16);
        System.out.println("Past local date = " + pastDate);
        System.out.println("Future local date = " + futureLocalDate);

        // M2: get current date using LocalDate
        final LocalDate currentDate = LocalDate.now();
        System.out.println("Now local date = " + currentDate);

        // operations
        System.out.println("Is 'pastLocalDate' before = " + pastDate.isBefore(currentDate));
        System.out.println("Is 'futureLocalDate' before = " + futureLocalDate.isBefore(currentDate));
        System.out.println("Is 'pastLocalDate' after = " + pastDate.isAfter(currentDate));
        System.out.println("Is 'futureLocalDate' after = " + futureLocalDate.isAfter(currentDate));
        System.out.println("Are dates equals = " + LocalDate.now().isEqual(currentDate));

        final LocalDate tomorrowLocalDate = currentDate.plusDays(1);
        final LocalDate yesterdayLocalDate = currentDate.minusDays(1);
        System.out.println("Tomorrow local date = " + tomorrowLocalDate);
        System.out.println("Yesterday local date = " + yesterdayLocalDate);

        // M1: LocalTime
        final LocalTime pastTime = LocalTime.of(10, 0, 0);
        final LocalTime futureTime = LocalTime.of(18, 0, 0);
        System.out.println("Past local time = " + pastTime);
        System.out.println("Future local time = " + futureTime);

        // M2: get local time using LocalTime
        final LocalTime currentTime = LocalTime.now();
        System.out.println("Now local time = " + currentTime);

        // operations
        System.out.println("Is 'pastTime' before = " + pastTime.isBefore(currentTime));
        System.out.println("Is 'futureTime' before = " + futureTime.isBefore(currentTime));
        System.out.println("Is 'pastTime' after = " + pastTime.isAfter(currentTime));
        System.out.println("Is 'futureTime' after = " + futureTime.isAfter(currentTime));

        final LocalTime nextHour = currentTime.plusHours(1);
        final LocalTime previousHour = currentTime.minusHours(1);
        System.out.println("Next hour = " + nextHour);
        System.out.println("Previous hour = " + previousHour);

        // M1: LocalDateTime
        final LocalDateTime pastLocalDateTime = LocalDateTime.of(2020, 5, 13, 10, 0, 0);
        final LocalDateTime futureLocalDateTime = LocalDateTime.of(2020, 12, 16, 10, 0, 0);
        System.out.println("Past local date time = " + pastLocalDateTime);
        System.out.println("Future local date time = " + futureLocalDateTime);

        // M1: get current date time using LocalDateTime
        final LocalDateTime nowLocalDateTime = LocalDateTime.now();
        System.out.println("Now local date time = " + nowLocalDateTime);

        // operations
        System.out.println("Is 'pastLocalDateTime' before = " + pastLocalDateTime.isBefore(nowLocalDateTime));
        System.out.println("Is 'futureLocalDateTime' before = " + futureLocalDateTime.isBefore(nowLocalDateTime));
        System.out.println("Is 'pastLocalDateTime' after = " + pastLocalDateTime.isAfter(nowLocalDateTime));
        System.out.println("Is 'futureLocalDateTime' after = " + futureLocalDateTime.isAfter(nowLocalDateTime));

        // add hour, minutes, seconds
        final LocalDateTime tomorrowLocalDateTime = nowLocalDateTime.plusDays(1);
        final LocalDateTime yesterdayLocalDateTime = nowLocalDateTime.minusDays(1);
        System.out.println("Tomorrow local date time = " + tomorrowLocalDateTime);
        System.out.println("Yesterday local date time = " + yesterdayLocalDateTime);
    }
}

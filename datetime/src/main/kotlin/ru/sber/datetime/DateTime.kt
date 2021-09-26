package ru.sber.datetime

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters
import java.util.*


// 1.
fun getZonesWithNonDivisibleByHourOffset(): Set<String> {
    return ZoneId.getAvailableZoneIds()
            .filter{TimeZone.getTimeZone(it).rawOffset % 3600000 != 0}.toSet()

}

// 2.
fun getLastInMonthDayWeekList(year: Int): List<String> {
    var listOfDays: ArrayList<String> = arrayListOf()
    for(i in 1..12) {

        val someYear: LocalDate = LocalDate.of(year, i, 1)
        val lastDayOfWeekInMonth = someYear.with(TemporalAdjusters.lastDayOfMonth()).dayOfWeek.name
        listOfDays.add(lastDayOfWeekInMonth)
    }

    return listOfDays
}

// 3.
fun getNumberOfFridayThirteensInYear(year: Int): Int {

    var dat = LocalDate.of(year, 1, 13)
    var counter = 0
    for (months in Month.values()) {
        if (DayOfWeek.FRIDAY == dat.dayOfWeek) {
            counter++
        }
        dat = dat.plusMonths(1)
    }

   return counter
}

// 4.
fun getFormattedDateTime(dateTime: LocalDateTime): String =
    dateTime.format (
        DateTimeFormatter
            .ofPattern("dd MMM yyyy, HH:mm")
            .withLocale(Locale.ENGLISH)
    )





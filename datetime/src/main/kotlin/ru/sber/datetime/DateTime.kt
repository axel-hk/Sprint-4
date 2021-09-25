package ru.sber.datetime

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
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
    val dayOfWeekFormatter = DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH)
    for(i in 1..12) {

        val someYear: LocalDate = LocalDate.of(year, i, 1)
        val lastDayOfWeekInMonth = someYear.with(TemporalAdjusters.lastDayOfMonth()).format(dayOfWeekFormatter)
        listOfDays.add(lastDayOfWeekInMonth.uppercase(Locale.getDefault()))

    }

    return listOfDays
}

// 3.
fun getNumberOfFridayThirteensInYear(year: Int): Int {
    val dateString = "01/13/$year"
    val dateFormat: DateFormat = SimpleDateFormat("MM/dd/yyyy")
    val date = dateFormat.parse(dateString)
    val cal = Calendar.getInstance()
    cal.time = date
    var counter = 0
    for (months in 1..12) {
        if (Calendar.FRIDAY == cal.get(Calendar.DAY_OF_WEEK)) {
            counter++
        }
        cal.add(Calendar.MONTH, 1)
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





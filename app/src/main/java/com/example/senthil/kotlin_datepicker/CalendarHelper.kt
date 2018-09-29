package com.example.senthil.kotlin_datepicker

import java.util.*

object CalendarHelper {

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }

    fun getCurrentDateInMills() : Long{
        return Calendar.getInstance().timeInMillis
    }
}
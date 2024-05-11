package com.example.foodtracker.presentation.ui.adapters

import java.util.Calendar
import java.util.Date

class CalendarAdapter {
    fun getDate(calendar: Calendar) : Date {
        return calendar.time
    }
}
package com.example.money_management1.components
import java.time.LocalDate
import java.util.Locale

class CustomDateTime {
    fun getCurrentMonthYear(): String {
        val currentMonth = LocalDate.now().month
        val monthName = currentMonth.getDisplayName(java.time.format.TextStyle.FULL,Locale.getDefault()) //displayName(TextStyle.FULL, Locale.getDefault())
        val year = LocalDate.now().year
        return "$monthName $year"
    }

}
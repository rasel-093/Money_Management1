package com.example.money_management1.components

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDatePicker(selectedDate: (String) -> Unit, openDialog:(Boolean)->Unit) {

    //val selectedDate = rememberSaveable{ mutableStateOf(LocalDate.now().toEpochMilli()) }
    val initialDateMillis = localDateToEpochMilli(LocalDate.now())
    val context = LocalContext.current

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = initialDateMillis,
        yearRange = IntRange(2023,2030),
        initialDisplayMode = DisplayMode.Picker
    )

    DatePickerDialog(
        onDismissRequest = {  },
        confirmButton = { Button(onClick = {
            if(datePickerState.selectedDateMillis != null){
                val dateMillis = datePickerState.selectedDateMillis
                val formattedDate = getDateInFormat(dateMillis!!)
                selectedDate(formattedDate)
                openDialog(false)
            }
            else
            {
                Toast.makeText(context,"Please select date",Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Confirm")
        } },
        dismissButton = { Button(onClick = { openDialog(false) }) {
            Text(text = "Cancel")
        }}
    ) {
        DatePicker(
            state = datePickerState,
            modifier = Modifier.padding(8.dp)
        )
    }
}

fun getDateInFormat(dateInMillis: Long): String {
    val instant = Instant.ofEpochMilli(dateInMillis)
    val localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate()
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    return localDate.format(formatter)
}

fun localDateToEpochMilli(localDate: LocalDate): Long {
    return Instant.ofEpochMilli(localDate.toEpochDay() * 86400000L).toEpochMilli()
}
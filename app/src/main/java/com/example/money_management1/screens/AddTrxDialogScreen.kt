package com.example.money_management1.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.money_management1.components.CustomDatePicker
import com.example.money_management1.model.TrxItem
import com.example.money_management1.model.TrxViewModel
import com.example.money_management1.ui.theme.defaultColor
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTrxDialogScreen(
    onConfirm: () -> Unit,
    onCancel: () -> Unit,
    trxViewModel: TrxViewModel
) {
    val context = LocalContext.current
    var trxTitle by rememberSaveable {
        mutableStateOf("")
    }
    var trxDetails by rememberSaveable {
        mutableStateOf("")
    }
    var trxType by rememberSaveable {
        mutableStateOf("")
    }
    var trxAmount by rememberSaveable {
        mutableStateOf("")
    }

    val currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyy")).toString()
    var selectedDate by rememberSaveable {
        mutableStateOf(currentDate)
    }

    val trxTypes = listOf("Income","Expense")
    var selectedTrxType by rememberSaveable { mutableStateOf("") }
    var selectedTrxTypeBool by rememberSaveable {
        mutableStateOf(true)
    }
    var isDatePickerOpen by rememberSaveable {
        mutableStateOf(false)
    }

    AlertDialog(
        onDismissRequest = {  },
        title = { Text(text = "Add Transaction") },
        shape = RoundedCornerShape(8.dp),
        text = {
            Column(modifier = Modifier.padding(10.dp)) {
                OutlinedTextField(
                    value = trxTitle,
                    onValueChange = { trxTitle = it },
                    label = { Text(text = "Transaction Title:") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = trxDetails,
                    onValueChange = { trxDetails = it },
                    label = { Text(text = "Transaction Details:") },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 2
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = trxAmount,
                    onValueChange = { trxAmount = it },
                    label = { Text(text = "Transaction Amount:") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = selectedDate,
                    onValueChange = { selectedDate = it },
                    label = { Text(text = "Select Date") },
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        IconButton(onClick = {
                            isDatePickerOpen = true
                        }) {
                            Icon(imageVector = Icons.Default.DateRange,
                                contentDescription = null
                            )
                        }
                       }
                )
                if(isDatePickerOpen){
                    CustomDatePicker(
                        selectedDate = {selectedDate = it},
                        openDialog = {isDatePickerOpen = false})
                }
                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    trxTypes.forEach { type ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = (type == selectedTrxType),
                                onClick = {
                                    selectedTrxType = type
                                    selectedTrxTypeBool = if(type == trxTypes[0]) true else false
                                    //Log.d("Selected option", selectedOptionBool.toString())
                                }
                            )
                            Text(
                                text = type,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))

            }
        },
        confirmButton = {
            Button(
                onClick = {
                    //Save data to database
                    if(trxAmount.isNotEmpty()  && trxTitle.isNotEmpty() && selectedTrxType.isNotEmpty()){
                        val trxItem = TrxItem(
                            title = trxTitle,
                            details = trxDetails,
                            date = selectedDate,
                            amount = trxAmount.toInt(),
                            type = selectedTrxTypeBool
                        )
                        trxViewModel.inserTrx(trxItem)
                        onConfirm()
                    }
                    else Toast.makeText(context,"Fill in all fields",Toast.LENGTH_SHORT).show()
                },
                colors = ButtonDefaults.buttonColors(containerColor = defaultColor)
            ) {
                Text(text = "Save")
            }
        },
        dismissButton = {
            Button(
                onClick = onCancel,
                colors = ButtonDefaults.buttonColors(containerColor = defaultColor)
            ) {
                Text(text = "Cancel")
            }
        }
    )
}

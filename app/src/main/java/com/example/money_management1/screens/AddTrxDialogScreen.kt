package com.example.money_management1.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.example.money_management1.components.CustomDatePicker
import com.example.money_management1.model.ExpenseCategory
import com.example.money_management1.model.IncomeCategory
import com.example.money_management1.model.savingmodel.SavingItem
import com.example.money_management1.model.savingmodel.SavingItemViewModel
import com.example.money_management1.model.trxmodel.TrxItem
import com.example.money_management1.model.trxmodel.TrxViewModel
import com.example.money_management1.ui.theme.defaultColor
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTrxDialogScreen(
    onConfirm: () -> Unit,
    onCancel: () -> Unit,
    trxViewModel: TrxViewModel,
    savingItemViewModel: SavingItemViewModel
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
    var isDropDownMenuExpanded by rememberSaveable {
        mutableStateOf(false)
    }

    var dropDownButtonText by rememberSaveable {
        mutableStateOf("Select Category")
    }
    //Income category variable
    val incomeCategories = IncomeCategory.values().toList()
    val incomeCategoryList = mutableListOf<String>()
    for (index in incomeCategories.indices){
        incomeCategoryList.add(incomeCategories[index].label)
    }
    //Expense Category variable
    val expenseCategories = ExpenseCategory.values().toList()
    val expenseCategoryList = mutableListOf<String>()
    for (index in expenseCategories.indices){
        expenseCategoryList.add(expenseCategories[index].label)
    }
    var activeCategorySelector by rememberSaveable {
        mutableStateOf("")
    }
    var selectedCategory by rememberSaveable {
        mutableStateOf("")
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

                //Income Expense radio buttona
                Row {
                    trxTypes.forEach { type ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = (type == selectedTrxType),
                                onClick = {
                                    selectedTrxType = type
                                    selectedTrxTypeBool = if(type == trxTypes[0]) true else false
                                    activeCategorySelector = type
                                    selectedCategory = ""
                                    dropDownButtonText = "Select Category"
                                    Log.d("Selected option", type)
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
                IconButton(
                    onClick = { isDropDownMenuExpanded = true },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = dropDownButtonText)
                        Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = null )
                    }
                }
                //Income Expense category selector dropdown
                DropdownMenu(
                    expanded = isDropDownMenuExpanded,
                    onDismissRequest = { isDropDownMenuExpanded = false },
                    properties = PopupProperties(
                        focusable = true,
                        dismissOnBackPress = true,
                        dismissOnClickOutside = true
                    ),
                    modifier = Modifier.height(250.dp)
                    ) {
                    if(activeCategorySelector.isNotEmpty()){
                        val list =  if(activeCategorySelector == "Income") incomeCategoryList else expenseCategoryList
                        for(i in list.indices){
                            DropdownMenuItem(
                                text = { Text(text = list[i]) } ,
                                onClick = {
                                    isDropDownMenuExpanded = false
                                    dropDownButtonText = list[i]
                                    selectedCategory = list[i]
                                })
                        }
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
//                    if(selectedCategory == "Savings"){
//                        val items = savingItemViewModel.allSavingItems.value
//                        val item = SavingItem(
//                            title = items!![0].title,
//                            details = items[0].details,
//                            req_amount = items[0].req_amount,
//                            current_amount = items[0].current_amount+trxAmount.toInt(),
//                            isCompleted = if(items[0].current_amount >= items[0].req_amount) true else false ,
//                            imageUri = items[0].imageUri
//                        )
//                        Log.d("Saving","$trxAmount added")
//                        savingItemViewModel.updateSavingItem(item)
//                    }
                    //Save data to database
                    if(trxAmount.isNotEmpty()  && trxTitle.isNotEmpty() && selectedTrxType.isNotEmpty() && selectedCategory.isNotEmpty()){
                        val trxItem = TrxItem(
                            title = trxTitle,
                            details = trxDetails,
                            date = selectedDate,
                            amount = trxAmount.toInt(),
                            type = selectedTrxTypeBool,
                            category = selectedCategory
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

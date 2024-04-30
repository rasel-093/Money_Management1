package com.example.money_management1.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.money_management1.components.TopBar
import com.example.money_management1.components.charts.CustomPieChart
import com.example.money_management1.components.charts.randomColor
import com.example.money_management1.model.ExpenseCategory
import com.example.money_management1.model.IncomeCategory
import com.example.money_management1.model.Month
import com.example.money_management1.model.trxmodel.TrxViewModel

@Composable
fun OverViewScreen(paddingValues: PaddingValues, trxViewModel: TrxViewModel) {
    Scaffold(
        topBar = { TopBar(title = "Overview") },
        modifier = Modifier.padding(paddingValues)
    ) { innerPadding ->
        //Common variable
        val colors = mutableListOf<Color>()
        for(i in 0..12){colors.add(randomColor())}

        //Variable for Expense Category
        val expenseCategories = ExpenseCategory.entries
        val expenseCategoryLabels = mutableListOf<String>()
        for (i in 0..12){ expenseCategoryLabels.add(expenseCategories[i].label) }
        val expenseCategoryValues = remember {
            mutableStateListOf(0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f,0f)
        }

        //Variable for Income Category
        val incomeCategories = IncomeCategory.entries
        val incomeCategoryLabels = mutableListOf<String>()
        for (i in 0..4){ incomeCategoryLabels.add(incomeCategories[i].label) }
        val incomeCategoryValues = remember{
            mutableStateListOf(0f,0f,0f,0f,0f)
        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            incomeCategoryLabels.forEachIndexed{index, trxType->
                var amount: Int
                trxViewModel.getEachIncomeAmount(trxType) {
                    amount = it ?: 0
                    println("$trxType -> $amount")
                    //incomeCategoryValues.removeAt(index)
                    incomeCategoryValues.add(index, amount.toFloat()) //add(amount.toFloat())
                    incomeCategoryValues.removeAt(index+1)
                    Log.d("Added", "$amount added as $trxType")
                }
            }

            expenseCategoryLabels.forEachIndexed{index, trxType->
                var amount: Int
                trxViewModel.getEachExpenseAmount(trxType) {
                    amount = it ?: 0
                    println("$trxType -> $amount")
                    //incomeCategoryValues.removeAt(index)
                    expenseCategoryValues.add(index, amount.toFloat()) //add(amount.toFloat())
                    expenseCategoryValues.removeAt(index+1)
                    Log.d("Added", "$amount added as $trxType")
                }
            }

            ChartTitleText(text = "Monthly Income")
            CustomPieChart(incomeCategoryLabels, incomeCategoryValues, colors )
            Spacer(modifier = Modifier.height(20.dp))
            ChartTitleText(text = "Monthly Expense")
           CustomPieChart(expenseCategoryLabels, expenseCategoryValues, colors)
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun ChartTitleText(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.SansSerif
        )
    )
}
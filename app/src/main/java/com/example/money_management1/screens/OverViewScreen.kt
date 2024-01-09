package com.example.money_management1.screens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.money_management1.components.TopBar
import com.example.money_management1.components.charts.CustomGroupedBarChart
import com.example.money_management1.components.charts.CustomPieChart
import com.example.money_management1.components.charts.randomColor
import com.example.money_management1.model.ExpenseCategory
import com.example.money_management1.model.IncomeCategory
import com.example.money_management1.model.Month

@Composable
fun OverViewScreen(paddingValues: PaddingValues) {
    Scaffold(
        topBar = { TopBar(title = "OverView") },
        modifier = Modifier.padding(paddingValues)
    ) { innerPadding ->

        //Common variable
        val colors = mutableListOf<Color>()
        for(i in 0..9){colors.add(randomColor())}
        //Variable for Expense Category
        val expenseCategories = ExpenseCategory.entries
        val expenseCategoryLabels = mutableListOf<String>()
        for (i in 0..9){ expenseCategoryLabels.add(expenseCategories[i].label) }
        val expenseCategoryValues = listOf( 40f, 25f, 35f, 30f, 50f, 34f, 32f,75f,94f,43f)

        //Variable for Income Category
        val incomeCategories = IncomeCategory.entries
        val incomeCategoryLabels = mutableListOf<String>()
        for (i in 0..4){ incomeCategoryLabels.add(incomeCategories[i].label) }
        val incomeCategoryValues = listOf( 40f, 25f, 35f, 30f, 50f)

        //variable for grouped bar graph
        val monthList = Month.entries
        val monthLabels = mutableListOf<String>()
        for(i in 0..11){ monthLabels.add(monthList[i].month)}

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            ChartTitleText(text = "Monthly Income")
            CustomPieChart(incomeCategoryLabels, incomeCategoryValues, colors )
            Spacer(modifier = Modifier.height(20.dp))
            ChartTitleText(text = "Monthly Expense")
            CustomPieChart(expenseCategoryLabels, expenseCategoryValues, colors)
            Spacer(modifier = Modifier.height(20.dp))
            ChartTitleText(text = "Yearly Income-Expense")
            CustomGroupedBarChart(monthLabels)
            Spacer(modifier = Modifier.padding(20.dp))
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
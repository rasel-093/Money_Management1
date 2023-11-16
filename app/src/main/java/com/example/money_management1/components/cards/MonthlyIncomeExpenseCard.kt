package com.example.money_management1.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MonthlyIncomeExpenseCard() {
    OutlinedCard(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            //.padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF50E3C2))
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CardText(text = "Jan 2023", fontSize = 24, Color(0xFFFFFFFF))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                CardText(text = "Income", fontSize = 16, Color(0xFFFFFFFF))
                CardText(text = "2000", fontSize = 16, Color(0xFFFFFFFF) )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                CardText(text = "Expenses", fontSize = 16, Color(0xFFFFFFFF) )
                CardText(text = "1400", fontSize = 16 , Color(0xFFFFFFFF))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CardText(text = "Your Balance", fontSize = 16, Color(0xFFFFFFFF) )
                CardText(text = "10000", fontSize = 16 , Color(0xFFFFFFFF))
            }
        }
    }
}

@Composable
@Preview
fun pMonthlyIncomeExpenseCardPreview() {
    MonthlyIncomeExpenseCard()
}

@Composable
fun CardText(text: String,fontSize: Int, color: Color) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold,
        color = color
    )
}
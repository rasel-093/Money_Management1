package com.example.money_management1.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.money_management1.components.CustomDateTime
import com.example.money_management1.model.TrxItem
import com.example.money_management1.ui.theme.redFont
import com.example.money_management1.ui.theme.whiteFont

@Composable
fun TrxHistoryHeadingCard(trxItems: List<TrxItem>) {
    //To count details for Heading card
    var totalIncome = 0
    var totalExpense = 0
    var currentBalance = 0
    trxItems.forEachIndexed{index, trxItem ->
        if(trxItems[index].type){
            totalIncome = totalIncome + trxItems[index].amount
            currentBalance += trxItems[index].amount
        }
        else {
            totalExpense = totalExpense + trxItems[index].amount
            currentBalance -= trxItems[index].amount
        }
    }
    OutlinedCard(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
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
                CardText(text = CustomDateTime().getCurrentMonthYear(), fontSize = 24, whiteFont)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                CardText(text = "Income", fontSize = 16, color = whiteFont)
                CardText(text = totalIncome.toString(), fontSize = 16, color = whiteFont )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                CardText(text = "Expenses", fontSize = 16, color = whiteFont )
                CardText(text =  totalExpense.toString(), fontSize = 16 , color = whiteFont)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CardText(text = "Your Balance", fontSize = 16, color = if (currentBalance<0) redFont else whiteFont )
                CardText(text = currentBalance.toString(), fontSize = 16 , color = if (currentBalance<0) redFont else whiteFont)
            }
        }
    }
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
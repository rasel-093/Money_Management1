package com.example.money_management1.components.cards

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.money_management1.IncomeExpenseDetailsActivity
import com.example.money_management1.R
import com.example.money_management1.model.Item

@Composable
fun MonthlyHistoryCard(item: Item){
    val context = LocalContext.current
    OutlinedCard(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
            .clickable {
                val intent = Intent(context,IncomeExpenseDetailsActivity::class.java)
                context.startActivity(intent)
                Toast.makeText(context,"Item Clicked",Toast.LENGTH_SHORT).show()
            }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(0.2f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.money_bag),
                    contentDescription = null
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CardText(text = item.title, fontSize = 24 , color = Color(0xFF2C3F50))
                    CardText(text = item.amount, fontSize = 20, color = Color(0xFF2C3F50))
                }
                CardText(text = item.date, fontSize = 16, color = Color(0xFF2C3F50) )
            }
        }
    }
}
//@Composable
//@Preview
//fun MonthlyHistoryCardPreview(){
//    MonthlyHistoryCard()
//}
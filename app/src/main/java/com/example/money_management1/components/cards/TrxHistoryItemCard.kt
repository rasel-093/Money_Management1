package com.example.money_management1.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.money_management1.R
import com.example.money_management1.model.TrxItem
import com.example.money_management1.ui.theme.blackFont
import com.example.money_management1.ui.theme.redFont

@Composable
fun TrxHistoryItemCard(trxItem: TrxItem, index: Int, onClick: (Boolean,Int) -> Unit){
    val context = LocalContext.current
    ElevatedCard (
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xffffffff)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
            .clickable {
                onClick(true , index)
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
                    CardText(text = trxItem.title, fontSize = 24 , color = blackFont)
                    Row {
                        CardText(
                            text = "${trxItem.amount}",
                            fontSize = 20,
                            color = if(trxItem.type) blackFont else redFont
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.taka_icon) ,
                            contentDescription = null,
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                }
                CardText(text = trxItem.date, fontSize = 16, color = blackFont )
            }
        }
    }
}
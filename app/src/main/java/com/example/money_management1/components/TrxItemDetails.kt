package com.example.money_management1.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.money_management1.model.TrxItem
import com.example.money_management1.ui.theme.defaultColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrxItemDetails(trxItem: TrxItem, onDelete: () -> Unit, onClose: ()->Unit) {
    AlertDialog(
        onDismissRequest = {  }
    ){
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp,
                pressedElevation = 6.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor =  Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                TitleText(text = trxItem.title)
                BodyText(text = trxItem.details)
                BodyText(text = trxItem.amount.toString())
                BodyText(text = trxItem.date)
                BodyText(text = trxItem.type.toString())
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextButton(
                    onClick = onDelete,
                    //modifier = Modifier.align(Alignment.End),
                ) {
                    Text(
                        text = "Delete",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = defaultColor
                    )
                }
                TextButton(
                    onClick = onClose,
                    //modifier = Modifier.align(Alignment.End),
                ) {
                    Text(
                        text = "Close",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = defaultColor
                    )
                }
            }
        }
    }
}
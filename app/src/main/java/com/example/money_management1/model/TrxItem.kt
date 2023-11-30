package com.example.money_management1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trxItem_table")
data class TrxItem(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo("title") var title: String,
    @ColumnInfo("details") var details: String,
    @ColumnInfo("date") var date: String,
    @ColumnInfo("amount") var amount: Int,
    @ColumnInfo("type") val type: Boolean
)
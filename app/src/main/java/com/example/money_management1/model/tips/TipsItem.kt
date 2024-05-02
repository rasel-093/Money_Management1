package com.example.money_management1.model.tips

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tips_table")
data class TipsItem(
    @PrimaryKey(autoGenerate = true)
    val tipsId: Int? = null,
    @ColumnInfo("tips")val tips: String
)
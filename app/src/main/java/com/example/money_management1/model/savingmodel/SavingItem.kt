package com.example.money_management1.model.savingmodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saving_list")
data class SavingItem(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("details") val details: String,
    @ColumnInfo("req_amount") val req_amount: Int,
    @ColumnInfo("current_amount") val current_amount: Int,
    @ColumnInfo("is_completed") val isCompleted: Boolean = false,
    @ColumnInfo("image_path") val image_Path: String?
)

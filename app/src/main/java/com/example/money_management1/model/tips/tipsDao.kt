package com.example.money_management1.model.tips

import androidx.lifecycle.LiveData
import androidx.room.Query

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface TipsDao {
    @Query("SELECT * FROM tips_table")
    fun getAll(): LiveData<List<TipsItem>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTips(tipsItem: TipsItem)
}
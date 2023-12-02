package com.example.money_management1.model.savingmodel

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface SavingItemDao{

    //Query for saving table
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertSaving(savingItem: SavingItem)
    @Query("SELECT * FROM saving_list")
    fun getAllSavings(): LiveData<List<SavingItem>>

    @Update
    suspend fun updateSaving(savingItem: SavingItem)
    @Delete
    suspend fun deleteSaving(savingItem: SavingItem)
}
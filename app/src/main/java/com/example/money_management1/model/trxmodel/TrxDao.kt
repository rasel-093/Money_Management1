package com.example.money_management1.model.trxmodel

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TrxDao {

    //Query for Transaction table
    @Query("SELECT * FROM trxItem_table")
    fun getAll(): LiveData<List<TrxItem>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(trxItem: TrxItem)
    @Delete
    suspend fun delete(trxItem: TrxItem)
    @Update
    suspend fun update(trxItem: TrxItem)
    @Query("DELETE FROM trxItem_table")
    suspend fun deleteAll()
}

package com.example.money_management1.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.money_management1.model.savingmodel.SavingItem
import com.example.money_management1.model.savingmodel.SavingItemDao
import com.example.money_management1.model.trxmodel.TrxDao
import com.example.money_management1.model.trxmodel.TrxItem

@Database(entities = [TrxItem::class, SavingItem::class], version = 1, exportSchema = false)
abstract class TrxDB: RoomDatabase() {
    abstract fun trxDao(): TrxDao
    abstract fun savingItemDao(): SavingItemDao
    companion object{
        private var INSTANCE: TrxDB? = null

        fun getInstance(context: Context): TrxDB{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TrxDB::class.java,
                        "trx_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
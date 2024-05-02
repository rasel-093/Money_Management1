package com.example.money_management1.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.money_management1.model.savingmodel.SavingItem
import com.example.money_management1.model.savingmodel.SavingItemDao
import com.example.money_management1.model.tips.TipsDao
import com.example.money_management1.model.tips.TipsItem
import com.example.money_management1.model.trxmodel.TrxDao
import com.example.money_management1.model.trxmodel.TrxItem

@Database(entities = [TrxItem::class, SavingItem::class, TipsItem::class], version = 2, exportSchema = false)
abstract class AppDB: RoomDatabase() {
    abstract fun trxDao(): TrxDao
    abstract fun savingItemDao(): SavingItemDao
    abstract fun tipsDao(): TipsDao
    companion object{
        private var INSTANCE: AppDB? = null

        fun getInstance(context: Context): AppDB {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDB::class.java,
                        "trx_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
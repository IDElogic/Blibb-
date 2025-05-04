package se.android.blibb.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import se.android.blibb.data.local.dao.ProductDao
import se.android.blibb.domain.model.ProductItem

@Database(entities = [ProductItem::class], version = 2)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

}
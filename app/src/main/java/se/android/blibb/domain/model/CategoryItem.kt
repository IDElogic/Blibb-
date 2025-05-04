package se.android.blibb.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import se.android.blibb.utils.Constants.CATEGORY_DATABASE_TABLE

@Entity(tableName = CATEGORY_DATABASE_TABLE)
data class CategoryItem(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val image: Int,
    val unit: String,
    val price: Double,
    var isCart: Boolean = false
)

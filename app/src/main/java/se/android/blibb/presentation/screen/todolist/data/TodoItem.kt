package  se.android.blibb.presentation.screen.todolist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import se.android.blibb.R

@Entity(tableName = "todotable")
data class TodoItem(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "createdate") var createDate: String,
    @ColumnInfo(name = "todopriority") var priority: TodoPriority,
    @ColumnInfo(name = "isdone") var isDone: Boolean,
    @ColumnInfo(name = "ispaid") var isPaid: Boolean = false // Új mező
)

enum class TodoPriority {
    HIGH, NORMAL;

    fun getIcon(): Int {
        // The this is the value of this enum object
        return if (this == NORMAL) R.drawable.ic_launcher_foreground else R.drawable.ic_launcher_foreground
    }
}



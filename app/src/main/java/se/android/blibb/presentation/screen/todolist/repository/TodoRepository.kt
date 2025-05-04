package se.android.blibb.presentation.screen.todolist.repository

import kotlinx.coroutines.flow.Flow
import se.android.blibb.presentation.screen.todolist.data.TodoItem

interface TodoRepository {
    fun getAllTodosStream(): Flow<List<TodoItem>>

    fun getTodoStream(id: Int): Flow<TodoItem?>

    suspend fun insertTodo(todo: TodoItem)

    suspend fun deleteTodo(todo: TodoItem)

    suspend fun deleteAllTodos()

    suspend fun updateTodo(todo: TodoItem)
}
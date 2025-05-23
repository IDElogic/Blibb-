package se.android.blibb.presentation.screen.todolist.repository

import kotlinx.coroutines.flow.Flow
import se.android.blibb.presentation.screen.todolist.data.TodoDAO
import se.android.blibb.presentation.screen.todolist.data.TodoItem
import javax.inject.Inject

class RoomTodoRepository @Inject constructor(
    private val todoDAO: TodoDAO
) : TodoRepository {
    override fun getAllTodosStream(): Flow<List<TodoItem>> {
        return todoDAO.getAllTodos()
    }

    override fun getTodoStream(id: Int): Flow<TodoItem?> {
        return todoDAO.getTodo(id)
    }

    override suspend fun insertTodo(todo: TodoItem) {
        todoDAO.insert(todo)
    }

    override suspend fun deleteTodo(todo: TodoItem) {
        todoDAO.delete(todo)
    }

    override suspend fun deleteAllTodos() {
        todoDAO.deleteAllTodos()
    }

    override suspend fun updateTodo(todo: TodoItem) {
        todoDAO.update(todo)
    }
}
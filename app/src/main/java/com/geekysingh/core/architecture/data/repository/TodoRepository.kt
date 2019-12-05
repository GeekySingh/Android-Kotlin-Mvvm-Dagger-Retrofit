package com.geekysingh.core.architecture.data.repository

import com.geekysingh.core.architecture.domain.entity.TodoEntity
import com.geekysingh.core.architecture.domain.remote.response.ApiResponse
import com.geekysingh.core.architecture.domain.repository.BaseTodoRepository
import com.geekysingh.core.architecture.domain.service.TodoService
import javax.inject.Inject

class TodoRepository @Inject constructor(private val service: TodoService) : BaseTodoRepository(service) {

    override suspend fun getTodoList(todoId: Int): ApiResponse<TodoEntity> {
        return handleRequest { service.getTotoDetails(todoId) }
    }
}
package com.geekysingh.core.architecture.domain.repository

import com.geekysingh.core.architecture.domain.entity.TodoEntity
import com.geekysingh.core.architecture.domain.remote.response.ApiResponse
import com.geekysingh.core.architecture.domain.repository.base.IRepository
import com.geekysingh.core.architecture.domain.service.TodoService

abstract class BaseTodoRepository(service: TodoService) : IRepository {

    abstract suspend fun getTodoList(todoId : Int) : ApiResponse<TodoEntity>

}
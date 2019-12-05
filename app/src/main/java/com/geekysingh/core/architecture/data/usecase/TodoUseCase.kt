package com.geekysingh.core.architecture.data.usecase

import com.geekysingh.core.architecture.data.mapper.TodoApiResponseMapper
import com.geekysingh.core.architecture.data.model.TodoModel
import com.geekysingh.core.architecture.data.repository.TodoRepository
import com.geekysingh.core.architecture.domain.remote.response.ApiResponse
import com.geekysingh.core.architecture.domain.usecase.base.BaseUseCase
import javax.inject.Inject

class TodoUseCase @Inject constructor(private val repository: TodoRepository,
                                      private val mapper : TodoApiResponseMapper
) : BaseUseCase(repository) {

    suspend fun getTodoList(todoId: Int): ApiResponse<TodoModel> {
        val response = repository.getTodoList(todoId)
        return mapper.map(response)!!
    }
}
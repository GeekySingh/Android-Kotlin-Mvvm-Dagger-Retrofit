package com.geekysingh.core.architecture.data.mapper

import com.geekysingh.core.architecture.data.mapper.base.BaseMapper
import com.geekysingh.core.architecture.data.model.TodoModel
import com.geekysingh.core.architecture.domain.entity.TodoEntity
import com.geekysingh.core.architecture.domain.remote.response.ApiResponse
import com.geekysingh.core.architecture.domain.remote.response.ErrorResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoApiResponseMapper @Inject constructor(private val mapper : TodoEntityToModelMapper)
    : BaseMapper<ApiResponse<TodoEntity>, ApiResponse<TodoModel>>() {

    override fun map(entity: ApiResponse<TodoEntity>?): ApiResponse<TodoModel>? {
        entity?.let {
            if(it.isSuccessful)
                return ApiResponse.Success(mapper.map(it.data))
            else
                return ApiResponse.Failure(it.errorResponse)
        }
        return ApiResponse.Failure(ErrorResponse())
    }
}
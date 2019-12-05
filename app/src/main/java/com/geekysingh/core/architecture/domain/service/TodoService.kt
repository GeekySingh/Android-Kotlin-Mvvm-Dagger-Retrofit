package com.geekysingh.core.architecture.domain.service

import com.geekysingh.core.architecture.domain.entity.TodoEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TodoService {

    @GET("https://jsonplaceholder.typicode.com/todos/{todoId}")
    suspend fun getTotoDetails(@Path("todoId") todoId : Int) : Response<TodoEntity>

}
package com.geekysingh.core.architecture.data.mapper

import com.geekysingh.core.architecture.data.mapper.base.BaseMapper
import com.geekysingh.core.architecture.data.model.TodoModel
import com.geekysingh.core.architecture.domain.entity.TodoEntity
import javax.inject.Inject

class TodoEntityToModelMapper @Inject constructor() : BaseMapper<TodoEntity, TodoModel>() {

    override fun map(entity: TodoEntity?): TodoModel? {
        entity?.let {
            return TodoModel(it.completed, it.id, it.title)
        }
        return null
    }
}
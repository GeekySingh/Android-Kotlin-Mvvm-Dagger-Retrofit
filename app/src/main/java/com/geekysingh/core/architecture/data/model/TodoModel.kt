package com.geekysingh.core.architecture.data.model

data class TodoModel(
    val completed: Boolean,
    val id: Int,
    val title: String
) {
    override fun toString(): String {
        return "Title: $title,\n Completed: $completed"
    }
}
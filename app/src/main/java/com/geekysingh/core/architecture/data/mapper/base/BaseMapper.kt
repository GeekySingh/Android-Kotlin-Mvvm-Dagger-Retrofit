package com.geekysingh.core.architecture.data.mapper.base

abstract class BaseMapper<Entity, Model> {

    abstract fun map(entity: Entity?) : Model?

    open fun reverseMap(model: Model?) : Entity? {
        throw UnsupportedOperationException("Method not implemented")
    }

    fun map(entityList: List<Entity>) : List<Model> {
        val modelList = arrayListOf<Model>()
        entityList.forEach {
            map(it)?.let {
                modelList.add(it)
            }
        }
        return modelList
    }

    fun reverseMap(modelList: List<Model>) : List<Entity> {
        val entityList = arrayListOf<Entity>()
        modelList.forEach {
            reverseMap(it)?.let {
                entityList.add(it)
            }
        }
        return entityList
    }
}
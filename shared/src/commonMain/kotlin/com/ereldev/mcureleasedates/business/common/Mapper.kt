package com.ereldev.mcureleasedates.business.common

abstract class Mapper<F, T> {

    abstract fun from(from: F): T

    fun to(to: T): F {
        throw Exception("Mapper.to() not implemented")
    }

}
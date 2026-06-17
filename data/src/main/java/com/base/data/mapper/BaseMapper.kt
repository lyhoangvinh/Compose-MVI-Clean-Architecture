package com.base.data.mapper

interface BaseMapper<DTO, DomainModel> {
    fun DTO.toDomain(): DomainModel
    fun DomainModel.toDto(): DTO
}

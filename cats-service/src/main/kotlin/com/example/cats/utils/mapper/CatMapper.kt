package com.example.cats.utils.mapper

import com.example.cats.dto.CatDto
import com.example.cats.entity.Cat
import org.springframework.stereotype.Service

@Service
class CatMapper : Mapper<CatDto, Cat> {

    override fun fromEntity(entity: Cat): CatDto = CatDto(
        entity.id,
        entity.name,
        entity.breed
    )

    override fun toEntity(domain: CatDto): Cat = Cat(
        domain.id,
        domain.name,
        domain.breed
    )

}
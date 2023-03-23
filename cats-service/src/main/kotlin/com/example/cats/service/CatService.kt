package com.example.cats.service

import com.example.cats.dto.CatDto


interface CatService {


    fun createCat(catDto: CatDto): CatDto

    fun getCats(): List<CatDto>

    fun getCat(id: Int): CatDto

    fun updateCat(id: Int, catDto: CatDto): CatDto

    fun deleteCat(id: Int)

}
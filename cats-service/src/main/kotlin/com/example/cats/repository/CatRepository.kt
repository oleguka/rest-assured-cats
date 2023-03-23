package com.example.cats.repository

import com.example.cats.entity.Cat
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CatRepository : CrudRepository<Cat, Int> {

    @Query("SELECT m FROM Cat as m")
    fun getAllCats(): List<Cat>

}
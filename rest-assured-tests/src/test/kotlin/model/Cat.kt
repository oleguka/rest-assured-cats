package model

import com.fasterxml.jackson.annotation.JsonInclude


@JsonInclude(JsonInclude.Include.NON_NULL)
data class Cat(
    val id: Int? = null,
    val name: String,
    val breed: String,
)
package utils

import io.restassured.response.Response
import io.restassured.response.ValidatableResponse

//Функция-расширение для преобразования тела ответа в класс
inline fun <reified T> ValidatableResponse.extractAs(): T {
    return this.extract().body().`as`(T::class.java)
}

//Функция-расширение для преобразования тела ответа в класс
inline fun <reified T> Response.extractAs(): T {
    return this.then().extract().body().`as`(T::class.java)
}

//Функция-расширение для получения id из тела ответа
fun Response.getId(path: String = "id"): Int {
    return this.jsonPath().getInt(path)
}
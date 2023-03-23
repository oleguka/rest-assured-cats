package steps

import Specs.requestSpec
import Specs.responseSpec
import io.qameta.allure.Step
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response
import model.Cat
import java.util.*

object CatSteps {

    @Step("Добавление котика")
    fun addCat(cat: Cat): Response {
        return Given {
            spec(requestSpec)
        } When {
            body(cat)
            post("/cat")
        } Then {
            spec(responseSpec)
        } Extract {
            response()
        }
    }

    @Step("Получение котика")
    fun getCat(id: Int): Response {
        return Given {
            spec(requestSpec)
        } When {
            queryParam("id", id)
            get("/cat")
        } Then {
            spec(responseSpec)
        } Extract {
            response()
        }
    }

    @Step("Обновление данных котика")
    fun updateCat(id: Int, cat: Cat): Response {
        return Given {
            spec(requestSpec)
        } When {
            body(cat.copy(id = id))
            put("/cat")
        } Then {
            spec(responseSpec)
        } Extract {
            response()
        }
    }

    @Step("Удаление котика")
    fun deleteCat(id: Int): Response {
        return Given {
            spec(requestSpec)
        } When {
            queryParam("id", id)
            delete("/cat")
        } Then {
            spec(responseSpec)
        } Extract {
            response()
        }
    }

}
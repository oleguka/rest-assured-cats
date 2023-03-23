package catTests

import BaseTest
import model.Cat
import model.CatResponse
import steps.CatSteps.addCat
import steps.CatSteps.getCat
import utils.extractAs
import utils.getId
import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@Epic("Котик")
@Feature("Получение котика")
class GetCatTest : BaseTest() {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Получение котика")
    fun getSimpleCat() {
        val cat = Cat(name = "plotva", breed = "II — RAG")
        val catId = addCat(cat).getId()
        When {
            getCat(catId)
        } Then {
            statusCode(200)
            val catResponse = extractAs<CatResponse>()
            assertThat(catResponse.name).isEqualTo(cat.name)
            assertThat(catResponse.breed).isEqualTo(cat.breed)
        }
    }
}
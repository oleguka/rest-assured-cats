package catTests

import BaseTest
import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import model.Cat
import model.CatResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import steps.CatSteps.addCat
import steps.CatSteps.getCat
import steps.CatSteps.updateCat
import utils.extractAs

@Epic("Котик")
@Feature("Обновление полей котика")
class UpdateCatTest : BaseTest() {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("У котика отображаются обновленные поля")
    fun updateSimpleCat() {
        val cat = Cat(name = "paule", breed = "III — RUS")
        val updatedCat = Cat(name = "paulie", breed = "II — SBI")
        val catId = addCat(cat).extractAs<CatResponse>().id
        When {
            updateCat(catId, updatedCat)
            getCat(catId)
        } Then {
            val catResponse = extractAs<CatResponse>()
            assertThat(catResponse.name).isEqualTo(updatedCat.name)
            assertThat(catResponse.breed).isEqualTo(updatedCat.breed)
        }
    }

}
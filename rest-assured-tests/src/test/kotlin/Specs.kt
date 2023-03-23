import config.Config
import io.restassured.builder.RequestSpecBuilder
import io.restassured.builder.ResponseSpecBuilder
import io.restassured.config.LogConfig
import io.restassured.config.RestAssuredConfig
import io.restassured.filter.log.LogDetail
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import io.restassured.specification.ResponseSpecification

object Specs {

    private val logConfig = LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)
    private val config = RestAssuredConfig.config().logConfig(logConfig)

    val requestSpec: RequestSpecification = RequestSpecBuilder()
        .setBaseUri(Config.url)
        .setPort(Config.port)
        .addHeader("Accept", "application/json")
        .setContentType(ContentType.JSON)
        .setConfig(config)
        .build()

    val responseSpec: ResponseSpecification = ResponseSpecBuilder()
        .log(LogDetail.BODY)
        .build()

}
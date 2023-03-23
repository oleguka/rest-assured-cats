package config

object Config {
    val url: String = System.getProperty("URL")
    val port: Int = System.getProperty("PORT").toInt()
}
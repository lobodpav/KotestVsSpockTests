package cz.lobodinsti.test.user

data class User @JvmOverloads constructor(
    val id: Long,
    val username: String,
    val age: Int = 18,
)

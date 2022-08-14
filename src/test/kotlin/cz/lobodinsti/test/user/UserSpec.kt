package cz.lobodinsti.test.user

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class UserSpec : StringSpec({

    "User is awesome" {
        val user1 = User(1, "pavel")
        val user2 = User(1, "pavel")

        with(user1) {
            id shouldBe 1
            username shouldBe "pavel"
            age shouldBe 18
        }

        user1 shouldBe user2
    }
})
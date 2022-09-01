package cz.lobodinsti.test.user

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class UserServiceSpec : DescribeSpec({
    // shared state / functions for all tests
    val userService = UserService()

    describe("createUser") {
        // shared state / functions for all createUser tests

        it("should create famous user") {
            // state / functions for famous user test
            userService.createUser(true).run {
                username shouldBe "Zeman"
                age shouldBe 78
            }
        }

        it("should create ordinary user") {
            // state / functions for ordinary user test
            userService.createUser(false).run {
                username shouldBe "Tonda"
                age shouldBe 37
            }
        }
    }

    describe("oldifyUser") {
        // shared state / functions for all oldifyUser tests
        val petricek = User(0, "Petricek", 1)

        it("should make Petricek old") {
            userService.oldifyUser(petricek, false).run {
                username shouldBe petricek.username
                age shouldBe 70
            }
        }

        it("should make Petricek dead") {
            userService.oldifyUser(petricek, true).run {
                username shouldBe petricek.username
                age shouldBe 135
            }
        }
    }
})
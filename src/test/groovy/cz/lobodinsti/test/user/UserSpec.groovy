package cz.lobodinsti.test.user

import cz.lobodinsti.test.user.User
import spock.lang.Specification

class UserSpec extends Specification {

    def "User is awesome"() {
        when:
        def user1 = new User(1, "pavel")
        def user2 = new User(1, "pavel")

        then:
        with(user1) {
            id       == 1
            username == "pavel"
            age      == 18
        }

        and:
        user1 == user2
    }
}

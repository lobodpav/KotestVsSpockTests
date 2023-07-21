package cz.lobodinsti.test.user

import spock.lang.Specification

class UserServiceSpec extends Specification {

    def userService = new UserService()

    def "should create famous user"() {
        when:
        def user = userService.createUser(true)

        then:
        verifyAll(user) {
            username == "Zeman"
            age == 78
        }
    }

    def "should create ordinary user"() {
        when:
        def user = userService.createUser(false)

        then:
        verifyAll(user) {
            username == "Tonda"
            age == 37
        }
    }

    def "should create user"() {
        when:
        def user = userService.createUser(famous)

        then:
        verifyAll(user) {
            id == expectedId
            username == expectedUsername
            age == expectedAge
        }

        where:
        famous | expectedId | expectedUsername | expectedAge
        true   | 0          | "Zeman"          | 78
        false  | 1          | "Tonda"          | 37
    }

    def "should make Petricek old"() {
        given:
        def petricek = new User(0, "Petricek", 1)

        when:
        def oldifiedUser = userService.oldifyUser(petricek, false)

        then:
        verifyAll(oldifiedUser) {
            username == petricek.username
            age == 70
        }
    }

    def "should make Petricek dead"() {
        given:
        def petricek = new User(0, "Petricek", 1)

        when:
        def oldifiedUser = userService.oldifyUser(petricek, true)

        then:
        verifyAll(oldifiedUser) {
            username == petricek.username
            age == 135
        }
    }
}

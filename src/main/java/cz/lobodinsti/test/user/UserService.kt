package cz.lobodinsti.test.user

class UserService {
    fun createUser(famous: Boolean): User =
        if (famous)
            User(0, "Zeman", 78)
        else
            User(1, "Tonda", 37)

    fun oldifyUser(user: User, deadOld: Boolean): User =
        if (deadOld)
            user.copy(age = 135)
        else
            user.copy(age = 70)
}
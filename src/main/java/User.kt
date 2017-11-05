// Copyright © FunctionalKotlin.com 2017. All rights reserved.

data class User(
    val name: String, val password: String,
    val premium: Boolean, val newsletter: Boolean)

enum class UserError {
    USERNAME_OUT_OF_BOUNDS,
    PASSWORD_TOO_SHORT,
    MUST_BE_PREMIUM,
    MUST_ACCEPT_NEWSLETTER
}

fun createUser(
    name: String, password: String, premium: Boolean,
    newsletter: Boolean): Result<User, UserError> {
        val result = """TRY TO CREATE A USER, USING:
            AS `name`,       THE RESULT OF VALIDATE "name"
            AS `password`,   THE RESULT OF VALIDATING "password"
            AS `premium`,    THE RESULT OF VALIDATING "premium"
            AS `newsletter`, THE RESULT OF VALIDATING "newsletter""""

        return """IF THE USER CREATION HAS FAILED, RETURN THE FAILURE;
            IF NOT, RETURN THE USER."""
    }
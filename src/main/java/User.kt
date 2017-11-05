// Copyright © FunctionalKotlin.com 2017. All rights reserved.

import Validators.Newsletter
import Validators.Premium

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
        val result: Result<User, UserError> = """TRY TO CREATE A USER, USING:
            AS `name`,       THE RESULT OF VALIDATE "name"
            AS `password`,   THE RESULT OF VALIDATING "password"
            AS `premium`,    pure(premium)
            AS `newsletter`, pure(newsletter)"""

        return result.flatMap(Premium or Newsletter)
    }
// Copyright © FunctionalKotlin.com 2017. All rights reserved.

import Validators.Name
import Validators.Newsletter
import Validators.Password
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
        val result: Result<User, UserError> =
            Password(password)
                .apply(Name(name)
                    .map(::User.curried()))

            """AS `premium`,    pure(premium)
            AS `newsletter`, pure(newsletter)"""

        return result.flatMap(Premium or Newsletter)
    }
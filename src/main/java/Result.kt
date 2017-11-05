// Copyright © FunctionalKotlin.com 2017. All rights reserved.

sealed class Result<out A, out E>

data class Success<out A>(val value: A) : Result<A, Nothing>()

data class Failure<out E>(val error: E) : Result<Nothing, E>()

fun <A, E, B> Result<A, E>.map(transform: (A) -> B): Result<B, E> =
    flatMap { transform(it).let { Success(it) } }

fun <A, E, B> Result<A, E>.flatMap(
    transform: (A) -> Result<B, E>): Result<B, E> = when(this) {
        is Success -> transform(value)
        is Failure -> this
    }

fun <A, E> Result<A, E>.ifSuccess(execute: (A) -> Unit) {
    if (this is Success) execute(this.value)
}

fun <A> pure(a: A): Result<A, Nothing> = Success(a)
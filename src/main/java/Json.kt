import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import java.io.StringReader
import kotlin.reflect.KClass

fun parse(json: String): JsonObject =
    Parser().parse(StringReader(json)) as JsonObject

sealed class ParseError

data class NotFound(val key: String): ParseError()

data class NotCastable<A: Any>(val key: String, val type: KClass<A>): ParseError()

fun notFound(key: String): Failure<NotFound> = Failure(NotFound(key))

inline fun <reified A: Any> notCastable(key: String): Failure<NotCastable<A>> =
    Failure(NotCastable(key, A::class))

inline fun <reified A: Any> JsonObject
    .getValue(key: String): Result<A, ParseError> {

    val value = this[key] ?: return notFound(key)

    return (value as? A)?.let(::Success)
        ?: notCastable<A>(key)
}
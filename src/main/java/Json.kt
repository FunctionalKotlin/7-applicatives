import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import java.io.StringReader

fun parse(json: String): JsonObject =
    Parser().parse(StringReader(json)) as JsonObject
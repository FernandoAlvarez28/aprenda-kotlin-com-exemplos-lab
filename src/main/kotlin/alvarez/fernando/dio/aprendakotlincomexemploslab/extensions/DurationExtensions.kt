package alvarez.fernando.dio.aprendakotlincomexemploslab.extensions

import java.lang.StringBuilder
import java.time.Duration

fun Duration.format(): String {
    val stringBuilder = StringBuilder()

    if (toHours() != 0L) {
        stringBuilder.append(toHours().formatPlurality("hora"))
    }

    if (toMinutesPart() != 0) {
        if (stringBuilder.isNotEmpty()) stringBuilder.append(" e ")
        stringBuilder.append(toMinutesPart().formatPlurality("minuto"))
    }

    return stringBuilder.toString()
}

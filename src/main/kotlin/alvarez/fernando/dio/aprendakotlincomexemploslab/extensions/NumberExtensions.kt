package alvarez.fernando.dio.aprendakotlincomexemploslab.extensions

object LongSequence {
    private var longSequence = 0L

    fun next(): Long {
        return ++longSequence
    }
}

fun Number.formatPlurality(singular: String, plural: String = "${singular}s"): String {
    return formatPlurality(
        singularFormat = { "$it $singular" },
        pluralFormat = { "$it $plural" },
    )
}

fun Number.formatPlurality(singularFormat: (Number) -> String, pluralFormat: (Number) -> String): String {
    return if (this.toLong() == 1L) {
        singularFormat.invoke(this)
    } else {
        pluralFormat.invoke(this)
    }
}

/**
 * @see <a href="https://stackoverflow.com/a/26954454">Fonte</a>
 */
fun Double.asPercentage(): String = String.format("%.2f%%", this)

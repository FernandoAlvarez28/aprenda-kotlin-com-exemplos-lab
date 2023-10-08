package alvarez.fernando.dio.aprendakotlincomexemploslab.domain

import alvarez.fernando.dio.aprendakotlincomexemploslab.extensions.format
import java.time.Duration

data class ConteudoEducacional(
    val nome: String,
    val duracao: Duration = Duration.ofHours(1),
    val palavrasChaves: List<String>,
) {

    override fun toString(): String {
        return "\"$nome\" (duração de ${duracao.format()})"
    }
}

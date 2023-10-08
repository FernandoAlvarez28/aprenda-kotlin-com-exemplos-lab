package alvarez.fernando.dio.aprendakotlincomexemploslab.domain

import alvarez.fernando.dio.aprendakotlincomexemploslab.extensions.asPercentage

class AlunoProgressoFormacao(
    val aluno: Aluno,
    val formacao: Formacao,
    var progresso: Double = 0.0,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AlunoProgressoFormacao

        if (aluno != other.aluno) return false
        if (formacao != other.formacao) return false

        return true
    }

    override fun hashCode(): Int {
        var result = aluno.hashCode()
        result = 31 * result + formacao.hashCode()
        return result
    }

    override fun toString(): String {
        return "\"$formacao\" (${progresso.asPercentage()} concluído)"
    }
}

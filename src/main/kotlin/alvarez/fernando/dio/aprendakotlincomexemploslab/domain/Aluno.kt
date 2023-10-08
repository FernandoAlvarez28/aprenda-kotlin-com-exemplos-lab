package alvarez.fernando.dio.aprendakotlincomexemploslab.domain

import alvarez.fernando.dio.aprendakotlincomexemploslab.extensions.LongSequence

data class Aluno(
    val id: Long = LongSequence.next(),
    val nome: String,
) {

    private val formacoesMatriculadas = linkedSetOf<AlunoProgressoFormacao>()

    fun formacoesMatriculadas(): Set<AlunoProgressoFormacao> = formacoesMatriculadas

    fun registrarMatricula(formacao: Formacao) {
        this.formacoesMatriculadas.add(
            AlunoProgressoFormacao(
                aluno = this,
                formacao = formacao,
            ),
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Aluno

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "$nome (ID $id)"
    }
}

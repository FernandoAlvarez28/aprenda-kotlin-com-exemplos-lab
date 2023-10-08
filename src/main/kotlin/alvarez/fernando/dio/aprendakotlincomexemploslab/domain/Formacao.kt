package alvarez.fernando.dio.aprendakotlincomexemploslab.domain

import alvarez.fernando.dio.aprendakotlincomexemploslab.extensions.formatPlurality
import java.util.TreeSet
import java.util.UUID

data class Formacao(
    val uuid: UUID = UUID.randomUUID(),
    val nome: String,
    val nivel: Nivel,
    val conteudos: List<ConteudoEducacional>,
) {

    val palavrasChaves: Set<String> = TreeSet(this.conteudos.flatMap { it.palavrasChaves })
    private val alunosInscritos = mutableSetOf<Aluno>()

    fun matricular(vararg alunos: Aluno): Boolean {
        val alunos = alunos.asList()

        println(
            "Matriculando ${alunos.size.formatPlurality("aluno")} na formação \"$nome\": " +
                alunos,
        )

        val alunosParaMatricular = alunos - this.alunosInscritos
        val matriculasRealizadas = this.alunosInscritos.addAll(alunos)
        alunosParaMatricular.map { it.registrarMatricula(this) }

        if (matriculasRealizadas) {
            println(
                alunosParaMatricular.size.formatPlurality("matrícula realizada", "matrículas realizadas") +
                    " com sucesso!",
            )
        } else {
            println(
                "Nenhuma matrícula realizada: ${alunos.size.formatPlurality(
                    singularFormat = { "o aluno já estava matriculado" },
                    pluralFormat = { "os $it alunos já estavam matriculados" },
                )}",
            )
        }
        println("Alunos atualmente matriculados: ${alunosInscritos.size}")

        return matriculasRealizadas
    }

    fun exibirConteudos() {
        for (conteudo in this.conteudos) {
            println("\t$conteudo")
        }
    }

    fun exibirTudo() {
        println(this.toString())
        this.exibirConteudos()
        println("Palavras chaves: $palavrasChaves")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Formacao

        return uuid == other.uuid
    }

    override fun hashCode(): Int {
        return uuid.hashCode()
    }

    override fun toString(): String {
        return "Formação \"$nome\" de nível ${nivel.nome.lowercase()} " +
            "com atualmente ${alunosInscritos.size.formatPlurality(
                "aluno inscrito",
                "alunos inscritos",
            )}"
    }

    enum class Nivel(
        val nome: String,
    ) {
        BASICO("Básico"),
        INTERMEDIARIO("Intermediário"),
        AVANCADO("Avançado"),
    }
}

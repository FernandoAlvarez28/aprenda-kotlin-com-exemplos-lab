package alvarez.fernando.dio.aprendakotlincomexemploslab

import alvarez.fernando.dio.aprendakotlincomexemploslab.domain.Aluno
import alvarez.fernando.dio.aprendakotlincomexemploslab.domain.ConteudoEducacional
import alvarez.fernando.dio.aprendakotlincomexemploslab.domain.Formacao
import java.time.Duration
import java.util.concurrent.TimeUnit

fun main() {
    println("Bem vindo!")
    simularDelay(1)
    println("Carregando dados...")

    val alunos = criarAlunos()
    val (fernando, alex, testerson, nicole) = alunos

    val formacoes = criarFormacoes()
    val (kotlinIniciantes, kotlinJaveiros, kotlinSpring, cloud) = formacoes

    simularDelay(1)

    println()
    println("Alunos:")
    alunos.forEach { println("\t$it") }

    println()

    println("Formações:")
    formacoes.forEach {
        it.exibirTudo()
        println()
    }

    kotlinIniciantes.matricular(testerson, nicole, testerson)
    kotlinJaveiros.matricular(fernando, alex)
    kotlinJaveiros.matricular(fernando, alex) // Propositalmente para testar a não duplicidade de matrícula
    kotlinSpring.matricular(fernando)
    cloud.matricular(alex)
    cloud.matricular(alex)
    println()

    println("Formações atualizadas:")
    formacoes.forEach {
        println(it)
    }

    println()
    println("Alunos atualizados:")
    alunos.forEach {
        println("$it matriculado(a) em:")
        it.formacoesMatriculadas().forEach { formacao ->
            println("\t$formacao")
        }
    }
}

private fun simularDelay(segundos: Int) {
    TimeUnit.SECONDS.sleep(segundos.toLong())
}

private fun criarAlunos(): MutableList<Aluno> {
    return mutableListOf(
        Aluno(nome = "Fernando"),
        Aluno(nome = "Alex"),
        Aluno(nome = "Testerson"),
        Aluno(nome = "Nicole"),
    )
}

private fun criarFormacoes(): List<Formacao> {
    val conteudoKotlin = ConteudoEducacional(
        nome = "Kotlin",
        duracao = Duration.ofHours(3),
        palavrasChaves = listOf("kotlin"),
    )
    val conteudoAlgoritmos = ConteudoEducacional(
        nome = "Algoritmos",
        duracao = Duration.ofHours(2).plusMinutes(30),
        palavrasChaves = listOf("algoritmo"),
    )
    val conteudoInteroperabilidadeKotlinJava = ConteudoEducacional(
        nome = "Interoperabilidade Kotlin e Java",
        duracao = Duration.ofHours(3).plusMinutes(20),
        palavrasChaves = listOf("kotlin", "java"),
    )
    val conteudoSpringFramework = ConteudoEducacional(
        nome = "Framework Spring",
        duracao = Duration.ofHours(4),
        palavrasChaves = listOf("spring"),
    )
    val conteudoSpringCloud = ConteudoEducacional(
        nome = "Spring Cloud",
        duracao = Duration.ofHours(5),
        palavrasChaves = listOf("spring", "cloud"),
    )
    val conteudoDocker = ConteudoEducacional(
        nome = "Conteinerização com Docker",
        duracao = Duration.ofHours(1).plusMinutes(30),
        palavrasChaves = listOf("docker"),
    )
    val conteudoCloudAws = ConteudoEducacional(
        nome = "Cloud com Amazon Web Services",
        duracao = Duration.ofHours(3),
        palavrasChaves = listOf("cloud", "aws", "amazon", "codebuild", "ecs", "ci"),
    )

    return listOf(
        Formacao(
            nome = "Kotlin para iniciantes",
            nivel = Formacao.Nivel.BASICO,
            conteudos = listOf(
                conteudoAlgoritmos,
                conteudoKotlin,
            ),
        ),
        Formacao(
            nome = "Kotlin para Javeiros",
            nivel = Formacao.Nivel.BASICO,
            conteudos = listOf(
                conteudoKotlin,
                conteudoInteroperabilidadeKotlinJava,
            ),
        ),
        Formacao(
            nome = "Kotlin com Spring Boot",
            nivel = Formacao.Nivel.INTERMEDIARIO,
            conteudos = listOf(
                conteudoKotlin,
                conteudoInteroperabilidadeKotlinJava,
                conteudoSpringFramework,
            ),
        ),
        Formacao(
            nome = "Zero to Hero: Desenvolvendo uma aplicação completa na Nuvem com Kotlin e Spring!",
            nivel = Formacao.Nivel.AVANCADO,
            conteudos = listOf(
                conteudoKotlin,
                conteudoInteroperabilidadeKotlinJava,
                conteudoSpringFramework,
                conteudoSpringCloud,
                conteudoDocker,
                conteudoCloudAws,
            ),
        ),
    )
}

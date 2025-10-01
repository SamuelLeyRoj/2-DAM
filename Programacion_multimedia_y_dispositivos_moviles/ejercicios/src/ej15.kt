import java.util.stream.Collectors
import java.util.stream.Stream

fun main() {
    val listaNumeros = mutableListOf(1,2,3,4,5,6,7,8,9,10)

    val listaFiltradaMultiplicada = listaNumeros
        .filter { it % 2 == 0 }
        .map { it * 2 }

    println(listaFiltradaMultiplicada)
}


fun main(args: Array<String>) {

    var listaNumeros = mutableListOf<Int>()
    listaNumeros.add(1);listaNumeros.add(2);listaNumeros.add(3);listaNumeros.add(4);listaNumeros.add(5)


    println(listaEnterosMultiplicados(listaNumeros))
}

fun listaEnterosMultiplicados(lista:MutableList<Int> ): List<Int>{

    var listaNumerosMultiplicadoss = lista.map { it * 2}

    return listaNumerosMultiplicadoss;

}

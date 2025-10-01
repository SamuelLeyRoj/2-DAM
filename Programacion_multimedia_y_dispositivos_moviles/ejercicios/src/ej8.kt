
    fun main(args: Array<String>) {
        val listaNumeros = listOf(1,2,3,4,5)
        var listaVocales  = mutableListOf("A","B","C","D","E","F")

        for (i in listaNumeros) {
            println(i)
            listaVocales.add(i.toString())

        }

        println(listaVocales)
        listaVocales.remove("A")
        println(listaVocales)
    }

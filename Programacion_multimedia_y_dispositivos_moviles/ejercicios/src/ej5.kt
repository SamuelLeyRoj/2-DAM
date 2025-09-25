fun main(args: Array<String>) {

    var numero1 : Int = 0
    println("Ingrese un número: ")

    numero1 = readLine()!!.toInt()

    if (numero1 >0) {
        println("El número es positivo")
    }else if (numero1 ==0) {
        println("El número es igual cero")
    }else {
        println("El número es negativo")
    }
}
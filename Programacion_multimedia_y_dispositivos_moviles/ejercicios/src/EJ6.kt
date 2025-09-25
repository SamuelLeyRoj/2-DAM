fun main(){

    println("Elija un número: ")
    var num1=readLine()!!.toInt()

    when (num1){
        1 -> println("Lunes")
        2 -> println("Martes")
        3 -> println("Miercoles")
        4 -> println("Jueves")
        5 -> println("Viernes")
        6 -> println("Sabado")
        7 -> println("Domingo")
        else -> println("Número no valido")
    }
}
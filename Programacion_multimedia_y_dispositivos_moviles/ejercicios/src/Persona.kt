class Persona {

    var nombre:String? = null
    var edad : Int? = null




    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Persona

        if (edad != other.edad) return false
        if (nombre != other.nombre) return false

        return true
    }

    override fun hashCode(): Int {
        var result = edad ?: 0
        result = 31 * result + (nombre?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Persona(nombre=$nombre, edad=$edad)"
    }


}
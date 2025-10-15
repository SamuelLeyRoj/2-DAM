class Coche {

    var marca: String
    var modelo: String
    var anyo: Int


    constructor(marca: String, modelo: String, anyo: Int) {
        this.marca = marca
        this.modelo = modelo
        this.anyo = anyo
    }

    // Constructor secundario
    constructor(marca: String) {
        this.marca = marca
        this.modelo = "Desconocido"
        this.anyo = 0
    }

    override fun toString(): String {
        return "Coche(marca='$marca', modelo='$modelo', anyo=$anyo)"
    }


}
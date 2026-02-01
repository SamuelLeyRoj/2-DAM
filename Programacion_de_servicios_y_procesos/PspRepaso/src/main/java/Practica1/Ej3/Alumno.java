package Practica1.Ej3;

import java.io.Serializable;

public class Alumno implements Serializable {

    private String idAlumno;
    private String nombre;
    private Curso curso;
    private int nota;



    public Alumno(String idAlumno, String nombre, Curso curso, int nota) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.curso = curso;
        this.nota = nota;
    }


    public Alumno() {

    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "idAlumno='" + idAlumno + '\'' +
                ", nombre='" + nombre + '\'' +
                ", curso=" + curso +
                ", nota=" + nota +
                '}';
    }
}



















/*
*Crea una clase de nombre Curso, con los siguientes atributos:

Crea otra clase de nombre Alumno, con los siguientes atributos:

Crea en las clases anteriores los constructores y métodos get y set necesarios.
Utilizando sockets UDP crea un programa servidor que inicialice un array de 5
objetos de tipos Alumno. Invéntate los datos, cada objeto Alumno deberá tener un
idalumno distinto, igualmente cada curso tiene su id. El soervidor se ejecutará en un

2

bucle infinito, recibirá del cliente un idalumno y le devolverá el objeto Alumno que
corresponda con ese identificador. El servidor debe visualizar el identificador solicitado
por el cliente.
Crea un programa cliente en el que se introduzca por teclado el idalumno que
se desea consultar (el programa realizará la lectura en un proceso repetitivo hasta que
el idalumno leído por teclado sea *). Se enviará al servidor el idalumno a consultar. El
servidor le devolverá un objeto Alumno con los datos solicitados. Si el alumno no
existe, también le devolverá un objeto Alumno con datos que indiquen que el alumno
no existe. El cliente debe visualizar todos los datos recibidos, incluidos el curso del
alumno.
* */
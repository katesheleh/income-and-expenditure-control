public class Ingreso extends Dinero {

    // Constructor en el que inicializarán los valores recibidos por parámetros
    public Ingreso(double ingreso, String description) {
        this.dinero = ingreso;
        this.description = description;
    }

    @Override
    // devolver el contenido del constructor
    public String toString() {
        return this.description + ": " + this.dinero;
    }
}

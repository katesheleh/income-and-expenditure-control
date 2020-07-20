public class Gasto extends Dinero {

    // Constructor en el que inicializarán los valores recibidos por parámetros
    public Gasto(double gasto, String description) {
        this.dinero = gasto;
        this.description = description;
    }

    @Override
    // devolver el contenido del constructor
    public String toString() {
        return this.description + ": " + this.dinero;
    }
}

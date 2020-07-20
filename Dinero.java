public abstract class Dinero {
    // Asignación de las variables
    protected double dinero;
    protected String description;

    // Coger el valor de dinero
    public double getDinero() {
        return dinero;
    }

    // Guardar el valor de dinero
    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    // Coger el valor de la descripción
    public String getDescription() {
        return description;
    }

    // Guardar el valor de la descripción
    public void setDescription(String description) {
        this.description = description;
    }
}

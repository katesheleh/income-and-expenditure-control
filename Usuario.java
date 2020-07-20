public class Usuario {
    // Asignación de las variables
    private String nombre;
    private int edad;
    private String DNI;

    // Constructor por defecto
    public Usuario() {
    }

    // Coger el nombre del usuario
    public String getNombre() {
        return nombre;
    }

    // Asignar el nombre del usuario
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Coger la edad del usuario
    public int getEdad() {
        return edad;
    }

    // Asignar la edad del usuario
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Coger el valor de DNI
    public String getDNI() {
        return DNI;
    }

    // Asignar el valor de DNI
    public boolean setDNI(String DNI) {
        // Comprobación de formato de DNI.
        if (!DNI.matches("[0-9]{8}[a-zA-Z]|[0-9]{8}[-][a-zA-Z]")) {
            return false;
        }
        // Guardar el DNI. Cambiar el formato toUpperCase.
        this.DNI = DNI.toUpperCase();
        return true;
    }

    // Los datos del usuario
    @Override
    public String toString() {
        return "nombre: " + this.getNombre() + '\n' + "edad: " + this.getEdad() + '\n' + "DNI: " + this.getDNI();
    }
}

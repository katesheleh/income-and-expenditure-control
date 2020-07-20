// Import de la librería para usar List
import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    // Asignación de las variables
    private double saldo;
    private Usuario usuario;
    private List<Gasto> gastos = new ArrayList<>();
    private List<Ingreso> ingresos = new ArrayList<>();

    // Asignar el usuario
    public Cuenta(Usuario usuario) {
        this.usuario = usuario;
        this.saldo = 0; /* saldo inicial de 0€ */
    }

    // Coger el valor de saldo actual
    public double getSaldo() {
        return saldo;
    }

    // Guardar / actualizar el valor de saldo actual
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Coger los datos del usuario
    public Usuario getUsuario() {
        return usuario;
    }

    // Guardar los datos del usuario
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Aumentar saldo de la cuenta un nuevo ingreso
    public double addIngresos(String description, double cantidad) {
        ingresos.add(new Ingreso(cantidad, description));
        this.saldo += cantidad;
        return this.saldo;
    }

    // Reducir saldo de la cuenta un nuevo gasto
    public double addGastos(String description, double cantidad) {
        gastos.add(new Gasto(cantidad, description));
        this.saldo -= cantidad;
        return this.saldo;
    }

    // coger los valores de ingresos
    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    // coger los valores de gastos
    public List<Gasto> getGastos() {
        return gastos;
    }

    // Devolver saldo actual del usuario
    public String toString() {
        return "Saldo actual: " + this.saldo;
    }
}

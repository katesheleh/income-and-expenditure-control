// La clase para mostrar el mensaje al usuario si el gasto supera el saldo actual
public class GastoException extends Exception {
    public GastoException() {
        super("Gastos no pueden superar saldo actual");
    }
}

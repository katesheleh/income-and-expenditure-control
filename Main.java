// Importar de las librerías necesarias

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Asignación de las variables
        Scanner scanner = new Scanner(System.in);
        int eleccion = 0;
        String desc = "";
        double cant = 0;

        // Crear una instancia de la clase Usuario
        Usuario usuario = new Usuario();

        // Crear una instancia de la clase Cuenta
        Cuenta cuenta = new Cuenta(usuario);

        // Interactuaríamos col el usuario para coger y guardar sus datos
        System.out.println("Introduce el nombre de usuario: ");
        usuario.setNombre(scanner.nextLine());

        System.out.println("Introduce la edad del usuario: ");
        usuario.setEdad(scanner.nextInt());

        // comprobar el valor de edad. Volver a preguntarlo hasta que el valor no sea mayor de 0.
        while (usuario.getEdad() <= 0) {
            System.err.println("La edad no puede ser igual o menos de 0" + '\n' + "Introduce la edad en el formato correcto: ");
            usuario.setEdad(scanner.nextInt());
        }

        System.out.println("Introduce el DNI del usuario: ");
        usuario.setDNI(scanner.nextLine());

        // Pedir al usuario introducir el DNI en el formato correcto hasta que el usuario no lo cumpla
        while (!usuario.setDNI(scanner.nextLine())) {
            System.err.println("DNI introducido incorrecto " + '\n' + "Introduce el DNI del usuario valido: ");
        }
        // Mensaje para el usuario en caso del formato correcto.
        System.out.println("Usuario creado correctamente ");

        // Mostrar los datos del usuario después de crear la cuenta
        System.out.println(cuenta.getUsuario());

        // Visualización del menú con las instrucciones
        do {
            System.out.println("Realiza una nueva accion");
            System.out.println("1 Introduce un nuevo gasto");
            System.out.println("2 Introduce un nuevo ingreso");
            System.out.println("3 Mostrar gastos");
            System.out.println("4 Mostrar ingresos");
            System.out.println("5 Mostrar saldo");
            System.out.println("0 Salir");

            // Guardar el número introducido en la variable
            eleccion = scanner.nextInt();

            // Hacer las operaciones según la elección del usuario
            switch (eleccion) {
                case 0:
                    System.out.println("Fin del programa" + '\n' + "Gracias por utilizar la aplicación.");
                    break;

                case 1:
                    // Crear una instancia del Gasto con valores por defecto para poder usarlo como un 'template' para añadir los gastos
                    Gasto spending = new Gasto(0.0, "");

                    // Preguntar al usuario la description de gasto y guardarlo
                    System.out.println("Introduce la description: ");
                    scanner.nextLine();
                    desc = scanner.nextLine();
                    spending.setDescription(desc);

                    // Preguntar al usuario la cantidad de dinero y guardarlo
                    System.out.println("Introduce la cantidad: ");
                    cant = scanner.nextDouble();
                    scanner.nextLine();
                    spending.setDinero(cant);

                    // Al añadir un nuevo gasto se compruebe si se dispone de saldo suficiente, en caso contrario se lanza una excepción.
                    try {
                        if (cant > cuenta.getSaldo()) {
                            throw new GastoException();
                        } else {
                            // añadir y guardar los datos en un array.
                            cuenta.addGastos(desc, cant);

                            // mostrar el resultado de la operación
                            System.out.println("Gasto '" + spending.getDescription() + "' se ha añadido correctamente." +
                                    '\n' + "Pulsa a tecla 3 para consultar tus gastos" + '\n');
                        }
                    } catch (GastoException ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;

                case 2:
                    // Crear una instancia del Ingreso con valores por defecto para poder usarlo como un 'template' para añadir los ingresos
                    Ingreso entry = new Ingreso(0.0, "");

                    // Preguntar al usuario la description de ingreso y guardarlo
                    System.out.println("Introduce la description: ");
                    // doble scanner para 'reparar' erroneo comportamiento de Scanner
                    scanner.nextLine();
                    desc = scanner.nextLine();
                    entry.setDescription(desc);

                    // Preguntar al usuario la cantidad de dinero y guardarlo
                    System.out.println("Introduce la cantidad: ");
                    // doble scanner para 'reparar' erroneo comportamiento de Scanner
                    cant = scanner.nextDouble();
                    scanner.nextLine();
                    entry.setDinero(cant);

                    // añadir y guardar los datos en un array.
                    cuenta.addIngresos(desc, cant);

                    // mostrar el resultado de la operación
                    System.out.println("Ingreso '" + entry.getDescription() + "' se ha añadido correctamente." +
                            '\n' + "Pulsa a tecla 4 para consultar tus ingresos" + '\n');
                    break;

                case 3:
                    // mostrar un warning en caso de empty array
                    if (cuenta.getGastos().size() == 0) {
                        System.err.println("No se ha realizado ningun tipo de gasto. " + '\n' + "Pulsa la tecla '1' para añadirlo" + '\n');
                    } else {
                        // mostrar los datos uno por uno
                        for (int i = 0; i < cuenta.getGastos().size(); i++) {
                            System.out.println(cuenta.getGastos().get(i));
                        }
                    }
                    break;

                case 4:
                    // mostrar un warning en caso de empty array
                    if (cuenta.getIngresos().size() == 0) {
                        System.err.println("No se ha realizado ningun tipo de ingreso. " + '\n' + "Pulsa la tecla '2' para añadirlo" + '\n');
                    } else {
                        // mostrar los datos uno por uno
                        for (int i = 0; i < cuenta.getIngresos().size(); i++) {
                            System.out.println(cuenta.getIngresos().get(i));
                        }
                    }
                    break;

                case 5:
                    // Mostrar saldo actual
                    System.out.println(cuenta.toString());
                    break;

                // Mostrar el mensaje si el usuario teclea un valor que esta fuera de los disponibles
                default:
                    System.err.println("Introduce un valor valido: de 0 hasta 5");
            }
        } while (eleccion != 0);
    }
}

import java.util.Scanner;

public class TiendaOnline {
    public static void main(String[] args) {
        final String NOMBRE = "David";
        final String CONTRASENA = "Dorado";

        boolean login = false;
        int opcion;
        int confirmacion;

        //Fecha y hora
        int dia = 0;
        int mes = 0;
        int anho = 0;

        int dia2 = 0;
        int mes2 = 0;
        int anho2 = 0;

        int hora = 0;
        int minutos = 0;

        // Lugares
        String origen = "";
        String destino = "";

        //Pasajeros
        int pasajeros = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Iniciar sesión");

        // Iniciar sesión
        do {
            System.out.print("Nombre de usuario: ");
            String user = sc.next();
            System.out.print("Contraseña: ");
            String password = sc.next();

            if (user.equals(NOMBRE) && password.equals(CONTRASENA)) {
                System.out.println("Cargando menú... \n");
                login = true;
            } else {
                System.out.println("La contraseña o el usuario no es correcto. Por favor, vuelve a introducirlo \n");
            }
        } while (!login);

        // Menú
        do {
            mostrarMenu();

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: // Crear viaje
                    // Pedir fecha
                    System.out.println("Introduce la fecha de viaje");
                    System.out.print("Día: ");
                    dia = sc.nextInt();
                    System.out.print("Mes: ");
                    mes = sc.nextInt();
                    System.out.print("Año: ");
                    anho = sc.nextInt();
                    // Pedir hora
                    System.out.println("Introduce la hora de viaje");
                    System.out.print("Hora: ");
                    hora = sc.nextInt();
                    System.out.print("Minutos: ");
                    minutos = sc.nextInt();
                    // Lugares
                    System.out.print("Origen: ");
                    origen = sc.next();
                    System.out.print("Destino: ");
                    destino = sc.next();
                    // Pasajeros
                    System.out.print("Cantidad de pasajeros: ");
                    pasajeros = sc.nextInt();
                    // Confirmación
                    System.out.print("¿Quieres confirmar el viaje? (1. Sí 2. No):");
                    confirmacion = sc.nextInt();
                    if (confirmacion == 1) {
                        System.out.println("Se ha confirmado el viaje de " + origen + " a " + destino);
                    } else {
                        pasajeros = 0;
                        origen = null;
                        destino = null;
                    }
                    break;

                case 2: // Apuntar viaje
                    System.out.println("Introduce la fecha de viaje");
                    System.out.print("Día: ");
                    dia2 = sc.nextInt();
                    System.out.print("Mes: ");
                    mes2 = sc.nextInt();
                    System.out.print("Año: ");
                    anho2 = sc.nextInt();
                    if (pasajeros < 5 && dia == dia2 && mes2 == mes && anho == anho2 && origen != null && destino != null) {
                        System.out.println("Hay un viaje disponible para el día " + dia + "/" + mes + "/" + anho + " a las " + hora + " y " + minutos);
                        System.out.println("De origen " + origen + " con destino a " + destino);
                        System.out.println("Pasajeros disponibles: " + (5 - pasajeros));

                        System.out.print("¿Quieres confirmar el viaje? (1. Sí 2. No): ");
                        confirmacion = sc.nextInt();
                        if (confirmacion == 1) {
                            pasajeros++;
                            System.out.println("Se ha confirmado el viaje \n");
                        } else {
                            System.out.println("Se ha cancelado el viaje \n");
                        }
                    } else {
                        System.out.println("No hay un viaje disponible");
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    System.out.println("¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Has seleccionado una opción inválida");
                    break;
            }

        } while (opcion != 3);

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("Menú principal");
        System.out.println("===============");
        System.out.println("1. Crear un viaje");
        System.out.println("2. Quiero apuntarme a un viaje");
        System.out.println("3. Salir \n");
        System.out.print("Elige una opción: ");
    }
}

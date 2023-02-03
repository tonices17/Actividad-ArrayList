import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void imprimirMenu() {
        System.out.println("--------------------- MENÚ ---------------------");
        System.out.println("0 - Salir del menú");
        System.out.println("1 - Para imprimir contactos");
        System.out.println("2 - Para agregar un nuevo contacto");
        System.out.println("3 - Para actualizar un contacto existente");
        System.out.println("4 - Para eliminar un contacto existente");
        System.out.println("5 - Para buscar un contacto en la lista");
        System.out.println("6 - Para volver a imprimir la lista de opciones");
    }
    public static void main(String[]args){
        boolean continuar = true, valido = true;
        String nombre,numero,opcion = null;
        TelefonoMovil Mio = new TelefonoMovil("123456789");

        while(continuar) {
            do {
                valido = true;
                imprimirMenu();
                System.out.println("-----------------------------------------------");
                System.out.println("Elige una opción: ");
                opcion = scanner.nextLine();
                    if (!opcion.matches("[0-6]")) {
                        System.out.println("Opción no válida.");
                        valido = false;
                    }
                } while (!valido) ;

            switch (opcion) {
                case "0":
                    continuar = false;
                    break;
                case "1":
                    System.out.println("-----------------------------------------------");
                    TelefonoMovil.printContacts();
                    break;
                case "2":
                    System.out.println("-----------------------------------------------");
                    System.out.println("Dame tu nombre: ");
                    nombre = scanner.nextLine();
                    do {
                        valido = true;
                        System.out.println("Dame tu número de teléfono: ");
                        numero = scanner.nextLine();
                        if (!numero.matches("[0-9]{9}")) {
                            System.out.println("El número de teléfono que has introducido no es válido. Debe tener 9 dígitos.");
                            valido = false;
                        }
                    }while(!valido);
                    if(TelefonoMovil.addNewContact(Contacto.createContact(nombre, numero))){
                        System.out.println("Contacto añadido con éxito.");
                    }else{
                        System.out.println("El contacto no se ha podido añadir. Ya existía.");
                    }
                    break;
                case "3":
                    System.out.println("-----------------------------------------------");
                    System.out.println("Dame cual es el nombre del contacto: ");
                    nombre = scanner.nextLine();
                    Contacto antiguo = TelefonoMovil.queryContact(nombre);
                    if(antiguo != null){
                        System.out.println("-----------------------------------------------");
                        System.out.println("Dame el nombre con el que quieres actualizar el contacto: ");
                        nombre = scanner.nextLine();
                        do {
                            valido = true;
                            System.out.println("Dame el número para actualizar el contacto: ");
                            numero = scanner.nextLine();
                            if (!numero.matches("[0-9]{9}")) {
                                System.out.println("El número de teléfono que has introducido no es válido. Debe tener 9 dígitos.");
                                valido = false;
                            }
                        }while(!valido);
                        if(TelefonoMovil.updateContact(antiguo,Contacto.createContact(nombre,numero))){
                            System.out.println("El contacto ha sido actualizado con éxtio.");
                        }
                    }
                    break;
                case "4":
                    System.out.println("-----------------------------------------------");
                    System.out.println("Dame cual es el nombre del contacto que quieres eliminar: ");
                    nombre = scanner.nextLine();
                    Contacto contacto = TelefonoMovil.queryContact(nombre);
                    if(TelefonoMovil.removeContact(contacto)) {
                        System.out.println("Contacto eliminado con éxito.");
                    }
                    break;
                case "5":
                    System.out.println("-----------------------------------------------");
                    System.out.println("Dame cual es el nombre del contacto: ");
                    nombre = scanner.nextLine();
                    Contacto contacto1 = TelefonoMovil.queryContact(nombre);
                    if(contacto1 != null) {
                        System.out.println(contacto1.getName() + " --> " + contacto1.getPhoneNumber());
                    }
                    break;
                case "6":
                    imprimirMenu();
                    break;
            }
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Gracias por utilizar nuestro programa.");
        scanner.close();
    }

}

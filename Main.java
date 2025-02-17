import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Pelicula> peliculas = new ArrayList<>();
        ArrayList<String> generos = new ArrayList<>();
        peliculas.add(new Pelicula("1", "El señor de los anillos", "Peter Jackson", 2001, "Fantasia", 178, 10));
        generos.add(peliculas.get(0).getGenero());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a Lupeliculas");
        System.out.println("Iniciar sesión como: ");
        System.out.println("1.- Usuario.");
        System.out.println("2.- Administrador.");
        int tipo = Integer.parseInt(scanner.nextLine());
        if (tipo == 1) {
            try {
                while (true){
                System.out.println("Seleccione una de las siguientes opciones:");
                System.out.println("1.- Mostrar todas las peliculas.");
                System.out.println("2.- Mostrar peliculas por genero.");
                System.out.println("3.- Mostrar generos.");
                System.out.println("4.- Prestamo de peliculas.");
                System.out.println("5.- Devolucion de peliculas.");
                System.out.println("6.- Cerrar programa.");
                int opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion){
                    case 1:
                        System.out.println("Mostrar todas las peliculas.");
                        for (Pelicula pelicula : peliculas) {
                            System.out.println(pelicula.getTitulo());
                        }
                        break;
                    case 2:
                        System.out.println("Mostrar peliculas por genero.");
                        break;
                    case 3:
                        System.out.println("Mostrar generos.");
                        for (String genero : generos) {
                            System.out.println(genero);
                        }
                        break;
                    case 4:
                        System.out.println("Prestamos de peliculas.");
                        break;
                    case 5:
                        System.out.println("Devolucion de peliculas.");
                        break;
                    case 6:
                        System.out.println("Cerrar programa.");
                        System.exit(0);
                        break;
                    }}

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        else if(tipo == 2){
            System.out.println("Iniciar sesión como administrador.");
            System.out.println("Ingrese su usuario:");
            String usuario = scanner.nextLine();
            while(true){
                System.out.println("Ingrese su contraseña:");
                String contraseña = scanner.nextLine();
                if(contraseña.equals("admin1")){
                    while (true) {
                        
                    System.out.println("Seleccione una de las siguientes acciones: ");
                    System.out.println("1.- Agregar pelicula.");
                    System.out.println("2.- Modificar pelicula.");
                    System.out.println("3.- Eliminar pelicula.");
                    System.out.println("4.- Cerrar programa.");
                    int opcion = Integer.parseInt(scanner.nextLine());
                    switch(opcion){
                        case 1:
                            try{
                                System.out.println("Ingrese el ID de la película:");
                                String id = scanner.nextLine();
                                System.out.println("Ingrese el título de la película:");
                                String titulo = scanner.nextLine();
                                System.out.println("Ingrese el autor de la película:");
                                String autor = scanner.nextLine();
                                System.out.println("Ingrese el año de la película:");
                                int year = Integer.parseInt(scanner.nextLine());
                                System.out.println("Ingrese el género de la película:");
                                String genero = scanner.nextLine();
                                System.out.println("Ingrese la duración de la película:");
                                int duracion = Integer.parseInt(scanner.nextLine());
                                System.out.println("Ingrese el stock de la película:");
                                int stock = Integer.parseInt(scanner.nextLine());
                
                                // Crear una instancia de Pelicula
                                Pelicula pelicula = new Pelicula(id, titulo, autor, year, genero, duracion, stock);
                                peliculas.add(pelicula);
                                // Mostrar los detalles de la película
                                System.out.println(peliculas);
                            }
                            catch (IllegalArgumentException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                        case 2:
                            System.out.println("Modificar pelicula.");
                            break;
                        case 3:
                            System.out.println("Eliminar pelicula.");
                            break;
                        case 4:
                            System.out.println("Hasta pronto "+usuario+".");
                            System.exit(0);
                            break;
                    }

                }                     
                
        }else{
            System.out.println("Contraseña incorrecta, intente de nuevo.");
        }
    } 
}}}
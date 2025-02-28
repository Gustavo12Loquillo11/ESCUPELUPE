import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Main {
    
    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private static void dibujarTabla(String[] textos) {
        int anchoTotal = 50;
        System.out.print(Tabla.TOPLEFT);
        for (int i = 0; i < anchoTotal; i++) System.out.print(Tabla.HORIZONTAL);
        System.out.println(Tabla.TOPRIGHT);
        for (String texto : textos) {
            int espacios = (anchoTotal - texto.length()) / 2;
            if (espacios < 0) espacios = 0;
            String padding = " ".repeat(espacios);
            System.out.println(Tabla.VERTICAL + padding + texto + padding + ((texto.length() % 2 == 0) ? " " : "") + Tabla.VERTICAL);
        }
        System.out.print(Tabla.BOTTOMLEFT);
        for (int i = 0; i < anchoTotal; i++) System.out.print(Tabla.HORIZONTAL);
        System.out.println(Tabla.BOTTOMRIGHT);
    }
    public static void main(String[] args) {
        limpiarPantalla();
        
        List<Pelicula> peliculas = new ArrayList<>();
        ArrayList<String> generos = new ArrayList<>();
        peliculas.add(new Pelicula("1", "El señor de los anillos", "Peter Jackson", 2001, "Fantasia", 178, 10));
        peliculas.add(new Pelicula("2", "El mago de Oz", "El pirata de culiacan", 2002, "Ciencia Ficcion", 208, 10));
        peliculas.add(new Pelicula("3", "La Momia", "Tony Montana", 1998, "Misterio", 120, 10));
        peliculas.add(new Pelicula("4", "El pianista", "Johnny Escupelupe Johnson", 2001, "Aventura", 134, 10));
        peliculas.add(new Pelicula("5", "El brutalista", "Brady Corbet", 2025, "History", 215, 10));
        generos.add(peliculas.get(0).getGenero());
        Scanner scanner = new Scanner(System.in);
        System.out.println(AnsiColors.YELLOW.TXT);
        String[] opciones = {
            "Bienvenido a Lupeliculas",
            "Iniciar sesión como:",
            "1.- Usuario.",
            "2.- Administrador."
        };
        dibujarTabla(opciones);
        int tipo = Integer.parseInt(scanner.nextLine());
        if (tipo == 1) {
            try {
                while (true){
                System.out.println(AnsiColors.CYAN.TXT);
                System.out.println("Seleccione una de las siguientes opciones:");
                System.out.println(AnsiColors.RESET);
                System.out.println("1.- Mostrar todas las peliculas.");
                System.out.println("2.- Mostrar peliculas por genero.");
                System.out.println("3.- Mostrar generos.");
                System.out.println("4.- Prestamo de peliculas.");
                System.out.println("5.- Devolucion de peliculas.");
                System.out.println("6.- Cerrar programa.");
                int opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion){
                    case 1:
                    System.out.println(AnsiColors.YELLOW.TXT);
                        System.out.println("Mostrar todas las peliculas.");
                        System.out.println(AnsiColors.RESET);
                        for (Pelicula pelicula : peliculas) {
                            System.out.println(pelicula.getTitulo());
                        }
                        break;
                    case 2:
                        for (Pelicula pelicula : peliculas) {
                            if (!generos.contains(pelicula.getGenero())) {
                                generos.add(pelicula.getGenero());
                            }
                        }
                        System.out.println(AnsiColors.YELLOW.TXT);
                        System.out.println("Mostrar peliculas por genero.");
                        System.out.println(AnsiColors.RESET);
                        for (String genero : generos) {
                            System.out.println("Género: "+genero);

                            for (Pelicula pelicula : peliculas) {
                                if (pelicula.getGenero().equals(genero)) {
                                    System.out.println(pelicula.getTitulo());
                                }
                            }
                            System.out.println("");
                        }

                        break;
                    case 3:
                    for (Pelicula pelicula : peliculas) {
                        if (!generos.contains(pelicula.getGenero())) {
                            generos.add(pelicula.getGenero());
                        }}
                        System.out.println(AnsiColors.YELLOW.TXT);
                        System.out.println("Mostrar generos.");
                        System.out.println(AnsiColors.RESET);
                        for (String genero : generos) {
                            System.out.println(genero);
                        }
                        break;
                    case 4:
                    System.out.println(AnsiColors.CYAN.TXT);
                        System.out.println("Ingrese el nombre de la película que desea pedir prestada:");
                        String nombrePrestamo = scanner.nextLine();
                        boolean encontradaPrestamo = false;
                        for (Pelicula pelicula : peliculas) {
                            if (pelicula.getTitulo().equalsIgnoreCase(nombrePrestamo)) {
                                encontradaPrestamo = true;
                                if (pelicula.getStock() > 0) {
                                    pelicula.setStock(pelicula.getStock() - 1);
                                    System.out.println(AnsiColors.GREEN.TXT);
                                    System.out.println("Préstamo exitoso de la película " + pelicula.getTitulo());
                                    System.out.println(AnsiColors.RESET);
                                } else {
                                    System.out.println(AnsiColors.RED.TXT);
                                    System.out.println("Lo siento, no tenemos esa película en stock");
                                }
                                break;
                            }
                        }
                        if (!encontradaPrestamo) {
                            System.out.println(AnsiColors.RED.TXT);
                            System.out.println("No tenemos una película con ese nombre");
                        }
                        break;
                    case 5:
                    System.out.println(AnsiColors.CYAN.TXT);
                        System.out.println("Ingrese el nombre de la película que desea devolver:");
                        String nombreDevolucion = scanner.nextLine();
                        boolean encontradaDevolucion = false;
                        for (Pelicula pelicula : peliculas) {
                            if (pelicula.getTitulo().equalsIgnoreCase(nombreDevolucion)) {
                                encontradaDevolucion = true;
                                pelicula.setStock(pelicula.getStock() + 1);
                                System.out.println(AnsiColors.GREEN.TXT);
                                System.out.println("Devolución exitosa, la película " + pelicula.getTitulo() + " se ha devuelto");
                                break;
                            }
                        }
                        if (!encontradaDevolucion) {
                            System.out.println(AnsiColors.RED.TXT);
                            System.out.println("Esa película no se ha prestado");
                        }
                        break;
                    case 6:
                    System.out.println(AnsiColors.RED.TXT);
                        System.out.println("Cerrar programa.");
                        System.exit(0);
                        break;
                    }}

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        else if(tipo == 2){
            System.out.println(AnsiColors.YELLOW.TXT);
            System.out.println("Iniciar sesión como administrador.");
            System.out.println("Ingrese su usuario:");
            System.out.println(AnsiColors.RESET);
            String usuario = scanner.nextLine();
            while(true){
                System.out.println(AnsiColors.YELLOW.TXT);
                System.out.println("Ingrese su contraseña:");
                System.out.println(AnsiColors.RESET);
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
                                System.out.println(AnsiColors.YELLOW.TXT);
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
                                System.out.println(AnsiColors.RESET);
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
                        System.out.println(AnsiColors.YELLOW.TXT);
                            System.out.println("¿Qué desea modificar?");
                            System.out.println(AnsiColors.RESET);
                            System.out.println("1.- ID");
                            System.out.println("2.- Título");
                            System.out.println("3.- Autor");
                            System.out.println("4.- Año");
                            System.out.println("5.- Género");
                            System.out.println("6.- Duración");
                            System.out.println("7.- Stock");
                            int mod = Integer.parseInt(scanner.nextLine());
                            switch(mod){
                                case 1:
                                System.out.println(AnsiColors.CYAN.TXT);
                                    System.out.println("Ingrese el ID de la película que desea modificar:");
                                    System.out.println(AnsiColors.RESET);
                                    String id = scanner.nextLine();
                                    for (Pelicula pelicula : peliculas) {
                                        if (pelicula.getId().equals(id)) {
                                            System.out.println(AnsiColors.CYAN.TXT);
                                            System.out.println("Ingrese el nuevo ID:");
                                            String newId = scanner.nextLine();
                                            pelicula.setId(newId);
                                        }
                                    }
                                    break;
                                case 2:
                                System.out.println(AnsiColors.CYAN.TXT);
                                    System.out.println("Ingrese el ID de la película que desea modificar:");
                                    System.out.println(AnsiColors.RESET);
                                    String id2 = scanner.nextLine();
                                    for (Pelicula pelicula : peliculas) {
                                        if (pelicula.getId().equals(id2)) {
                                            System.out.println(AnsiColors.CYAN.TXT);
                                            System.out.println("Ingrese el nuevo título:");
                                            System.out.println(AnsiColors.RESET);
                                            String newTitulo = scanner.nextLine();
                                            pelicula.setTitulo(newTitulo);
                                        }
                                    }
                                    break;
                                case 3:
                                System.out.println(AnsiColors.CYAN.TXT);
                                    System.out.println("Ingrese el ID de la película que desea modificar:");
                                    System.out.println(AnsiColors.RESET);
                                    String id3 = scanner.nextLine();
                                    for (Pelicula pelicula : peliculas) {
                                        if (pelicula.getId().equals(id3)) {
                                            System.out.println(AnsiColors.CYAN.TXT);
                                            System.out.println("Ingrese el nuevo autor:");
                                            System.out.println(AnsiColors.RESET);
                                            String newAutor = scanner.nextLine();
                                            pelicula.setAutor(newAutor);
                                        }
                                    }
                                    break;
                                case 4:
                                System.out.println(AnsiColors.CYAN.TXT);
                                    System.out.println("Ingrese el ID de la película que desea modificar:");
                                    System.out.println(AnsiColors.RESET);
                                    String id4 = scanner.nextLine();
                                    for (Pelicula pelicula : peliculas) {
                                        if (pelicula.getId().equals(id4)) {
                                            System.out.println(AnsiColors.CYAN.TXT);
                                            System.out.println("Ingrese el nuevo año:");
                                            System.out.println(AnsiColors.RESET);
                                            int newYear = Integer.parseInt(scanner.nextLine());
                                            pelicula.setYear(newYear);
                                        }
                                    }
                                    break;
                                case 5:
                                System.out.println(AnsiColors.CYAN.TXT);
                                    System.out.println("Ingrese el ID de la película que desea modificar:");
                                    System.out.println(AnsiColors.RESET);
                                    String id5 = scanner.nextLine();
                                    for (Pelicula pelicula : peliculas) {
                                        if (pelicula.getId().equals(id5)) {
                                            System.out.println(AnsiColors.CYAN.TXT);
                                            System.out.println("Ingrese el nuevo género:");
                                            System.out.println(AnsiColors.RESET);
                                            String newGenero = scanner.nextLine();
                                            pelicula.setGenero(newGenero);
                                        }
                                    }
                                    break;
                                case 6:
                                System.out.println(AnsiColors.CYAN.TXT);
                                    System.out.println("Ingrese el ID de la película que desea modificar:");
                                    System.out.println(AnsiColors.RESET);
                                    String id6 = scanner.nextLine();
                                    for (Pelicula pelicula : peliculas) {
                                        if (pelicula.getId().equals(id6)) {
                                            System.out.println(AnsiColors.CYAN.TXT);
                                            System.out.println("Ingrese la nueva duración:");
                                            System.out.println(AnsiColors.RESET);
                                            int newDuracion = Integer.parseInt(scanner.nextLine());
                                            pelicula.setDuracion(newDuracion);
                                        }
                                    }
                                    break;
                                case 7:
                                System.out.println(AnsiColors.CYAN.TXT);
                                    System.out.println("Ingrese el ID de la película que desea modificar:");
                                    System.out.println(AnsiColors.RESET);
                                    String id7 = scanner.nextLine();
                                    for (Pelicula pelicula : peliculas) {
                                        if (pelicula.getId().equals(id7)) {
                                            System.out.println(AnsiColors.CYAN.TXT);
                                            System.out.println("Ingrese el nuevo stock:");
                                            System.out.println(AnsiColors.RESET);
                                            int newStock = Integer.parseInt(scanner.nextLine());
                                            pelicula.setStock(newStock);
                                        }
                                    }
                                    break;
                            }
                            break;

                        case 3:
                            System.out.println(peliculas);
                            System.out.println(AnsiColors.CYAN.TXT);
                            System.out.println("Ingrese el ID de la película que desea eliminar:");
                            System.out.println(AnsiColors.RESET);
                            String id = scanner.nextLine();
                            for (Pelicula pelicula : peliculas){
                                if (pelicula.getId().equals(id)){
                                    peliculas.remove(pelicula);
                                    System.out.println(AnsiColors.GREEN.TXT);
                                    System.out.println("Pelicula eliminada.");
                                    System.out.println(AnsiColors.RESET);
                                    break;
                                    
                                }                                                      
                            }                            break;

                        case 4:
                        System.out.println(AnsiColors.GREEN.TXT);
                            System.out.println("Hasta pronto "+usuario+".");
                            System.exit(0);
                            break;
                    }

                }                     
                
        }else{
            System.out.println(AnsiColors.RED.TXT);
            System.out.println("Contraseña incorrecta, intente de nuevo.");
        }
       
    } 
    
   
}}}

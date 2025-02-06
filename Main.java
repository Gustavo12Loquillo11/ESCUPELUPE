public class Main {
    public static void main(String[] args) {
        try {
            // Crear una instancia de Pelicula
            Pelicula pelicula = new Pelicula("P001", "El Padrino", "Francis Ford Coppola", 1972, "Drama", 175, 10);
            
            // Mostrar los detalles de la película
            System.out.println(pelicula);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
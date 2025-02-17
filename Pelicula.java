public class Pelicula {
    private String id;
    private int stock;
    private String titulo;
    private String autor;
    private int year;
    private String genero;
    private int duracion;

    // Constructor con validaciones
    public Pelicula(String id, String titulo, String autor, int year, String genero, int duracion, int stock) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        setYear(year);
        setDuracion(duracion);
        setStock(stock);
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 1800 && year <= java.time.Year.now().getValue()) { // Validar año razonable
            this.year = year;
        } else {
            throw new IllegalArgumentException("Año inválido. Debe estar entre 1800 y el año actual.");
        }
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion > 0) {
            this.duracion = duracion;
        } else {
            throw new IllegalArgumentException("La duración debe ser mayor a 0.");
        }
    }
    public void reducirStock(){
        if(stock > 0){
            stock--;
        } else {
            throw new IllegalArgumentException("No hay stock disponible.");
        }
    }
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
    }

    // Método para representar la película como String
    @Override
    public String toString() {
        return "Pelicula:" +
                " titulo='" + titulo + '\'' +
                ", id='" + id + '\'' +
                ", autor='" + autor + '\'' +
                ", año=" + year +
                ", género='" + genero + '\'' +
                ", duración=" + duracion + " min" +
                ", stock=" + stock;
    }
}

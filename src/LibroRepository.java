import java.util.ArrayList;
import java.util.List;

class LibroRepository {
    private List<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public Libro buscarPorIsbn(int isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn() == isbn) {
                return libro;
            }
        }
        return null;
    }

    public List<Libro> listarLibros() {
        return libros;
    }

    public boolean eliminarLibros(int isbn) {
        Libro libroElimnar = buscarPorIsbn(isbn);
        if (libroElimnar != null) {
            libros.remove(libroElimnar);
            return true;
        }
        return false;
    }
}

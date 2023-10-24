import java.util.ArrayList;
import java.util.List;

/*
* desarrollar un sistema sencillo que permite almacenar, recuperar,
* listar y eliminar libros utilizando el patron repository
* */
public class Main {
    public static void main(String[] args) {
        LibroRepository libroRepository = new LibroRepository();

        // crear libros
        Libro l1 = new Libro(1, "Las ventajas de ser invisible", "Stephen Chboxky");
        Libro l2 = new Libro(2,"Dune", "Frank herbert");
        Libro l3 = new Libro(3, "To kill a mockingbird", "Harper lee");

        // agregar libros
        libroRepository.agregarLibro(l1);
        libroRepository.agregarLibro(l2);
        libroRepository.agregarLibro(l3);

        // listar libros cargados
        List<Libro> libros = libroRepository.listarLibros();
        System.out.println("Libros en stock");
        for (Libro libro: libros){
            System.out.println("ISBN: " + libro.getIsbn() + " Titulo: " + libro.getTitulo());
        }

        // buscar libros
        int buscarIsbn = 1;
        Libro libroEncontrado = libroRepository.buscarPorIsbn(buscarIsbn);
        if (libroEncontrado != null) {
            System.out.println("Libro encontrado - ISBN: " + libroEncontrado.getIsbn() + ", Título: " + libroEncontrado.getTitulo() + ", Autor: " + libroEncontrado.getAutor());
        } else {
            System.out.println("Libro no encontrado.");
        }

        // eliminar libro buscado
        boolean eliminado = libroRepository.eliminarLibros(buscarIsbn);
        if (eliminado){
            System.out.println("libro con isbn: " + buscarIsbn + " a sido eliminado");
        }else{
            System.out.println("falseo we");
        }

        //buscar libros despues de eliminados
        libros = libroRepository.listarLibros();
        System.out.println("Libros en stock despues de eliminar");
        for (Libro libro: libros){
            System.out.println("ISBN: " + libro.getIsbn() + " Titulo: " + libro.getTitulo());
        }
    }
}


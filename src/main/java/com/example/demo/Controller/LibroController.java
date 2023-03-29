package com.example.demo.Controller;

import com.example.demo.Entity.LibroEntity;
import com.example.demo.Service.ServiceImpl.LibroServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibroController {

    @Autowired
    public LibroServiceImple libroServiceImple;

    @GetMapping("/hola")
    public String hola(){
        return "Hola Mundo";
    }

    @PostMapping("/crear")
    public LibroEntity crearLibro(@RequestBody LibroEntity libroEntity){
        return libroServiceImple.addLibro(libroEntity);
    }

    @GetMapping("/saludar")
    public String saludar(@RequestParam(name = "nombre") String nombre,
                          @RequestParam(name = "apellido") String apellido) {
        return "Hola " + nombre + " " + apellido + "!";
    }
    @PutMapping("/actualizar/{idLibro}")
    public LibroEntity updateLibro(@RequestBody LibroEntity libroEntity, @PathVariable Long idLibro){
         return libroServiceImple.updateLibro(libroEntity, idLibro);
    }

    @DeleteMapping("/borrar/{idLibro}")
    public void borrarLibro(@PathVariable Long idLibro){
        libroServiceImple.deleteLibro(idLibro);
    }

    @GetMapping("libro/{idLibro}")
    private LibroEntity getLibroById(@PathVariable Long idLibro){
        return libroServiceImple.getByIdLibro(idLibro);
    }

    @GetMapping("/libros")
    private List<LibroEntity> getAllLibro(){
        return libroServiceImple.getAllLibro();
    }

    @PostMapping("/libros")
    public ResponseEntity<String> agregarLibro(@RequestParam String nombreAutor, @RequestParam String correoAutor) {
        try {
            libroServiceImple.agregarNombreYApellido(nombreAutor, correoAutor);
            return ResponseEntity.ok("Libro guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el libro");
        }
    }



}

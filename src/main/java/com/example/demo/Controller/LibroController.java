package com.example.demo.Controller;

import com.example.demo.Entity.LibroEntity;
import com.example.demo.Service.ServiceImpl.LibroServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("/actualizar/{idLibro}")
    public LibroEntity updateLibro(@RequestBody LibroEntity libroEntity, @PathVariable Long idLibro){
         return libroServiceImple.updateLibro(libroEntity, idLibro);
    }

    @DeleteMapping("/borrar/{idLibro}")
    public void borrarLibro(@PathVariable Long idLibro){
        libroServiceImple.deleteLibro(idLibro);
    }

    @GetMapping("libro/{bookId}")
    private LibroEntity getLibroById(@PathVariable Long idLibro){
        return libroServiceImple.getByIdLibro(idLibro);
    }

    @GetMapping("/libros")
    private List<LibroEntity> getAllLibro(){
        return libroServiceImple.getAllLibro();
    }


}

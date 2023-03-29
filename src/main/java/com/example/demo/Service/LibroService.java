package com.example.demo.Service;

import com.example.demo.Entity.LibroEntity;
import com.example.demo.Repository.LibroRepository;
import com.example.demo.Service.ServiceImpl.LibroServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService implements LibroServiceImple {
    @Autowired
    private LibroRepository libroRepository;


    @Override
    public LibroEntity addLibro(LibroEntity libroEntity) {
        return libroRepository.save(libroEntity);
    }

    @Override
    public LibroEntity updateLibro(LibroEntity libroEntity, Long idLibro) {
        Optional<LibroEntity> libroEntity1 = libroRepository.findById(idLibro);
        LibroEntity lb = null;
        if (libroEntity1.isPresent()) {
            lb = libroEntity1.get();
            lb.setNombreLibro(libroEntity.getNombreLibro());
            lb.setDescripcion(libroEntity.getDescripcion());
            lb.setPrecioDelLibro(libroEntity.getPrecioDelLibro());
            lb.setNombreAutor(libroEntity.getNombreAutor());
            lb.setPrecioOferta(libroEntity.getPrecioOferta());
            lb.setCorreoAutor(libroEntity.getCorreoAutor());
            lb = libroRepository.save(lb);
        }
        return lb;
    }

    @Override
    public void deleteLibro(Long idLibro) {
       Optional<LibroEntity> libroEntity = libroRepository.findById(idLibro);
       if (libroEntity.isPresent())
           libroRepository.deleteById(idLibro);
    }

    @Override
    public List<LibroEntity> getAllLibro() {
        return libroRepository.findAll();
    }

    @Override
    public LibroEntity getByIdLibro(Long idLibro) {
        LibroEntity libroEntity = libroRepository.findById(idLibro).orElse(null);
        return libroEntity;
    }

    @Override
    public String agregarNombreYApellido(String nombreAutor, String correoAutor) {
        LibroEntity libro = new LibroEntity();
        libro.setNombreAutor(nombreAutor);
        libro.setCorreoAutor(correoAutor);
        libroRepository.save(libro);
        return "Libro guardado correctamente";
    }



}

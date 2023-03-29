package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.LibroEntity;

import java.util.List;

public interface LibroServiceImple {
    public LibroEntity addLibro(LibroEntity libroEntity);
    public LibroEntity updateLibro(LibroEntity libroEntity, Long idLibro);
    public void deleteLibro(Long idLibro);
    public List<LibroEntity> getAllLibro();
    public LibroEntity getByIdLibro(Long idLibro);
    public String agregarNombreYApellido( String nombreAutor, String correoAutor );

    }



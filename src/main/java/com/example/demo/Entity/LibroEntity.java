package com.example.demo.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name="LIBRO_TABLA")
@NoArgsConstructor
@Getter
@Setter
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long libroId;
    @Column(length = 50)
    private String nombreLibro;
    private String descripcion;
    private Double precioDelLibro;
    private Double precioOferta;
    private String nombreAutor;
    private String correoAutor;
}
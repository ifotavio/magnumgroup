package br.com.magnum.fipe.entrevistaMagnum.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "MarcasEntity")
@Table(name = "marcas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarcasFipeEntity {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "nome")
    private String nome;

}

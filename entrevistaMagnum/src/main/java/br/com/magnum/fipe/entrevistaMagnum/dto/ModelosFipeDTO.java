package br.com.magnum.fipe.entrevistaMagnum.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelosFipeDTO {
    @JsonProperty(value = "codigo")
    private Integer codigo;
    @JsonProperty(value = "nome")
    private String nome;

}

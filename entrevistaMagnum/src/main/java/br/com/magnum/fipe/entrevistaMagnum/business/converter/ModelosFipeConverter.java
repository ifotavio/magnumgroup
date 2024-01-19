package br.com.magnum.fipe.entrevistaMagnum.business.converter;

import br.com.magnum.fipe.entrevistaMagnum.dto.ModelosFipeDTO;
import br.com.magnum.fipe.entrevistaMagnum.entities.ModelosFipeEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ModelosFipeConverter {

    public ModelosFipeEntity toEntity(ModelosFipeDTO dto) {
        return ModelosFipeEntity.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .codigo(dto.getCodigo())
                .nome(dto.getNome())
                .build();
    }

    public ModelosFipeDTO toDTO(ModelosFipeEntity entity) {
        return ModelosFipeEntity.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .codigo(entity.getCodigo())
                .nome(entity.getNome())
                .build();
    }

    public ModelosFipeEntity toEntityUpdate(ModelosFipeDTO dto, String id) {
        return ModelosFipeEntity.builder()
                .id(id)
                .codigo(dto.getCodigo() != null ? dto.getCodigo() : entity.getCodigo)
                .nome(dto.getNome() != null ? dto.getNome() : entity.getNome())
                .build();
    }

    public List<ModelosFipeDTO>(List<ModelosFipeEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }

}

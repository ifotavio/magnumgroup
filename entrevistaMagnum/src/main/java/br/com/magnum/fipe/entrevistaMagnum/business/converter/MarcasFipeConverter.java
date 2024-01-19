package br.com.magnum.fipe.entrevistaMagnum.business.converter;

import br.com.magnum.fipe.entrevistaMagnum.dto.MarcasFipeDTO;
import br.com.magnum.fipe.entrevistaMagnum.entities.MarcasFipeEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MarcasFipeConverter {

    public MarcasFipeEntity toEntity(MarcasFipeDTO dto) {
        return MarcasFipeEntity.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .codigo(dto.getCodigo())
                .nome(dto.getNome())
                .build();
    }

    public MarcasFipeDTO toDTO(MarcasFipeEntity entity) {
        return MarcasFipeEntity.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .codigo(entity.getCodigo())
                .nome(entity.getNome())
                .build();
    }

    public MarcasFipeEntity toEntityUpdate(MarcasFipeDTO dto, String id) {
        return MarcasFipeEntity.builder()
                .id(id)
                .codigo(dto.getCodigo() != null ? dto.getCodigo() : entity.getCodigo)
                .nome(dto.getNome() != null ? dto.getNome() : entity.getNome())
                .build();
    }

    public List<MarcasFipeDTO>(List<MarcasFipeEntity> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }

}

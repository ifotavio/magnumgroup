package br.com.magnum.fipe.entrevistaMagnum.business.service;

import br.com.magnum.fipe.entrevistaMagnum.business.converter.ModelosFipeConverter;
import br.com.magnum.fipe.entrevistaMagnum.client.ModelosFipeClient;
import br.com.magnum.fipe.entrevistaMagnum.dto.ModelosFipeDTO;
import br.com.magnum.fipe.entrevistaMagnum.entities.ModelosFipeEntity;
import br.com.magnum.fipe.entrevistaMagnum.repository.ModelosFipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor

public class ModelosFipeService {
    @Autowired ModelosFipeClient modelosFipeClient;
    @Autowired ModelosFipeRepository repository;
    @Autowired ModelosFipeConverter converter;

    public List<ModelosFipeDTO> findModelos() {
        try {
            List<ModelosFipeDTO> dto = modelosFipeClient.findByModelosFipe();
            dto.forEach(modelos ->{
                        Boolean retorno = this.existsByCodigo(modelos.getCodigo());
                        if (retorno.equals(false)) {
                            this.saveModelos(converter.toEntity(modelos));
                        }
                    }
            );
            return this.findAllModelos();
        } catch (Exception e) {
            throw new RuntimeException("Erro buscar e salvar os modelos" +e.getMessage());
        }
    }

    public ModelosFipeEntity saveModelos(ModelosFipeEntity entity) {
        try{
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar os modelos" +e.getMessage());
        }
    }

    public Boolean existsByCodigo (String codigo) {
        try {
            return repository.validaCodigoExistente(codigo);
        } catch (Exception e){
            throw new RuntimeException(format("Erro ao buscar por codigo",codigo), e);
        }
    }

    public ModelosFipeDTO findByNameMarca(String nome) {
        try{
            return converter.toDTO(repository.findByMarca(nome));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao pesquisar por nome!" +e.getMessage());
        }
    }

    public List<ModelosFipeDTO> findAllModelos() {
        try{
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao pesquisar por nome!" +e.getMessage());
        }
    }

    public ModelosFipeDTO updateModelos (String id, ModelosFipeDTO dto) {
        try {
            ModelosFipeEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de dados!"));
            saveModelos(converter.toEntityUpdate(entity,dto,id));
            return converter.toDTO(repository.findByMarca(entity.getNome()));

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar informações!" +e.getMessage());
        }
    }

    public ModelosFipeDTO saveModelosDTO(ModelosFipeDTO dto) {
        try{
            ModelosFipeEntity entity = converter.toEntity(dto);
            return converter.toDTO(repository.save(dto));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar os modelos" +e.getMessage());
        }
    }

}

package br.com.magnum.fipe.entrevistaMagnum.business.service;

import br.com.magnum.fipe.entrevistaMagnum.business.converter.MarcasFipeConverter;
import br.com.magnum.fipe.entrevistaMagnum.client.MarcasFipeClient;
import br.com.magnum.fipe.entrevistaMagnum.dto.MarcasFipeDTO;
import br.com.magnum.fipe.entrevistaMagnum.entities.MarcasFipeEntity;
import br.com.magnum.fipe.entrevistaMagnum.repository.MarcasFipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor

public class MarcasFipeService {
    @Autowired MarcasFipeClient marcasFipeClient;
    @Autowired MarcasFipeRepository repository;
    @Autowired MarcasFipeConverter converter;

    public List<MarcasFipeDTO> findMarcas() {
        try {
            List<MarcasFipeDTO> dto = marcasFipeClient.findByMarcasFipe();
            dto.forEach(marcas ->{
                        Boolean retorno = this.existsByCodigo(marcas.getCodigo());
                        if (retorno.equals(false)) {
                            this.saveMarcas(converter.toEntity(marcas));
                        }
                    }
            );
            return this.findAllMarcas();
        } catch (Exception e) {
            throw new RuntimeException("Erro buscar e salvar as marcas" +e.getMessage());
        }
    }

    public MarcasFipeEntity saveMarcas(MarcasFipeEntity entity) {
        try{
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar as marcas" +e.getMessage());
        }
    }

    public Boolean existsByCodigo (String codigo) {
        try {
            return repository.validaCodigoExistente(codigo);
        } catch (Exception e){
            throw new RuntimeException(format("Erro ao buscar por codigo",codigo), e);
        }
    }

    public MarcasFipeDTO findByNameMarca(String nome) {
        try{
            return converter.toDTO(repository.findByMarca(nome));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao pesquisar por nome!" +e.getMessage());
        }
    }

    public List<MarcasFipeDTO> findAllMarcas() {
        try{
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao pesquisar por nome!" +e.getMessage());
        }
    }

    public MarcasFipeDTO updateMarcas (String id, MarcasFipeDTO dto) {
        try {
            MarcasFipeEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de dados!"));
            saveMarcas(converter.toEntityUpdate(entity,dto,id));
            return converter.toDTO(repository.findByMarca(entity.getNome()));

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar informações!" +e.getMessage());
        }
    }

    public MarcasFipeDTO saveMarcasDTO(MarcasFipeDTO dto) {
        try{
            MarcasFipeEntity entity = converter.toEntity(dto);
            return converter.toDTO(repository.save(dto));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar as marcas" +e.getMessage());
        }
    }

}

package br.com.magnum.fipe.entrevistaMagnum.repository;

import br.com.magnum.fipe.entrevistaMagnum.entities.ModelosFipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelosFipeRepository extends JpaRepository<ModelosFipeEntity, String> {

    Boolean validaCodigoExistente(String codigo);

    ModelosFipeEntity findByMarca (String nome);
}

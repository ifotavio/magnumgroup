package br.com.magnum.fipe.entrevistaMagnum.repository;

import br.com.magnum.fipe.entrevistaMagnum.entities.MarcasFipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcasFipeRepository extends JpaRepository<MarcasFipeEntity, String> {

    Boolean validaCodigoExistente(String codigo);

    MarcasFipeEntity findByMarca (String nome);
}

package br.com.magnum.fipe.entrevistaMagnum.client;

import br.com.magnum.fipe.entrevistaMagnum.dto.MarcasFipeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "fipe-api", url = "${fipe-api.url.marcas:#{null}}")
public interface MarcasFipeClient {
    @GetMapping("/marcas")
    List<MarcasFipeDTO> findByMarcasFipe();
}

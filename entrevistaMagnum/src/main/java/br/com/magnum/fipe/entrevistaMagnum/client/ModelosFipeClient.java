package br.com.magnum.fipe.entrevistaMagnum.client;

import br.com.magnum.fipe.entrevistaMagnum.dto.ModelosFipeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "fipe-api", url = "${fipe-api.url.modelos:#{null}}")

public interface ModelosFipeClient {

    @GetMapping("/modelos")
    List<ModelosFipeDTO> findByModelosFipe();
}

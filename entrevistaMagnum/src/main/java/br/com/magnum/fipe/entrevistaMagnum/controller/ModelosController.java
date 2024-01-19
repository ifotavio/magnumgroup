package br.com.magnum.fipe.entrevistaMagnum.controller;

import br.com.magnum.fipe.entrevistaMagnum.business.service.ModelosFipeService;
import br.com.magnum.fipe.entrevistaMagnum.dto.ModelosFipeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelosFipe")
@RequiredArgsConstructor
@Tag(name = "modelos-api")

public class ModelosController {
    @Autowired ModelosFipeService service;

    @Operation(summary = "Busca todas os modelos da API 1 e salva",method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados!"),
    })
    @PostMapping("/api")
    public ResponseEntity<List<ModelosFipeDTO>> saveModelosApi(){
        return ResponseEntity.ok(service.findAllModelos());
    }

    @Operation(summary = "Salva novos modelos",method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modelo cadastrado com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao cadastrar modelos!"),
    })
    @PostMapping("/saveModelos")
    public ResponseEntity<ModelosFipeDTO> saveModelos(@RequestBody ModelosFipeDTO dto){
        return ResponseEntity.ok(service.saveModelosDTO(dto));
    }
    @Operation(summary = "Atualiza dados dos modelos",method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modelo atualizado com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar Modelos!"),
    })
    @PutMapping("/updateModelos")
    public ResponseEntity<ModelosFipeDTO> updateModelos(@RequestParam ("id") String id, @RequestBody ModelosFipeDTO dto){
        return ResponseEntity.ok(service.updateModelos(id,dto));
    }

    @Operation(summary = "busca todas os modelos cadastradas no banco de dados",method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modelos atualizados com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar modelos!"),
    })
    @GetMapping("/find/all")
    public ResponseEntity<List<ModelosFipeDTO>> findAllModelos(){
        return ResponseEntity.ok(service.findAllModelos());
    }

    @Operation(summary = "busca modelo por codigo no banco de dados",method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modelos atualizados com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar modelos!"),
    })
    @GetMapping("/{name}")
    public ResponseEntity<ModelosFipeDTO> findMarcaByName(@PathVariable ("name") String name){
        return ResponseEntity.ok(service.findByNameMarca(name));
    }
}

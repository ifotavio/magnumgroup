package br.com.magnum.fipe.entrevistaMagnum.controller;

import br.com.magnum.fipe.entrevistaMagnum.dto.MarcasFipeDTO;
import br.com.magnum.fipe.entrevistaMagnum.business.service.MarcasFipeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcasFipe")
@RequiredArgsConstructor
@Tag(name = "marcas-api")

public class MarcasController {
    @Autowired MarcasFipeService service;

    @Operation(summary = "Busca todas as marcas da API 1 e salva",method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados!"),
    })
    @PostMapping("/api")
    public ResponseEntity<List<MarcasFipeDTO>> saveMarcasApi(){
        return ResponseEntity.ok(service.findAllMarcas());
    }

    @Operation(summary = "Salva novas marcas",method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marca cadastrada com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao cadastrar marcas!"),
    })
    @PostMapping("/saveMarcas")
    public ResponseEntity<MarcasFipeDTO> saveMarcas(@RequestBody MarcasFipeDTO dto){
        return ResponseEntity.ok(service.saveMarcasDTO(dto));
    }
    @Operation(summary = "Atualiza dados das marcas",method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marca atualizada com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar marcas!"),
    })
    @PutMapping("/updateMarcas")
    public ResponseEntity<MarcasFipeDTO> updateMarcas(@RequestParam ("id") String id, @RequestBody MarcasFipeDTO dto){
        return ResponseEntity.ok(service.updateMarcas(id,dto));
    }

    @Operation(summary = "busca todas as marcas cadastradas no banco de dados",method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marca atualizada com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar marcas!"),
    })
    @GetMapping("/find/all")
    public ResponseEntity<List<MarcasFipeDTO>> findAllMarcas(){
        return ResponseEntity.ok(service.findAllMarcas());
    }

    @Operation(summary = "busca marca por codigo no banco de dados",method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marca atualizada com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar marcas!"),
    })
    @GetMapping("/{name}")
    public ResponseEntity<MarcasFipeDTO> findMarcaByName(@PathVariable ("name") String name){
        return ResponseEntity.ok(service.findByNameMarca(name));
    }
}

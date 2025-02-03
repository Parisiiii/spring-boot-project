package com.lucas.aluracurso.application.endereco;

import com.lucas.aluracurso.domain.endereco.Endereco;
import com.lucas.aluracurso.domain.endereco.EnderecoService;
import com.lucas.aluracurso.domain.medico.Medico;
import com.lucas.aluracurso.domain.medico.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("endereco")
@RequiredArgsConstructor
public class EnderecoRestController {
    private final EnderecoService enderecoService;
    private final MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> findAll(@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "id") String orderBy) {
        return ResponseEntity.ok(enderecoService.findAll(orderBy, page, pageSize));
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> save(@RequestBody EnderecoDTO enderecoDTO) {
        Medico medico = medicoService.getOne(enderecoDTO.medico());
        Endereco toSave = Endereco.of(enderecoDTO, medico);
        Endereco saved = enderecoService.save(toSave);
        return ResponseEntity.ok(new EnderecoDTO(saved));
    }
}

package com.lucas.application.medico;


import com.lucas.domain.medico.Medico;
import com.lucas.domain.medico.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static java.util.Optional.ofNullable;

@RestController
@RequestMapping("/medico")
@RequiredArgsConstructor
public class MedicoRestController {
    private final MedicoService medicoService;

    @PostMapping
    public ResponseEntity<MedicoDTO> save(@RequestBody @Valid MedicoDTO medicoDTO) {
        Medico toSave = ofNullable(medicoService.getOne(medicoDTO.id()))
                .map(i -> i.setValues(medicoDTO))
                .orElse(Medico.of(medicoDTO));
        Medico saved = medicoService.save(toSave);
        return ResponseEntity.ok().body(MedicoDTO.of(saved));
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> findAll(@PageableDefault(sort = {"nome"}) Pageable pageable) {
        return ResponseEntity.ok().body(medicoService.findAll(pageable));
    }

    @DeleteMapping("{medicoUUID}")
    public ResponseEntity<MedicoDTO> delete(@PathVariable @Valid UUID medicoUUID) {
        Medico toDelete = medicoService.getOne(medicoUUID);
        medicoService.delete(toDelete);
        return ResponseEntity.ok(MedicoDTO.of(toDelete));
    }

    @PatchMapping("{medicoUUID}")
    public ResponseEntity<MedicoDTO> ativarInativar(@PathVariable @Valid UUID medicoUUID) {
        Medico toLogicalDelete = medicoService.getOne(medicoUUID);
        toLogicalDelete.ativarInativar();
        medicoService.save(toLogicalDelete);
        return ResponseEntity.ok(MedicoDTO.of(toLogicalDelete));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<MedicoDTO> findByUUID(@PathVariable UUID uuid) {
        return ResponseEntity.ok().body(MedicoDTO.of(medicoService.getOne(uuid)));
    }
}

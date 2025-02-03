package com.lucas.aluracurso.application.medico;

import com.lucas.aluracurso.domain.medico.Medico;
import com.lucas.aluracurso.domain.medico.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/medico")
@RequiredArgsConstructor
public class MedicoRestController {
    private final MedicoService medicoService;

//    @GetMapping("/{medicoUuid}")
//    public ResponseEntity<MedicoDTO> findOne(@PathVariable UUID medicoUuid) {
//        Medico entity = medicoService.findByUUID(medicoUuid);
//        return ResponseEntity.ok().body(new MedicoDTO(entity));
//    }

    @PostMapping
    public ResponseEntity<MedicoDTO> save(@RequestBody @Valid MedicoDTO medicoDTO) {
        Medico toSave = Medico.of(medicoDTO);
        Medico saved = medicoService.save(toSave);
        return ResponseEntity.ok().body(new MedicoDTO(saved));
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> findAll(@RequestParam(defaultValue = "0") Integer page,
                                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                                   @RequestParam(defaultValue = "nome") String orderBy) {
        return ResponseEntity.ok().body(medicoService.findAll(orderBy, page, pageSize));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<MedicoDTO> findByUUID(@PathVariable UUID uuid) {
        return ResponseEntity.ok().body(new MedicoDTO(medicoService.getOne(uuid)));
    }
}

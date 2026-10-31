package one.digitalinnovation.lab_padroes_projetos_spring.controller;

import one.digitalinnovation.lab_padroes_projetos_spring.dto.PagamentoRequest;
import one.digitalinnovation.lab_padroes_projetos_spring.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    private final PagamentoService service;

    public PagamentoController(PagamentoService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String>pagar(@RequestBody PagamentoRequest request){
        return ResponseEntity.ok(service.processar(request.tipo(), request.valor()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> tipoInvalido(IllegalArgumentException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}

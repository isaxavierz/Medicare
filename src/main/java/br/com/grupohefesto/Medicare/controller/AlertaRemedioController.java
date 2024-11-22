package br.com.grupohefesto.Medicare.controller;

import br.com.grupohefesto.Medicare.entity.AlertaRemedio;
import br.com.grupohefesto.Medicare.service.AlertaRemedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertaRemedios")
public class AlertaRemedioController {
    @Autowired
    private AlertaRemedioService service;

    @GetMapping
    public List<AlertaRemedio> listar(){
        return service.listar();
    }


    @GetMapping("/{id}")
    public AlertaRemedio buscarPorId(@PathVariable("id") Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public AlertaRemedio cadastrar(@RequestBody AlertaRemedio alerta){

        return service.cadastrar(alerta);
    }

    @PutMapping("/{id}")
    public AlertaRemedio alterar(@RequestBody AlertaRemedio alerta,
                              @PathVariable("id") Long id){
        if(id == alerta.getId())
            return service.alterar(alerta);
        else
            return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlertaRemedio> excluir(@PathVariable("id") Long id){
        if(service.buscarPorId(id) != null) {
            service.excluir(id);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}

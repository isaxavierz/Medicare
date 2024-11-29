package br.com.grupohefesto.Medicare.controller;


import br.com.grupohefesto.Medicare.entity.Cuidador;
import br.com.grupohefesto.Medicare.service.CuidadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cuidadores")
public class CuidadorController {
    @Autowired
    private CuidadorService service;

    @GetMapping
    public List<Cuidador> listar(){
        return service.listar();
    }


    @GetMapping("/{id}")
    public Cuidador buscarPorId(@PathVariable("id") Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public Cuidador cadastrar(@RequestBody Cuidador cuidador){

        return service.cadastrar(cuidador);
    }

    @PutMapping("/{id}")
    public Cuidador alterar(@RequestBody Cuidador cuidador,
                                 @PathVariable("id") Long id){
        if(id == cuidador.getId())
            return service.alterar(cuidador);
        else
            return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cuidador> excluir(@PathVariable("id") Long id){
        if(service.buscarPorId(id) != null) {
            service.excluir(id);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

package br.com.grupohefesto.Medicare.controller;

import br.com.grupohefesto.Medicare.entity.RemedioUtilizador;
import br.com.grupohefesto.Medicare.service.RemedioUtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Remedios")
public class RemedioUtilizadorController {
    @Autowired
    private RemedioUtilizadorService service;

    @GetMapping
    public List<RemedioUtilizador> listar(){
        return service.listar();
    }


    @GetMapping("/{id}")
    public RemedioUtilizador buscarPorId(@PathVariable("id") Long id){
        return service.buscarPorId(id);
    }

    /*
    @GetMapping("/nome/{nome}")
    public RemedioUtilizador buscarPorNome(@PathVariable("nome") String nome){
        return service.buscarPorNome(nome);
    }*/

    @PostMapping
    public RemedioUtilizador cadastrar(@RequestBody RemedioUtilizador remedio){

        return service.cadastrar(remedio);
    }

    @PutMapping("/{id}")
    public RemedioUtilizador alterar(@RequestBody RemedioUtilizador remedio,
                                     @PathVariable("id") Long id){
        if(id == remedio.getId())
            return service.alterar(remedio);
        else
            return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RemedioUtilizador> excluir(@PathVariable("id") Long id){
        if(service.buscarPorId(id) != null) {
            service.excluir(id);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }


}

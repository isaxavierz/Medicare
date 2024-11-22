package br.com.grupohefesto.Medicare.service;

import br.com.grupohefesto.Medicare.entity.AlertaRemedio;
import br.com.grupohefesto.Medicare.repository.AlertaRemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaRemedioService {
    @Autowired
    private AlertaRemedioRepository repository;

    public List<AlertaRemedio> listar(){
        return repository.findAll();
    }

    public AlertaRemedio buscarPorId(Long id){
        var existe = repository.findById(id);
        if(existe.isPresent())
            return existe.get();
        return null;
    }
    
    public AlertaRemedio cadastrar(AlertaRemedio alerta){   
        return repository.save(alerta);
    }

    public AlertaRemedio alterar(AlertaRemedio alerta) {

        var existe = buscarPorId(alerta.getId());
        if (existe != null){
            System.out.println("Alarme alterado.");
            return repository.save(alerta);
        }
        else {
            return null;
        }
    }

    public void excluir(Long id){
        var existe = buscarPorId(id);
        if(existe != null)
            repository.deleteById(id);
    }

}

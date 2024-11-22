package br.com.grupohefesto.Medicare.service;

import br.com.grupohefesto.Medicare.entity.AlertaRemedio;
import br.com.grupohefesto.Medicare.entity.RemedioUtilizador;
import br.com.grupohefesto.Medicare.repository.AlertaRemedioRepository;
import br.com.grupohefesto.Medicare.repository.RemedioUtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemedioUtilizadorService {
    @Autowired
    private RemedioUtilizadorRepository repository;

    public List<RemedioUtilizador> listar(){
        return repository.findAll();
    }

    public RemedioUtilizador buscarPorId(Long id){
        var existe = repository.findById(id);
        if(existe.isPresent())
            return existe.get();
        return null;
    }

    public RemedioUtilizador cadastrar(RemedioUtilizador remedio){
        return repository.save(remedio);
    }

    public RemedioUtilizador alterar(RemedioUtilizador remedio) {

        var existe = buscarPorId(remedio.getId());
        if (existe != null){
            System.out.println("Remedio alterado.");
            return repository.save(remedio);
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

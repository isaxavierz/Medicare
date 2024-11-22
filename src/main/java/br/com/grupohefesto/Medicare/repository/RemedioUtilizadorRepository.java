package br.com.grupohefesto.Medicare.repository;

import br.com.grupohefesto.Medicare.entity.RemedioUtilizador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedioUtilizadorRepository extends JpaRepository<RemedioUtilizador, Long> {
    //fazer metodo get pelo nome do remédio
}

package br.com.grupohefesto.Medicare.repository;

import br.com.grupohefesto.Medicare.entity.Cuidador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuidadorRepository extends JpaRepository<Cuidador, Long> {
}

package br.com.grupohefesto.Medicare.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "CUIDADOR")
public class Cuidador {
    @Id
    @Column(name = "idCuidador")
    @OneToOne
    @JoinColumn(name = "UTILIZADOR", referencedColumnName = "idUtilizador")
    private int idCuidador;

    @Id
    @Column(name = "idUtilizador")
    @OneToOne
    @JoinColumn(name = "UTILIZADOR", referencedColumnName = "idUtilizador")
    private int idUtilizador;

    @Column(name = "dtInicio")
    private LocalDate dtInicio;

    @Column(name = "dtInicio")
    private LocalDate dtFim;

    public long getIdCuidador() {
        return idCuidador;
    }

    public long getIdUtilizador() {
        return idUtilizador;
    }
}

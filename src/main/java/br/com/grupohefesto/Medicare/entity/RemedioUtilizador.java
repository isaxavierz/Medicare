package br.com.grupohefesto.Medicare.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "REMEDIOS_UTILIZADOR")
public class RemedioUtilizador {
    @Id
    @Column(name = "idRemedio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRemedio;

    @Column(name = "nmRemedio")
    private String nmRemedio;

    @Column(name = "ntRemedio")
    private String ntRemedio;

    @Column(name = "Dosagem")
    private int Dosagem;

    @Column(name = "nmLaboratorio")
    private String nmLaboratorio;

    @Column(name = "dtRegistroRemedio")
    private LocalDateTime dtRegistroRemedio;

    @Column(name = "vldRemedio")
    private LocalDateTime vldRemedio;

    @Column(name = "qtdRemedio")
    private int qtdRemedio;

    @ManyToOne
    @JoinColumn(name = "idUtilizador")
    private int idUtilizador;

    public long getId() {
        return idRemedio;
    }
}

package br.com.grupohefesto.Medicare.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ALERTA_REMEDIO")
public class AlertaRemedio {
    @Id
    @Column(name = "idAlertaRemedio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlertaRemedio;

    @Column(name = "hrRemedio")
    private int hrRemedio;

    @ManyToOne
    @JoinColumn(name = "idRemedio")
    private RemedioUtilizador idRemedio;

    @ManyToOne
    @JoinColumn(name = "idUtilizador")
    private int idUtilizador; //Quando juntar o projeto trocar de int para Utilizador

    public Long getId() {
        return idAlertaRemedio;
    }
}

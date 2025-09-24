package com.univille.vsp.entidade;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Visualizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Perfil perfil;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Video video;

    @Column(nullable = false)
    private LocalDateTime data_hora;

    @Column(nullable = false)
    private long progresso;

    public Visualizacao() {
    }

    public Visualizacao(Perfil perfil, Video video, LocalDateTime data_hora, long progresso) {
        this.perfil = perfil;
        this.video = video;
        this.data_hora = data_hora;
        this.progresso = progresso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

    public long getProgresso() {
        return progresso;
    }

    public void setProgresso(long progresso) {
        this.progresso = progresso;
    }
}

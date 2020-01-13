package com.dbserver.Model;

import java.time.LocalDateTime;
import java.util.Date;

public class Voto {
    private Profissional profissional;
    private Restaurante restaurante;

    public Voto(Profissional profissional, Restaurante restaurante) {
        this.profissional = profissional;
        this.restaurante = restaurante;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}

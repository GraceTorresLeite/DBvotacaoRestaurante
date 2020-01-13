package com.dbserver.Model;

import java.util.ArrayList;
import java.util.Date;

public class Eleicao {
    private ArrayList<Voto> votos = new ArrayList<Voto>();
    private Date data;
    private Restaurante restauranteVencedor;

    public Eleicao(Date data) {
        this.data = data;
    }

    public ArrayList<Voto> getVotos() {
        return votos;
    }

    public void setVotos(ArrayList<Voto> votos) {
        this.votos = votos;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Restaurante getRestauranteVencedor() {
        return restauranteVencedor;
    }

    public void setRestauranteVencedor(Restaurante restauranteVencedor) {
        this.restauranteVencedor = restauranteVencedor;
    }
}



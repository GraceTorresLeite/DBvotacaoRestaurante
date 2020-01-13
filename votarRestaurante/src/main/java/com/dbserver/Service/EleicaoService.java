package com.dbserver.Service;

import com.dbserver.Model.Eleicao;
import com.dbserver.Model.Profissional;
import com.dbserver.Model.Restaurante;
import com.dbserver.Model.Voto;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;

public class EleicaoService {
    private ArrayList<Eleicao> eleicoes = new ArrayList<Eleicao>();
    private Eleicao eleicaoAtual;

    public Eleicao getEleicaoAtual() {
        return eleicaoAtual;
    }

    public void geraEleicao(Date data) {
        String dataFormatoNovo = DateFormat.getDateInstance().format(data);

        for (int i = 0; i < eleicoes.size(); i++) {
            Eleicao eleicao = eleicoes.get(i);

            String dataFormatoEleicao = DateFormat.getDateInstance().format(eleicao.getData());

            if (dataFormatoEleicao.equals(dataFormatoNovo)) {
                eleicaoAtual = eleicao;
            }
        }

        if (eleicaoAtual == null) {
            eleicaoAtual = new Eleicao(data);

            eleicoes.add(eleicaoAtual);
        }
    }

    public void adicionarVoto(Restaurante restaurante, Profissional profissional) throws Exception {
        for (int i = 0; i < eleicaoAtual.getVotos().size(); i++) {
            Voto voto = eleicaoAtual.getVotos().get(i);

            if (voto.getProfissional().getId().equals(profissional.getId())) {
                throw new Exception("Você já votou hoje, tente amanhã novamente");
            }
        }
        eleicaoAtual.getVotos().add(new Voto(profissional, restaurante));
    }

    public void calculaVotacao( ) {
        /* para cada voto do eleição atual get votos devo contar quantas vezes cada restaurante aparece
         em cada um dos votos. Para isso preciso percorrer todos os votos e guardar
         numa lista chave valor o retaurante e a contagem de vezes que encontrei este restaurante nos votos
         */
        Map<Restaurante, Integer> resultado = new HashMap<Restaurante, Integer>();

        for (int i = 0; i < eleicaoAtual.getVotos().size(); i++) {
            Voto voto = eleicaoAtual.getVotos().get(i);
            Restaurante restaurante = voto.getRestaurante();
            resultado.put(restaurante, resultado.getOrDefault(restaurante, 0) + 1);

        }
        Map.Entry<Restaurante, Integer> restauranteMaisVotado = null;
        for (Map.Entry<Restaurante, Integer> entrada : resultado.entrySet()) {
            if (restauranteMaisVotado == null || entrada.getValue().compareTo(restauranteMaisVotado.getValue()) > 0) {
                restauranteMaisVotado = entrada;
            }
        }
        eleicaoAtual.setRestauranteVencedor(restauranteMaisVotado.getKey());
    }

    //eleicaoAtual.getVotos().size();

}



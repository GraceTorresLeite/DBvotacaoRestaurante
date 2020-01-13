package com.dbserver.Model;

import com.dbserver.Service.EleicaoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VotarRestauranteApplicationTests {
    /*
	Estória 01
	Eu como profissional faminto Quero votar no meu restaurante favorito Para que eu consiga democraticamente levar meus
	colegas a comer onde eu gosto.
	Critério de Aceitação
     Um profissional só pode votar em um restaurante por dia.
    */

    @Test
    public void UmProfissionalUmRestaurante() throws Exception {
        Restaurante restaurante1 = new Restaurante(1l, "Food");
        Restaurante restaurante2 = new Restaurante(2l, "Bananas");
        Restaurante restaurante3 = new Restaurante(3l, "House Food");
        Restaurante restaurante4 = new Restaurante(4l, "Casa da Vovó");
        Restaurante restaurante5 = new Restaurante(5l, "Bifes e Cia");

        Profissional profissional1 = new Profissional(1l, "Luiz");
        Profissional profissional2 = new Profissional(2l, "Letícia");
        Profissional profissional3 = new Profissional(3l, "Vanda");
        Profissional profissional4 = new Profissional(4l, "Grace");
        Profissional profissional5 = new Profissional(5l, "Jeferson");

        EleicaoService eleicaoService = new EleicaoService();

        eleicaoService.geraEleicao(new Date());

        eleicaoService.adicionarVoto(restaurante2, profissional1);
        eleicaoService.adicionarVoto(restaurante1, profissional2);
        //eleicaoService.adicionarVoto(restaurante1, profissional2); aqui tem que dar erro
    }
	/*
	Estória 2
	Eu como facilitador do processo de votação Quero que um restaurante não possa ser repetido durante a semana Para que
	não precise ouvir reclamações infinitas!
	Critério de Aceitação
     O mesmo restaurante não pode ser escolhido mais de uma vez durante a semana.
	*/

    /*
    Estória 3
    Eu como profissional faminto Quero saber qual foi o restaurante escolhido Para que eu possa me despir de preconceitos
    e preparar o psicológico.
    Critério de Aceitação
     Mostrar de alguma forma o resultado da votação.
    */
    @Test
    public void restauranteVencedor() throws Exception {

        Restaurante restaurante1 = new Restaurante(1l, "Food");
        Restaurante restaurante2 = new Restaurante(2l, "Bananas");
        Restaurante restaurante3 = new Restaurante(3l, "House Food");
        Restaurante restaurante4 = new Restaurante(4l, "Casa da Vovó");
        Restaurante restaurante5 = new Restaurante(5l, "Bifes e Cia");

        Profissional profissional1 = new Profissional(1l, "Luiz");
        Profissional profissional2 = new Profissional(2l, "Letícia");
        Profissional profissional3 = new Profissional(3l, "Vanda");
        Profissional profissional4 = new Profissional(4l, "Grace");
        Profissional profissional5 = new Profissional(5l, "Jeferson");

        EleicaoService eleicaoService = new EleicaoService();

        eleicaoService.geraEleicao(new Date());

        eleicaoService.adicionarVoto(restaurante2, profissional1);
        eleicaoService.adicionarVoto(restaurante1, profissional2);
		eleicaoService.adicionarVoto(restaurante1, profissional3);

		eleicaoService.calculaVotacao();
		eleicaoService.getEleicaoAtual().getRestauranteVencedor().getNome();

		//assertEquals ("Food", eleicaoService.getEleicaoAtual().getRestauranteVencedor().getNome());  (este dará certo)
		assertEquals ("Casa da Vovó", eleicaoService.getEleicaoAtual().getRestauranteVencedor().getNome());
    }

}

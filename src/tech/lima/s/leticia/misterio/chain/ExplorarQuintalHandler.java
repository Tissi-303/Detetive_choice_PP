package tech.lima.s.leticia.misterio.chain;

import tech.lima.s.leticia.misterio.model.DadosDetetive;
import tech.lima.s.leticia.misterio.state.JogoContexto;
import tech.lima.s.leticia.misterio.state.CenaOpcoesInvestigacao;
import tech.lima.s.leticia.misterio.state.CenaDecisaoTecido;

public class ExplorarQuintalHandler extends BaseHandler {
    @Override
    public void processar(String escolha, DadosDetetive detetive, JogoContexto jogo) {
        if (escolha.equalsIgnoreCase("quintal")) {
            System.out.println("\nVocê sai pelos fundos. A névoa é tão espessa que parece sólida.");

            if (detetive.temPista("Lanterna Tática")) {
                System.out.println("Você liga a lanterna. O feixe de luz corta a escuridão, revelando lama revirada.");
                System.out.println("Alguém escorregou aqui. E foi arrastado.");
                detetive.adicionarPista("Marcas de Arraste");

                jogo.setEstadoAtual(new CenaDecisaoTecido());
            } else {
                System.out.println("Está escuro demais. Você não enxerga um palmo à frente do nariz.");
                System.out.println("Tentar investigar o quintal sem uma fonte de luz é inútil. Você retorna à sala.");
                jogo.setEstadoAtual(new CenaOpcoesInvestigacao());
            }
        } else {
            passarAoProximo(escolha, detetive, jogo);
        }
    }
}
package tech.lima.s.leticia.misterio.chain;

import tech.lima.s.leticia.misterio.model.DadosDetetive;
import tech.lima.s.leticia.misterio.state.JogoContexto;
import tech.lima.s.leticia.misterio.state.CenaOpcoesInvestigacao;

public class RevistarEntradaHandler extends BaseHandler {
    @Override
    public void processar(String escolha, DadosDetetive detetive, JogoContexto jogo) {
        if (escolha.equalsIgnoreCase("entrada")) {
            System.out.println("\n--- HALL DE ENTRADA ---");
            System.out.println("Há um cabideiro tombado e um sobretudo de couro úmido no chão.");
            System.out.println("Você vasculha os bolsos do casaco.");

            if (!detetive.temPista("Lanterna Tática")) {
                System.out.println("Sua mão encontra um cilindro de metal frio e uma ferramenta pesada.");
                detetive.adicionarPista("Lanterna Tática");
                detetive.adicionarPista("Ferramenta Enferrujada");
            } else {
                System.out.println("Os bolsos já estão vazios. Não há mais nada aqui.");
            }
            jogo.setEstadoAtual(new CenaOpcoesInvestigacao());
        } else {
            passarAoProximo(escolha, detetive, jogo);
        }
    }
}
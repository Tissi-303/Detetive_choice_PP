package tech.lima.s.leticia.misterio.chain;

import tech.lima.s.leticia.misterio.model.DadosDetetive;
import tech.lima.s.leticia.misterio.state.JogoContexto;
import tech.lima.s.leticia.misterio.state.CenaOpcoesInvestigacao;

public class AnaliseJanelaHandler extends BaseHandler {
    @Override
    public void processar(String escolha, DadosDetetive detetive, JogoContexto jogo) {
        if (escolha.equalsIgnoreCase("janela")) {
            System.out.println("\nO vento frio entra. Você analisa a moldura de madeira.");
            System.out.println("Os cacos de vidro estão projetados para *fora*, no jardim.");

            if (detetive.temPista("Alerta Climático")) {
                System.out.println("O chão interno está seco apesar da tempestade de ontem.");
                System.out.println("Conclusão: A janela não foi quebrada para entrar. Foi um ato de desespero para SAIR.");
                detetive.adicionarPista("Tentativa de Fuga");
            }
            jogo.setEstadoAtual(new CenaOpcoesInvestigacao());
        } else {
            passarAoProximo(escolha, detetive, jogo);
        }
    }
}
package tech.lima.s.leticia.misterio.chain;

import tech.lima.s.leticia.misterio.model.DadosDetetive;
import tech.lima.s.leticia.misterio.state.*;

public class ConclusaoCasoHandler extends BaseHandler {
    @Override
    public void processar(String escolha, DadosDetetive detetive, JogoContexto jogo) {

        if (escolha.equalsIgnoreCase("fuga estrategica")) {
            if (detetive.temPista("Carta Escondida")) {
                // FALSO VERDADEIRO: O jogador achou a carta, mas ignorou o sangue no quintal.
                jogo.setEstadoAtual(new FinalFalsaFuga());
            } else {
                System.out.println("\n[Faltam Provas] Você precisa achar algum documento que comprove a intenção dele fugir.");
                jogo.setEstadoAtual(new CenaOpcoesInvestigacao());
            }

        } else if (escolha.equalsIgnoreCase("fuga fracassada")) {
            // FINAL PERFEITO: Requer a intenção (Carta) + Prova do crime (Testemunha/Sangue)
            if (detetive.temPista("Carta Escondida") && detetive.temPista("Testemunha do Sequestro")) {
                jogo.setEstadoAtual(new FinalOcultoVerdadeiro());
            } else {
                System.out.println("\n[Teoria Incompleta] O delegado recusa seu relatório: 'Sequestro? Cadê o sangue? Cadê a testemunha?'");
                jogo.setEstadoAtual(new CenaOpcoesInvestigacao());
            }

        } else if (escolha.equalsIgnoreCase("acusar vizinho")) {
            // FINAIS TRÁGICOS (Os antigos que você já tinha criado)
            if (detetive.temPista("Relato Suspeito")) {
                // Acusa injustamente baseado num depoimento nervoso
                jogo.setEstadoAtual(new FinalAcusarVizinhoInocente());
            } else {
                // Acusa sem prova nenhuma
                jogo.setEstadoAtual(new FinalVizinhoProcessaDetetive());
            }

        } else if (escolha.equalsIgnoreCase("arquivar")) {
            // FINAL NEUTRO
            jogo.setEstadoAtual(new FinalInconclusivo());

        } else {
            passarAoProximo(escolha, detetive, jogo);
        }
    }
}
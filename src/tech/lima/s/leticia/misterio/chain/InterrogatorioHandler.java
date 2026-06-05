package tech.lima.s.leticia.misterio.chain;

import tech.lima.s.leticia.misterio.model.DadosDetetive;
import tech.lima.s.leticia.misterio.state.JogoContexto;
import tech.lima.s.leticia.misterio.state.CenaOpcoesInvestigacao;

public class InterrogatorioHandler extends BaseHandler {
    @Override
    public void processar(String escolha, DadosDetetive detetive, JogoContexto jogo) {
        if (escolha.equalsIgnoreCase("vizinho")) {
            System.out.println("\nO homem abre uma fresta. O suor brilha na testa dele.");

            if (detetive.temPista("Tecido Ensanguentado")) {
                System.out.println("\nVocê ergue o tecido manchado. 'Acabou o teatro. Eu vi o quintal.'");
                System.out.println("O vizinho desmorona, encostando a cabeça na porta.");
                System.out.println("'Eles eram três...', ele soluça. 'Ele tentou pular a janela com a mala, mas o agarraram na lama.'");
                System.out.println("'Colocaram ele num porta-malas. Eles me viram na janela e disseram que eu seria o próximo se abrisse a boca.'");
                detetive.adicionarPista("Testemunha do Sequestro");
            } else if (detetive.temPista("Aviso Sombrio")) {
                System.out.println("\nVocê pressiona sobre as dívidas da vítima.");
                System.out.println("'Eu... eu vi ele fugir!', o vizinho gagueja nervosamente. 'Ele correu com uma mala preta no meio da tempestade. Sumiu.'");
                System.out.println("(Sua intuição grita que ele está omitindo algo terrível por medo...)");
                detetive.adicionarPista("Relato Suspeito");
            } else {
                System.out.println("'Não sei de nada. Suma.', ele sussurra e tranca a porta.");
            }
            jogo.setEstadoAtual(new CenaOpcoesInvestigacao());
        } else {
            passarAoProximo(escolha, detetive, jogo);
        }
    }
}
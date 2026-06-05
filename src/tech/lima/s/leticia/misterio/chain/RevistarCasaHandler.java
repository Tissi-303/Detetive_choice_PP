package tech.lima.s.leticia.misterio.chain;

import tech.lima.s.leticia.misterio.model.DadosDetetive;
import tech.lima.s.leticia.misterio.state.JogoContexto;
import tech.lima.s.leticia.misterio.state.CenaOpcoesInvestigacao;
import tech.lima.s.leticia.misterio.state.CenaDecisaoFundoFalso;

public class RevistarCasaHandler extends BaseHandler {
    @Override
    public void processar(String escolha, DadosDetetive detetive, JogoContexto jogo) {
        if (escolha.equalsIgnoreCase("comoda")) {
            System.out.println("\nPapéis rasgados espalhados. Uma data circulada em vermelho salta aos olhos: hoje.");
            System.out.println("Eles estão chegando.");
            detetive.adicionarPista("Aviso Sombrio");

            System.out.println("\nAo dar um passo para trás, o assoalho soa oco sob suas botas.");

            if (detetive.temPista("Ferramenta Enferrujada")) {
                jogo.setEstadoAtual(new CenaDecisaoFundoFalso());
            } else {
                System.out.println("A tábua está claramente solta, mas foi cravada com parafusos grossos.");
                System.out.println("Seus dedos não são suficientes para puxá-la.");
                jogo.setEstadoAtual(new CenaOpcoesInvestigacao());
            }
        } else {
            passarAoProximo(escolha, detetive, jogo);
        }
    }
}
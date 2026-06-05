package tech.lima.s.leticia.misterio.state;

import tech.lima.s.leticia.misterio.model.DadosDetetive;

public class CenaDecisaoFundoFalso implements EstadoCena {

    @Override
    public void exibirTexto() {
        System.out.println("\nOs parafusos da tábua estão gastos.");
        System.out.println("Você tateia o bolso e sente a ferramenta que encontrou mais cedo.");
        System.out.println("Deseja forçar o assoalho? [sim / nao]");
        System.out.print(">> ");
    }

    @Override
    public void fazerEscolha(String escolha, DadosDetetive detetive, JogoContexto jogo) {
        if (escolha.equalsIgnoreCase("sim")) {
            System.out.println("A madeira range alto no silêncio da casa, mas cede.");
            System.out.println("Lá dentro, um envelope pardo lacrado. Você o rasga e lê a folha amassada:");
            System.out.println("\n  'Se alguém encontrar isso, saiba que não tive escolha.'");
            System.out.println("  'A dívida cresceu demais. Eles disseram que viriam cobrar com sangue.'");
            System.out.println("  'Vou aproveitar a tempestade de hoje, pegar o trem da meia-noite e recomeçar em outra cidade.'");
            System.out.println("  'Mudar de nome, sumir do mapa. Me perdoem, mas fugir é minha única chance de sobreviver a eles.'\n");

            detetive.adicionarPista("Carta Escondida");
            System.out.println("Você guarda a carta dobrada no bolso interno do seu paletó.");

        } else {
            System.out.println("Você recua, deixando o assoalho intacto. Algumas coisas não valem o esforço.");
        }

        jogo.setEstadoAtual(new CenaOpcoesInvestigacao());
    }
}
package tech.lima.s.leticia.misterio.state;

import tech.lima.s.leticia.misterio.model.DadosDetetive;

public class CenaDecisaoChaveFenda implements EstadoCena {
    @Override
    public void exibirTexto() {
        System.out.println("\nNo escuro, perto do batente, algo metálico reflete a pouca luz da rua.");
        System.out.println("Parece ser uma ferramenta esquecida.");
        System.out.println("Deseja pegar o objeto? [sim / nao]");
        System.out.print(">> ");
    }

    @Override
    public void fazerEscolha(String escolha, DadosDetetive detetive, JogoContexto jogo) {
        if (escolha.equalsIgnoreCase("sim")) {
            detetive.adicionarPista("Ferramenta Enferrujada");
            System.out.println("Você guarda o item pesado no bolso do sobretudo.");
        } else {
            System.out.println("Você decide deixar as coisas exatamente onde estão.");
        }
        // Volta para a sala principal
        jogo.setEstadoAtual(new CenaOpcoesInvestigacao());
    }
}
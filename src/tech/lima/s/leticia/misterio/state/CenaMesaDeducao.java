package tech.lima.s.leticia.misterio.state;

import tech.lima.s.leticia.misterio.model.DadosDetetive;
import tech.lima.s.leticia.misterio.chain.Handler;
import tech.lima.s.leticia.misterio.chain.ConclusaoCasoHandler;

public class CenaMesaDeducao implements EstadoCena {
    @Override
    public void exibirTexto() {
        System.out.println("\n====================== A MESA DE DEDUÇÃO ======================");
        System.out.println("O relatório em branco o aguarda. O destino do Distrito 9 está nas suas mãos.");
        System.out.println("Qual é o seu veredito oficial?");
        System.out.println(" [fuga estrategica] : A vítima forjou a cena e fugiu para escapar das dívidas.");
        System.out.println(" [fuga fracassada]  : A vítima tentou fugir, mas foi interceptada.");
        System.out.println(" [acusar vizinho]   : O vizinho hostil é o responsável pelo sumiço.");
        System.out.println(" [arquivar]         : Não há provas concretas. O caso é um beco sem saída.");
        System.out.print(">> ");
    }

    @Override
    public void fazerEscolha(String escolha, DadosDetetive detetive, JogoContexto jogo) {
        Handler conclusao = new ConclusaoCasoHandler();
        conclusao.processar(escolha, detetive, jogo);
    }
}
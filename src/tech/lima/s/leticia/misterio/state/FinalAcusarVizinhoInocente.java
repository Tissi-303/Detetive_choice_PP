package tech.lima.s.leticia.misterio.state;

import tech.lima.s.leticia.misterio.model.DadosDetetive;

public class FinalAcusarVizinhoInocente implements EstadoCena {
    @Override
    public void exibirTexto() {
        System.out.println("\n[FINAL TRÁGICO: INJUSTIÇA NA NÉVOA]");
        System.out.println("Você acusa o vizinho afirmando que a história da fuga na tempestade era mentira.");
        System.out.println("A polícia prende o vizinho... mas meses depois, a 'vítima' reaparece viva em outra cidade.");
        System.out.println("O vizinho era inocente. Sua reputação é destruída por prender a pessoa errada. A justiça não foi feita. FIM DE JOGO ;[ .");
    }
    @Override public void fazerEscolha(String e, DadosDetetive d, JogoContexto j) { j.setFinalizado(true); }
}
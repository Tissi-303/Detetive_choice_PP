package tech.lima.s.leticia.misterio.state;

import tech.lima.s.leticia.misterio.model.DadosDetetive;

public class FinalInconclusivo implements EstadoCena {
    @Override
    public void exibirTexto() {
        System.out.println("\n[FINAL NEUTRO: MISTÉRIO INSOLÚVEL]");
        System.out.println("Faltam peças no quebra-cabeça. Você arquiva o caso por falta de evidências.");
        System.out.println("O caso não solucionado do Distrito 9 vai assombrar suas noites para sempre. FIM DE JOGO.");
    }
    @Override public void fazerEscolha(String e, DadosDetetive d, JogoContexto j) { j.setFinalizado(true); }
}
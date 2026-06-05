package tech.lima.s.leticia.misterio.state;

import tech.lima.s.leticia.misterio.model.DadosDetetive;

public class FinalVizinhoProcessaDetetive implements EstadoCena {
    @Override
    public void exibirTexto() {
        System.out.println("\n[FINAL: ERRO DE AMADOR]");
        System.out.println("Você acusa o vizinho sem nenhuma prova, apenas porque ele foi suspeito? Ser uma pessoa esquisita não é crime!.");
        System.out.println("O caso é arquivado pelo juiz. O vizinho processa o departamento e você perde sua confiança, dinheiro e moral na cidade. FIM DE JOGO :[ .");
    }
    @Override public void fazerEscolha(String e, DadosDetetive d, JogoContexto j) { j.setFinalizado(true); }
}
package tech.lima.s.leticia.misterio.state;

import tech.lima.s.leticia.misterio.model.DadosDetetive;

public class FinalOcultoVerdadeiro implements EstadoCena {
    @Override
    public void exibirTexto() {
        System.out.println("\n[FINAL VERDADEIRO ABSOLUTO: CAÇADA NA NEBLINA]");
        System.out.println("Você alinha a Carta, as marcas de sangue e a gravação da confissão do vizinho.");
        System.out.println("'Ele tentou fugir', você declara, apontando para o relatório.");
        System.out.println("'A carta prova a intenção. A janela quebrada de dentro para fora prova a execução.'");
        System.out.println("'Mas ele não foi rápido o suficiente. Os cobradores o emboscaram no próprio quintal.'");
        System.out.println("O departamento inteiro mergulha em silêncio. A lógica é irrefutável.");
        System.out.println("A força-tarefa é montada em minutos. Graças à sua perspicácia obstinada, os agiotas serão caçados.");
        System.out.println("O Mistério da Janela Quebrada foi resolvido com perfeição. FIM DE JOGO.");
    }
    @Override public void fazerEscolha(String e, DadosDetetive d, JogoContexto j) { j.setFinalizado(true); }
}
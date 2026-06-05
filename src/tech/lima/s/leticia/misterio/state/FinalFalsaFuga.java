package tech.lima.s.leticia.misterio.state;

import tech.lima.s.leticia.misterio.model.DadosDetetive;

public class FinalFalsaFuga implements EstadoCena {

    @Override
    public void exibirTexto() {
        System.out.println("\n[FINAL: ILUSÃO DE ÓTICA]");
        System.out.println("Você entrega a Carta Escondida ao delegado. A caligrafia bate.");
        System.out.println("'Ele planejou tudo', você diz com convicção. 'Quebrou a janela e sumiu na tempestade.'");
        System.out.println("O caso é encerrado como Desaparecimento Voluntário.");
        System.out.println("Meses depois, um corpo em decomposição é encontrado numa vala a 30km dali, vestindo as roupas da vítima Junto com roupas rasgadas.");
        System.out.println("Você foi negligente. Os assassinos ganharam tempo suficiente para desaparecer. A justiça não foi feita. FIM DE JOGO. :[ ");
        System.out.println("\n(Pressione ENTER para sair)");
    }

    @Override
    public void fazerEscolha(String escolha, DadosDetetive detetive, JogoContexto jogo) {
        jogo.setFinalizado(true);
    }
}
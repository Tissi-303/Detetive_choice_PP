package tech.lima.s.leticia.misterio.state;

import tech.lima.s.leticia.misterio.model.DadosDetetive;

public class CenaDecisaoTecido implements EstadoCena {
    @Override
    public void exibirTexto() {
        System.out.println("\nPreso aos farpas da cerca de arame, há um pedaço de tecido escuro agitado pelo vento.");
        System.out.println("Deseja inspecionar o tecido mais de perto? [sim / nao]");
        System.out.print(">> ");
    }

    @Override
    public void fazerEscolha(String escolha, DadosDetetive detetive, JogoContexto jogo) {
        if (escolha.equalsIgnoreCase("sim")) {
            System.out.println("Você solta o tecido da cerca. Está úmido, mas não é só de chuva.");
            System.out.println("Há um cheiro metálico inconfundível. Sangue.");
            detetive.adicionarPista("Tecido Ensanguentado");
        } else {
            System.out.println("Você decide não tocar. Algumas coisas devem ser deixadas para a perícia.");
        }
        jogo.setEstadoAtual(new CenaOpcoesInvestigacao());
    }
}
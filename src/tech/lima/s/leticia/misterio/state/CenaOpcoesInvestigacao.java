package tech.lima.s.leticia.misterio.state;

import tech.lima.s.leticia.misterio.model.DadosDetetive;
import tech.lima.s.leticia.misterio.chain.*;

public class CenaOpcoesInvestigacao implements EstadoCena {
    @Override
    public void exibirTexto() {
        System.out.println("\nO silêncio da casa é desconfortante. Seus olhos buscam respostas na penumbra.");
        System.out.println(" [entrada] : Revistar o cabideiro e os casacos caídos no corredor.");
        System.out.println(" [janela]  : Inspecionar o buraco de vidro estilhaçado.");
        System.out.println(" [comoda]  : Vasculhar a mobília e o assoalho da sala.");
        System.out.println(" [quintal] : Explorar a escuridão densa nos fundos da casa.");
        System.out.println(" [vizinho] : Bater na casa ao lado.");
        System.out.println(" [deduzir] : Sentar-se e tentar conectar os fatos.");
        System.out.print(">> ");
    }

    @Override
    public void fazerEscolha(String escolha, DadosDetetive detetive, JogoContexto jogo) {
        if (escolha.equalsIgnoreCase("deduzir")) {
            jogo.setEstadoAtual(new CenaMesaDeducao());
            return;
        }

        Handler entrada = new RevistarEntradaHandler();
        Handler janela = new AnaliseJanelaHandler();
        Handler casa = new RevistarCasaHandler();
        Handler quintal = new ExplorarQuintalHandler();
        Handler interrogatorio = new InterrogatorioHandler();

        // Nova corrente mais complexa
        entrada.setProximo(janela);
        janela.setProximo(casa);
        casa.setProximo(quintal);
        quintal.setProximo(interrogatorio);

        entrada.processar(escolha, detetive, jogo);
    }
}
package tech.lima.s.leticia.misterio.state;

import tech.lima.s.leticia.misterio.model.DadosDetetive;

public class CenaIntroducao implements EstadoCena {
    @Override
    public void exibirTexto() {
        System.out.println("\n==========================================================================");
        System.out.println("O MISTÉRIO DA JANELA QUEBRADA");
        System.out.println("==========================================================================");
        System.out.println("A névoa engole o Distrito 9. A casa à sua frente está em um silêncio ensurdecedor.");
        System.out.println("Você é um Detetive de uma cidade pequena. O seu caso? Um desaparecimento. Nenhuma testemunha. Nenhum rastro de sangue a vista.");
        System.out.println("Você para diante da fita policial. O que sua intuição manda fazer?");
        System.out.println(" [arquivos] : Inspecionar a caixa de correio antes de entrar.");
        System.out.println(" [entrar]   : Atravessar a fita e adentrar a escuridão da casa.");
        System.out.print(">> ");
    }

    @Override
    public void fazerEscolha(String escolha, DadosDetetive detetive, JogoContexto jogo) {
        if (escolha.equalsIgnoreCase("arquivos")) {
            System.out.println("Páginas amareladas... Um alerta vermelho da noite anterior chamou sua atenção.");
            detetive.adicionarPista("Alerta Climático");
        }
        jogo.setEstadoAtual(new CenaOpcoesInvestigacao());
    }
}
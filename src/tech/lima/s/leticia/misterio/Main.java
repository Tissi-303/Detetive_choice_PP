package tech.lima.s.leticia.misterio;

import java.util.Scanner;
import tech.lima.s.leticia.misterio.model.DadosDetetive;
import tech.lima.s.leticia.misterio.state.JogoContexto;
import tech.lima.s.leticia.misterio.state.CenaIntroducao;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JogoContexto jogo = new JogoContexto();
        DadosDetetive detetive = new DadosDetetive();

        // Inicializa o jogo na primeira cena
        jogo.setEstadoAtual(new CenaIntroducao());

        // Motor do jogo
        while (!jogo.isFinalizado()) {
            String input = scanner.nextLine().trim();
            jogo.escolher(input, detetive);

            if (jogo.isFinalizado()) {
                break;
            }
        }

        System.out.println("\nObrigado por jogar!");
        scanner.close();
    }
}
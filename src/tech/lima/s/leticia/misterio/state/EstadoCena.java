package tech.lima.s.leticia.misterio.state;

import tech.lima.s.leticia.misterio.model.DadosDetetive;

public interface EstadoCena {
    void exibirTexto();
    void fazerEscolha(String escolha, DadosDetetive detetive, JogoContexto jogo);
}
package tech.lima.s.leticia.misterio.chain;

import tech.lima.s.leticia.misterio.model.DadosDetetive;
import tech.lima.s.leticia.misterio.state.JogoContexto;

public interface Handler {
    void setProximo(Handler proximo);
    void processar(String escolha, DadosDetetive detetive, JogoContexto jogo);
}
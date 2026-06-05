package tech.lima.s.leticia.misterio.chain;

import tech.lima.s.leticia.misterio.model.DadosDetetive;
import tech.lima.s.leticia.misterio.state.JogoContexto;

// A linha abaixo é a mais importante. Veja se tem o "implements Handler"
public abstract class BaseHandler implements Handler {
    protected Handler proximo;

    @Override
    public void setProximo(Handler proximo) {
        this.proximo = proximo;
    }

    protected void passarAoProximo(String escolha, DadosDetetive detetive, JogoContexto jogo) {
        if (proximo != null) {
            proximo.processar(escolha, detetive, jogo);
        } else {
            System.out.println("\n[Comando inválido] Você se perde em pensamentos na névoa... Tente novamente.");
        }
    }
}
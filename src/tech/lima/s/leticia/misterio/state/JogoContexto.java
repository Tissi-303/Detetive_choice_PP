package tech.lima.s.leticia.misterio.state;

import tech.lima.s.leticia.misterio.model.DadosDetetive;

public class JogoContexto {
    private EstadoCena estadoAtual;
    private boolean finalizado = false;

    public void setEstadoAtual(EstadoCena novoEstado) {
        this.estadoAtual = novoEstado;
        this.estadoAtual.exibirTexto();
    }

    public void escolher(String acao, DadosDetetive detetive) {
        estadoAtual.fazerEscolha(acao, detetive, this);
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
}
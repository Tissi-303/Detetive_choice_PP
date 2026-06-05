package tech.lima.s.leticia.misterio.model;

import java.util.HashSet;
import java.util.Set;

public class DadosDetetive {
    private Set<String> pistas = new HashSet<>();
    public int intuicao = 0;

    public void adicionarPista(String pista) {
        if (pistas.add(pista)) {
            System.out.println("\n[!] NOVA EVIDÊNCIA ANOTADA: " + pista);
        }
    }

    public boolean temPista(String pista) {
        return pistas.contains(pista);
    }
}
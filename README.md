# 🕵️‍♂️ O Mistério da Janela Quebrada — Jogo de Investigação em Java

Um jogo de suspense e investigação textual desenvolvido em Java (Console), focado na aplicação prática de **Padrões de Projeto (Design Patterns)** para construir uma arquitetura de software limpa, desacoplada e altamente escalável.

---

## 📖 A História & Mecânica do Jogo (ALERTA SPOILER!)

O jogador assume o papel de um detetive encarregado de desvendar um desaparecimento misterioso. Através do terminal, é preciso explorar o cenário do crime, interagir com testemunhas e coletar pistas no inventário.

*   **O Plot Twist (A Pista Falsa):** O jogo desafia a atenção do jogador. Ao inspecionar o assoalho, ele encontra uma *Carta Escondida* que indica uma suposta fuga da vítima para escapar de agiotas (gerando o `FinalFalsaFuga`). No entanto, se o detetive for meticuloso e investigar o quintal portando os itens corretos, descobrirá marcas de sangue e arrasto. A vítima tentou fugir, mas foi emboscada.
*   **Múltiplos Desfechos:** O sistema conta com 5 finais diferentes, que variam desde acusações precipitadas por falta de provas até a resolução do caso com o *Final Oculto Verdadeiro*.

---

## 🏗️ Arquitetura e Padrões de Projeto (Design Patterns)

O grande diferencial técnico deste projeto é a **total ausência de estruturas condicionais gigantescas** (`if/else` ou `switch/case` aninhados) para controlar o fluxo da história e as ações do usuário. Para isso, foram implementados dois padrões comportamentais do GoF:

### 1. Padrão **State** (Gerenciamento de Cenas)
Utilizado para ditar o fluxo de telas e fases do jogo (Menu, Investigação, Mesa de Dedução e Finais).
*   **Como funciona:** Cada cena ou final (como `FinalOcultoVerdadeiro` e `FinalFalsaFuga`) é uma classe isolada que implementa a interface `EstadoCena`.
*   **Vantagem:** O motor do jogo (`JogoContexto`) não precisa saber quais textos ou regras existem em cada tela; ele apenas gerencia uma variável do tipo do estado atual. Isso garante isolamento total de bugs e facilidade para criar novos cenários.

### 2. Padrão **Chain of Responsibility** (Processamento de Comandos)
Utilizado para processar de forma dinâmica as ordens que o jogador digita no console (como "janela", "quintal", "vizinho").
*   **Como funciona:** Os pontos de investigação foram estruturados como uma "corrente" de manipuladores (*Handlers*). O comando digitado passa de elo em elo. O elo correspondente (ex: `ExplorarQuintalHandler`) captura a ação, valida de forma independente as regras de inventário (ex: checar se o detetive possui a `Lanterna Tática`) e executa a resposta.
*   **Vantagem:** Desacoplamento completo. Para adicionar um novo cômodo na casa, basta criar uma nova classe Handler e plugá-la na corrente existente, sem a necessidade de alterar ou retestar os cômodos que já estavam prontos.

---

## 🛠️ Tecnologias Utilizadas

*   **Java SE** (JDK 17 ou superior)
*   **Paradigma de Programação Orientada a Objetos (POO)**
*   **Padrões de Projeto:** State e Chain of Responsibility

---

## 📂 Estrutura Principal de Pastas

```text
src/tech/lima/s/leticia/misterio/
├── model/
│   └── DadosDetetive.java      # Entidade que gerencia o inventário e pistas coletadas
├── state/
│   ├── EstadoCena.java         # Interface base para o padrão State
│   ├── JogoContexto.java       # Contexto que armazena e troca o estado atual do jogo
│   ├── CenaOpcoesInvestigacao.java
│   ├── FinalOcultoVerdadeiro.java
│   └── FinalFalsaFuga.java
└── handler/                    # Classes da Corrente de Responsabilidade
    ├── InvestigacaoHandler.java
    ├── AnaliseJanelaHandler.java
    └── ExplorarQuintalHandler.java

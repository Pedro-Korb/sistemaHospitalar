package Classes;

import java.util.HashMap;

import ListasLineares.ListaEncadeada;

public class FilaPrioridade {
	
	HashMap<Integer, ListaEncadeada<Paciente>> filasPorPrioridade;
	public static final String RESET = "\u001B[0m";
	public static final String YELLOW = "\u001B[33m";
	
	public FilaPrioridade() {
        filasPorPrioridade = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            filasPorPrioridade.put(i, new ListaEncadeada<>());
        }
    }

    public void adicionarPaciente(int prioridade, Paciente paciente) {
        if (prioridade >= 1 && prioridade <= 5) {
            filasPorPrioridade.get(prioridade).inserir(paciente);
        } else {
            System.out.println("Prioridade inválida: " + prioridade);
        }
    }

    public Paciente retirarPaciente() {
        for (int i = 1; i <= 5; i++) {
            ListaEncadeada<Paciente> fila = filasPorPrioridade.get(i);
            if (!fila.estaVazia()) {
                Paciente paciente = fila.getPrimeiro();
                fila.removerPorPosicao(0);
                return paciente;
            }
        }
        return null;
    }

    public boolean estaVazia() {
        for (ListaEncadeada<Paciente> fila : filasPorPrioridade.values()) {
            if (!fila.estaVazia()) {
                return false;
            }
        }
        return true;
    }

    public void mostrarTodos() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(YELLOW + "Prioridade " + i + ":" + RESET);
            filasPorPrioridade.get(i).mostrarTela();
            System.out.println("\n");
        }
    }

    public ListaEncadeada<Paciente> getFilaPorPrioridade(int prioridade) {
        return filasPorPrioridade.get(prioridade);
    }
    
    public Paciente getPrimeiro() {
        for (int i = 1; i <= 5; i++) {
            ListaEncadeada<Paciente> fila = filasPorPrioridade.get(i);
            if (!fila.estaVazia()) {
                return fila.getPrimeiro();
            }
        }
        return null;
    }
}

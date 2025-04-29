package Classes;

import ListasLineares.PilhaEncadeada;

public class PilhaObservacao {
	
	 private PilhaEncadeada<Paciente> pilhaPacientes;

    public PilhaObservacao() {
        this.pilhaPacientes = new PilhaEncadeada<>();
    }

    public void adicionarPaciente(Paciente paciente) {
        pilhaPacientes.empilhar(paciente);
    }

    public Paciente retirarPaciente() {
        Paciente paciente = pilhaPacientes.desempilhar();
        if (paciente != null) {
            System.out.println("Paciente retirado da observação: " + paciente.getNomePaciente());
        } else {
            System.out.println("Nenhum paciente na observação.");
        }
        return paciente;
    }

    public Paciente verPacienteTopo() {
        return pilhaPacientes.verTopo();
    }

    public int getQuantidadeEmObservacao() {
        return pilhaPacientes.tamanho();
    }

    public boolean estaVazia() {
        return pilhaPacientes.estaVazia();
    }

    public void mostrarPacientes() {
        pilhaPacientes.mostrarTela();
    }
}

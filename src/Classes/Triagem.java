package Classes;

import ListasLineares.ListaEncadeada;

public class Triagem {
	
	private Paciente paciente;
	private Enfermeiro enfermeiro;
	private FilaChegada listaChegada;
	private FilaPrioridade listaPrioridade;


	public Triagem(FilaChegada listaChegada, FilaPrioridade listaPrioridade) {
		super();
		this.listaChegada = listaChegada;
		this.listaPrioridade = listaPrioridade;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Enfermeiro getEnfermeiro() {
		return enfermeiro;
	}
	public void setEnfermeiro(Enfermeiro enfermeiro) {
		this.enfermeiro = enfermeiro;
	}
	public FilaChegada getListaChegada() {
		return listaChegada;
	}
	public void setListaChegada(FilaChegada listaChegada) {
		this.listaChegada = listaChegada;
	}
	public FilaPrioridade getListaPrioridade() {
		return listaPrioridade;
	}
	public void setListaPrioridade(FilaPrioridade listaPrioridade) {
		this.listaPrioridade = listaPrioridade;
	}
	
	
	public void realizaTriagem(Paciente paciente, Enfermeiro enfermeiro, int prioridade) {
		this.listaChegada.getListaPaciente().removerPorPosicao(0);
		this.listaPrioridade.adicionarPaciente(prioridade, paciente);		
	}

	
}

package Classes;

import ListasLineares.ListaEncadeada;

public class Paciente {

	private int idPaciente;
	private String nomePaciente;
	private ListaEncadeada<String> sintomas;
	
	public Paciente(int idPaciente, String nomePaciente) {
		super();
		this.idPaciente = idPaciente;
		this.nomePaciente = nomePaciente;
		this.sintomas = new ListaEncadeada<>();
	}
	
	public int getIdPaciente() {
		return idPaciente;
	}
	
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	public ListaEncadeada<String> getSintomas() {
		return sintomas;
	}
	public void setSintomas(String... sintomas) {
	    for (String sintoma : sintomas) {
	        this.sintomas.inserir(sintoma);
	    }
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Paciente [idPaciente=");
		builder.append(idPaciente);
		builder.append(", nomePaciente=");
		builder.append(nomePaciente);
		builder.append(", sintomas=");
		builder.append(sintomas.getTodos());
		builder.append("]");
		return builder.toString();
	}
}

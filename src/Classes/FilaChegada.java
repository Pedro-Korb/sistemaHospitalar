package Classes;

import ListasLineares.ListaEncadeada;

public class FilaChegada {
	
	private ListaEncadeada<Paciente> listaPaciente;
	
	public FilaChegada() {
		super();
		this.listaPaciente = new ListaEncadeada<>();
	}

	public ListaEncadeada<Paciente> getListaPaciente() {
		return listaPaciente;
	}

	public void setListaPaciente(Paciente... pacientes) {
		for (Paciente paciente : pacientes) {
			this.listaPaciente.inserir(paciente);
		}
	}

	public void mostrarTodos() {
		for (Paciente p : listaPaciente.getTodos()) {
			System.out.println(p);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FilaChegada [listaPaciente=");
		builder.append(listaPaciente.getTodos());
		builder.append("]");
		return builder.toString();
	}
}

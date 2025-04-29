package Classes;

public class Consulta {
	
	private PilhaObservacao pilhaObservacao;
	private FilaPrioridade listaPrioridade;
	private SalaAtendimento salaAtendimento;
	private Medico medico;
	private Paciente paciente;
	private boolean observacao;
	
	
	public Consulta(PilhaObservacao pilhaObservacao, FilaPrioridade listaPrioridade, SalaAtendimento salaAtendimento,
			Medico medico, boolean observacao) {
		super();
		this.pilhaObservacao = pilhaObservacao;
		this.listaPrioridade = listaPrioridade;
		this.paciente = this.listaPrioridade.retirarPaciente();
		this.salaAtendimento = salaAtendimento;
		this.medico = medico;
		this.observacao = observacao;
		if (this.paciente == null) {
			return;
		}
		
		if (observacao) {
			this.pilhaObservacao.adicionarPaciente(this.paciente);
		}
		
		this.medico.setDisponibilidade(false);
		this.salaAtendimento.setDisponivel(false);
	}


	public PilhaObservacao getPilhaObservacao() {
		return pilhaObservacao;
	}


	public void setPilhaObservacao(PilhaObservacao pilhaObservacao) {
		this.pilhaObservacao = pilhaObservacao;
	}


	public FilaPrioridade getListaPrioridade() {
		return listaPrioridade;
	}


	public void setListaPrioridade(FilaPrioridade listaPrioridade) {
		this.listaPrioridade = listaPrioridade;
	}


	public SalaAtendimento getSalaAtendimento() {
		return salaAtendimento;
	}


	public void setSalaAtendimento(SalaAtendimento salaAtendimento) {
		this.salaAtendimento = salaAtendimento;
	}


	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public boolean isObservacao() {
		return observacao;
	}


	public void setObservacao(boolean observacao) {
		this.observacao = observacao;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Consulta [pilhaObservacao=");
		builder.append(pilhaObservacao);
		builder.append(", listaPrioridade=");
		builder.append(listaPrioridade);
		builder.append(", salaAtendimento=");
		builder.append(salaAtendimento);
		builder.append(", medico=");
		builder.append(medico);
		builder.append(", paciente=");
		builder.append(paciente);
		builder.append(", observacao=");
		builder.append(observacao);
		builder.append("]");
		return builder.toString();
	}
	
}

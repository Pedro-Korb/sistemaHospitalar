package Classes;

public class Medico {
	
	private int idMedico;
	private String nomeMedico;
	private String especialidadeMedico;
	private boolean disponivel;
	

	public Medico(int idMedico, String nomeMedico, String especialidadeMedico, boolean disponivel) {
		super();
		this.idMedico = idMedico;
		this.nomeMedico = nomeMedico;
		this.especialidadeMedico = especialidadeMedico;
		this.disponivel = disponivel;
	}
	
	
	public int getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	public String getNomeMedico() {
		return nomeMedico;
	}
	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}
	public String getEspecialidadeMedico() {
		return especialidadeMedico;
	}
	public void setEspecialidadeMedico(String especialidadeMedico) {
		this.especialidadeMedico = especialidadeMedico;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponibilidade(boolean disponivel) {
		this.disponivel = disponivel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Medico [idMedico=");
		builder.append(idMedico);
		builder.append(", nomeMedico=");
		builder.append(nomeMedico);
		builder.append(", especialidadeMedico=");
		builder.append(especialidadeMedico);
		builder.append(", disponivel=");
		builder.append(disponivel);
		builder.append("]");
		return builder.toString();
	}
}

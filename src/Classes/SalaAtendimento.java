package Classes;

public class SalaAtendimento {
	
	private int idSala;
	private int numeracaoSala;
	private String especialidadeSala;
	private boolean disponivel;
	
	
	public SalaAtendimento(int idSala, int numeracaoSala, String especialidadeSala, boolean disponivel) {
		super();
		this.idSala = idSala;
		this.numeracaoSala = numeracaoSala;
		this.especialidadeSala = especialidadeSala;
		this.disponivel = disponivel;
	}


	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public int getNumeracaoSala() {
		return numeracaoSala;
	}

	public void setNumeracaoSala(int numeracaoSala) {
		this.numeracaoSala = numeracaoSala;
	}
	
	public String getEspecialidadeSala() {
		return especialidadeSala;
	}

	public void setEspecialidadeSala(String especialidadeSala) {
		this.especialidadeSala = especialidadeSala;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalaAtendimento [idSala=");
		builder.append(idSala);
		builder.append(", numeracaoSala=");
		builder.append(numeracaoSala);
		builder.append(", especialidadeSala=");
		builder.append(especialidadeSala);
		builder.append(", disponivel=");
		builder.append(disponivel);
		builder.append("]");
		return builder.toString();
	}
}

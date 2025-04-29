package Classes;

public class Enfermeiro {
	
	private int idEnfermeiro;
	private String nomeEnfermeiro;
	private boolean disponivel;
	
	public Enfermeiro(int idEnfermeiro, String nomeEnfermeiro, boolean disponivel) {
		super();
		this.idEnfermeiro = idEnfermeiro;
		this.nomeEnfermeiro = nomeEnfermeiro;
		this.setDisponivel(disponivel);
	}
	
	public int getIdEnfermeiro() {
		return idEnfermeiro;
	}
	public void setIdEnfermeiro(int idEnfermeiro) {
		this.idEnfermeiro = idEnfermeiro;
	}
	public String getNomeEnfermeiro() {
		return nomeEnfermeiro;
	}
	public void setNomeEnfermeiro(String nomeEnfermeiro) {
		this.nomeEnfermeiro = nomeEnfermeiro;
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
		builder.append("Enfermeiro [idEnfermeiro=");
		builder.append(idEnfermeiro);
		builder.append(", nomeEnfermeiro=");
		builder.append(nomeEnfermeiro);
		builder.append(", disponivel=");
		builder.append(disponivel);
		builder.append("]");
		return builder.toString();
	}

}

package ListasLineares;

public class Nodo<T> {
	
    T dado;
    Nodo<T> proximo;

    public Nodo(T dado) {
        this.dado = dado;
        this.proximo = null;
    }

	public T getDado() {
		return dado;
	}

	public void setDado(T dado) {
		this.dado = dado;
	}

	public Nodo<T> getProximo() {
		return proximo;
	}

	public void setProximo(Nodo<T> proximo) {
		this.proximo = proximo;
	}
}


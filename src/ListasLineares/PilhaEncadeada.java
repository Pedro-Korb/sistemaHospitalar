package ListasLineares;

public class PilhaEncadeada<T> {

    private Nodo<T> topo;

    public PilhaEncadeada() {
        this.topo = null;
    }

    public void empilhar(T dado) {
        Nodo<T> novo = new Nodo<>(dado);
        novo.setProximo(topo);
        topo = novo;
    }

    public T desempilhar() {
        if (estaVazia()) {
            return null;
        }
        T dado = topo.getDado();
        topo = topo.getProximo();
        return dado;
    }

    public T verTopo() {
        if (estaVazia()) {
            return null;
        }
        return topo.getDado();
    }

    public boolean estaVazia() {
    	return topo == null;
    }

    public void mostrarTela() {
        Nodo<T> atual = topo;
        while (atual != null) {
            System.out.println(atual.getDado());
            atual = atual.getProximo();
        }
    }

    public int tamanho() {
        int contador = 0;
        Nodo<T> atual = topo;
        while (atual != null) {
            contador++;
            atual = atual.getProximo();
        }
        return contador;
    }
}


package ListasLineares;

import java.util.ArrayList;
import java.util.Comparator;

public class ListaEncadeada<T> {
    private Nodo<T> inicio;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public void inserir(T valor) {
        Nodo<T> novo = new Nodo<>(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            Nodo<T> atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
        tamanho++;
    }

    public void mostrarTela() {
        Nodo<T> atual = inicio;
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
    }

    public ArrayList<T> getTodos() {
        ArrayList<T> lista = new ArrayList<>();
        Nodo<T> atual = inicio;
        while (atual != null) {
            lista.add(atual.dado);
            atual = atual.proximo;
        }
        return lista;
    }

    public T getProximo(T valor) {
        Nodo<T> atual = inicio;
        while (atual != null && atual.proximo != null) {
            if (atual.dado.equals(valor)) {
                return atual.proximo.dado;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public T getAnterior(T valor) {
        Nodo<T> anterior = null;
        Nodo<T> atual = inicio;

        while (atual != null) {
            if (atual.dado.equals(valor)) {
                return anterior != null ? anterior.dado : null;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return null;
    }

    public boolean removerPorValor(T valor) {
        if (inicio == null) return false;

        if (inicio.dado.equals(valor)) {
            inicio = inicio.proximo;
            tamanho--;
            return true;
        }

        Nodo<T> anterior = inicio;
        Nodo<T> atual = inicio.proximo;

        while (atual != null) {
            if (atual.dado.equals(valor)) {
                anterior.proximo = atual.proximo;
                tamanho--;
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return false;
    }

    public boolean removerPorPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) return false;

        if (posicao == 0) {
            inicio = inicio.proximo;
            tamanho--;
            return true;
        }

        Nodo<T> anterior = null;
        Nodo<T> atual = inicio;
        int index = 0;

        while (atual != null && index < posicao) {
            anterior = atual;
            atual = atual.proximo;
            index++;
        }

        if (atual != null) {
            anterior.proximo = atual.proximo;
            tamanho--;
            return true;
        }

        return false;
    }

    public void ordenar(Comparator<T> comparator) {
        if (inicio == null || inicio.proximo == null) return;

        ArrayList<T> lista = getTodos();
        lista.sort(comparator);

        inicio = null;
        tamanho = 0;

        for (T item : lista) {
            inserir(item);
        }
    }
    
    public boolean removerUltimo() {
        if (inicio == null) return false;

        if (inicio.proximo == null) {
            inicio = null;
            tamanho--;
            return true;
        }

        Nodo<T> atual = inicio;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }

        atual.proximo = null;
        tamanho--;
        return true;
    }

    public int tamanho() {
        return tamanho;
    }
    
    public boolean estaVazia() {
        return inicio == null;
    }
    
    public T getPrimeiro() {
        if (estaVazia()) {
            return null;
        }
        return inicio.getDado();
    }
    
    public boolean contem(T paciente) {
        Nodo<T> atual = inicio;
        while (atual != null) {
            if (atual.getDado().equals(paciente)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }
}

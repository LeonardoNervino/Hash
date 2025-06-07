public class ListaEncadeada {
    private No inicio;
    public int comparacoes = 0;

    public void inserir(Registro r) {
        No novo = new No(r);
        novo.proximo = inicio;
        inicio = novo;
    }

    public Registro buscar(String codigo) {
        No atual = inicio;
        comparacoes = 0;
        while (atual != null) {
            comparacoes++;
            if (atual.registro.getCodigo().equals(codigo)) return atual.registro;
            atual = atual.proximo;
        }
        return null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }
}
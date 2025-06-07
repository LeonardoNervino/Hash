import java.util.function.BiFunction;

public class TabelaHashEncadeada {
    private ListaEncadeada[] tabela;
    private int tamanho;
    public int colisoes;

    public TabelaHashEncadeada(int tamanho) {
        this.tamanho = tamanho;
        tabela = new ListaEncadeada[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new ListaEncadeada();
        }
        colisoes = 0;
    }

    public void inserir(Registro r, BiFunction<String, Integer, Integer> hashFunc) {
        int pos = hashFunc.apply(r.getCodigo(), tamanho);
        if (!tabela[pos].isEmpty()) colisoes++;
        tabela[pos].inserir(r);
    }

    public int buscar(String codigo, BiFunction<String, Integer, Integer> hashFunc) {
        int pos = hashFunc.apply(codigo, tamanho);
        tabela[pos].buscar(codigo);
        return tabela[pos].comparacoes;
    }
}
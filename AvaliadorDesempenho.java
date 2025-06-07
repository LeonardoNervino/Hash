import java.util.*;
import java.util.function.BiFunction;

public class AvaliadorDesempenho {
    public static void avaliar(List<Registro> dados, int tamanhoTabela, String nomeHash, BiFunction<String, Integer, Integer> funcaoHash) {
        TabelaHashEncadeada tabela = new TabelaHashEncadeada(tamanhoTabela);

        long inicio = System.nanoTime();
        for (Registro r : dados) {
            tabela.inserir(r, funcaoHash);
        }
        long fim = System.nanoTime();
        System.out.printf("Hash: %s | Tamanho: %d | Inserção: %.2f ms | Colisões: %d\n",
                nomeHash, tamanhoTabela, (fim - inicio) / 1e6, tabela.colisoes);
        
        // Busca Aleatória
        Random rand = new Random(123); // seed fixa para consistencia
        int comparacoesTotais = 0;
        inicio = System.nanoTime();
        for (int i = 0; i < 5; i++) {
            Registro alvo = dados.get(rand.nextInt(dados.size()));
            comparacoesTotais += tabela.buscar(alvo.getCodigo(), funcaoHash);
        }
        fim = System.nanoTime();
        System.out.printf("Busca média: %.2f ms | Comparações médias: %.2f\n\n",
                (fim - inicio) / 5e6, comparacoesTotais / 5.0);
    }
}
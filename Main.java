import java.util.*;

import HashFunções.HashDobramento;
import HashFunções.HashMultiplicacao;
import HashFunções.HashResto;


public class Main {
    public static void main(String[] args) {
        int[] tamanhos = {1000, 10000, 100000};
        long[] seeds = {111, 222, 333};
        int[] quantidades = {1_000_000, 5_000_000, 20_000_000};

        for (int i = 0; i < quantidades.length; i++) {
            System.out.printf("##### Conjunto %d (%,d registros)\n", i+1, quantidades[i]);
            List<Registro> dados = GeradorDeDados.gerar(quantidades[i], seeds[i]);

            for (int tam : tamanhos) {
                AvaliadorDesempenho.avaliar(dados, tam, "Resto", HashResto::hash);
                AvaliadorDesempenho.avaliar(dados, tam, "Multiplicação", HashMultiplicacao::hash);
                AvaliadorDesempenho.avaliar(dados, tam, "Dobramento", HashDobramento::hash);
            }
        }
    }
}
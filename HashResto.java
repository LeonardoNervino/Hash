package HashFunções;
public class HashResto {
    public static int hash(String codigo, int tamanho) {
        return Integer.parseInt(codigo) % tamanho;
    }
}

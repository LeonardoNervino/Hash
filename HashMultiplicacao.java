package HashFunções;

public class HashMultiplicacao {
    public static int hash(String codigo, int tamanho) {
        double A = 0.6180339887;
        int chave = Integer.parseInt(codigo);
        double valor = chave * A;
        return (int) Math.floor(tamanho * (valor - Math.floor(valor)));
    }
}
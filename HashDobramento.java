package HashFunções;
public class HashDobramento {
    public static int hash(String codigo, int tamanho) {
        int soma = 0;
        for (int i = 0; i < codigo.length(); i++) {
            soma += Character.getNumericValue(codigo.charAt(i));
        }
        return soma % tamanho;
    }
}

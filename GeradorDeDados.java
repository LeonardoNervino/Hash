import java.util.*;

public class GeradorDeDados {
    public static List<Registro> gerar(int quantidade, long seed) {
        Random rand = new Random(seed);
        Set<String> codigos = new HashSet<>();
        while (codigos.size() < quantidade) {
            String codigo = String.format("%09d", rand.nextInt(1_000_000_000));
            codigos.add(codigo);
        }

        List<Registro> lista = new ArrayList<>();
        for (String c : codigos)
            lista.add(new Registro(c));

        return lista;
    }
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class GenealogyApp {
    public static void main(String[] args) {
        GenealogyTree arvore = readTree("Projeto_2/Arvore.txt");

        try (PrintWriter writer = new PrintWriter("saida.txt", StandardCharsets.UTF_8)) {
            writer.println("\n2. Ascendentes de Júlia S01 A02");
            List<String> asc = arvore.ascendentes("Júlia S01 A02");
            for (String s : asc) {
                writer.print(s + "  ");
            }
            writer.println("\n---");

            writer.println("\n3. Número de descendentes de Mauro Paulo S01: " + arvore.contarDescendentes("Mauro Paulo S01"));
            writer.println("\n---");

            writer.println("\n4. Filhos de Mauro Paulo S01:");
            List<String> filhos = arvore.filhos("Mauro Paulo S01");
            for (String s : filhos) {
                writer.print(s + "  ");
            }
            writer.println("\n---");

            writer.println("\n5. Netos de Edmundo Antônio S01");
            List<String> netos = arvore.netos("Edmundo Antônio S01");
            for (String s : netos) {
                writer.print(s + "  ");
            }
            writer.println("\n---");

            writer.println("\n6. Tios de Júlia S01 A02");
            List<String> tios = arvore.tios("Júlia S01 A02");
            for (String s : tios) {
                writer.print(s + "  ");
            }
            writer.println("\n---");

            writer.println("\n7. Primos de Júlia S01 A02");
            List<String> primos = arvore.primos("Júlia S01 A02");
            for (String s : primos) {
                writer.print(s + "  ");
            }
            writer.println("\n---");

            writer.println("\nMostrar...");
            arvore.mostrar("AA", writer);
            arvore.mostrar("Henrique João S01", writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static GenealogyTree readTree(String arq) {
        GenealogyTree arv = null;
        try (BufferedReader buff = new BufferedReader(new FileReader(arq, StandardCharsets.UTF_8))) {
            String line = buff.readLine().trim();
            arv = new GenealogyTree(line);
            line = buff.readLine();

            while (line != null) {
                line = line.trim();
                String[] pessoas = line.split(" \\| ");
                for (int i = 1; i < pessoas.length; i++) {
                    arv.inserir(pessoas[i], pessoas[0]);
                }
                line = buff.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arv;
    }
}
package src.util;
import src.modelo.Financiamento;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static src.modelo.Financiamento.converterParaLinha;

public class EscreverDados {
    public static void escreverDados(String caminhoArquivo, List<Financiamento> lista, boolean append) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(caminhoArquivo, append))) {
            for (Financiamento f : lista) {
                out.write(converterParaLinha(f));
                out.newLine();
            }
        } catch (IOException e) {
            throw e;
        }
    }
}

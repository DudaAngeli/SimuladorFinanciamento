package src.util;

import java.io.BufferedReader;
import java.io.FileReader;

public class LerDados {
    public String lerDados(String caminhoArquivo) throws Exception {
        String conteudo = "";

        try (BufferedReader in = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha = in.readLine();

            while (linha != null) {
                conteudo += linha + "\n";
                linha = in.readLine();
            }

        } catch (Exception e){
            throw e;
        }
        return conteudo;
    }
}

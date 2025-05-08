package src.util;

import src.modelo.Financiamento;

import java.io.*;
import java.util.List;

public class SerializadorDados {
    public static void salvarArrayList(String caminhoArquivo, List<Financiamento> lista) throws IOException {
        try (ObjectOutputStream outs = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
            outs.writeObject(lista);
        } catch (IOException e) {
            throw e;
        }
    }

    public static List<Financiamento> lerArrayList(String caminhoArquivo) throws IOException, ClassNotFoundException  {
        try (ObjectInputStream ins = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            return (List<Financiamento>) ins.readObject();
        }
    }
}

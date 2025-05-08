package src.main;

import src.modelo.Apartamento;
import src.modelo.Casa;
import src.modelo.Financiamento;
import src.modelo.Terreno;
import src.util.InterfaceUsuario;
import src.util.EscreverDados;
import src.util.LerDados;
import src.util.SerializadorDados;

import java.io.IOException;
import java.util.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    private static Financiamento getFinanciamento(List<Financiamento> listaFinanciamentos) {
        InterfaceUsuario inter = new InterfaceUsuario();
        Financiamento financiamento;

        int escolha = inter.escolhaUsuario();

        if (escolha == 1) {
            financiamento = new Casa(inter.digiteValorImovel(), inter.digitePrazoFinanciamento(), inter.digiteTaxaJuros(), inter.digiteAreaConstruida(), inter.digiteAreaTerreno(), true);
        } else if (escolha == 2) {
            financiamento = new Apartamento(inter.digiteValorImovel(), inter.digitePrazoFinanciamento(), inter.digiteTaxaJuros(), inter.digiteVagasGaragem(), inter.digiteAndar());
        } else {
            financiamento = new Terreno(inter.digiteValorImovel(), inter.digitePrazoFinanciamento(), inter.digiteTaxaJuros(), inter.digiteTipoZona());
        }

        financiamento.mostrarInformacoes();
        listaFinanciamentos.add(financiamento);

        return financiamento;
    }

    public static void main(String[] args) {
        Locale localBrasil = new Locale("pt", "BR");
        String bri, brt;
        String caminhoArquivoTxt = "arquivoDosFinanciamentos.txt";
        String caminhoArquivoDat = "financiamentos_serializados.dat";

        var financiamentos = new ArrayList<Financiamento>();

        financiamentos.add(new Apartamento(300000, 15, 5, 10, 6));
        financiamentos.add(new Casa(765000, 30, 8, 600, 500, false));
        financiamentos.add(new Terreno(276400, 10, 5.4, 1));
        financiamentos.add(new Apartamento(500000, 10, 10, 30, 10));
        financiamentos.add(new Casa(1903400, 30, 8, 1600, 1100, false));
        financiamentos.add(new Terreno(200000, 20, 9.5, 2));

        System.out.println("\n======= Detalhes dos Financiamentos! =======\n");
        System.out.println("**** Pré-Definidos ****\n");

        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        for (var f : financiamentos) {
            bri = NumberFormat.getCurrencyInstance(localBrasil).format(f.getValorImovel());
            System.out.printf("Valor do imóvel a ser financiado: %s. Prazo do financiamento: %d anos. Taxa de juros anual: %.1f%%\n", bri, f.getPrazoFinanciamento(), f.getTaxaJuros());
            totalImoveis += f.getValorImovel();
            totalFinanciamentos += f.calcularPagamentoTotal();
        }

        System.out.println("\n**** Novo Financiamento ****");
        Financiamento novoFinanciamento = getFinanciamento(financiamentos);
        totalImoveis = totalImoveis + novoFinanciamento.getValorImovel();
        totalFinanciamentos = totalFinanciamentos + novoFinanciamento.calcularPagamentoTotal();

        bri = NumberFormat.getCurrencyInstance(localBrasil).format(totalImoveis);
        brt = NumberFormat.getCurrencyInstance(localBrasil).format(totalFinanciamentos);

        System.out.printf("\nO valor total dos imóveis será: %s\n", bri);
        System.out.printf("O valor total dos imóveis financiados será: %s\n\n", brt);

        try {
            EscreverDados.escreverDados(caminhoArquivoTxt, financiamentos, false);
            System.out.println("Arquivo texto (.txt) salvo com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar o arquivo texto: " + e.getMessage());
        }

        try {
            SerializadorDados.salvarArrayList(caminhoArquivoDat, financiamentos);
            System.out.println("Arquivo serializado (.dat) salvo com sucesso!\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo serializado: " + e.getMessage());
        }

        LerDados in = new LerDados();
        try {
            System.out.println("=== Conteúdo do Arquivo Texto (.txt) ===");
            String resultado = in.lerDados(caminhoArquivoTxt);
            System.out.println(resultado);
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo texto: " + e.getMessage());
        }

        try {
            System.out.println("=== Conteúdo do Arquivo Serializado (.dat) ===");
            List<Financiamento> listaLida = SerializadorDados.lerArrayList(caminhoArquivoDat);
            System.out.println("ArrayList lido com sucesso!");
            for (Financiamento f : listaLida) {
                System.out.println(f);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler o arquivo serializado: " + e.getMessage());
        }
    }
}

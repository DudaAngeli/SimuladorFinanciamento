package src.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class Financiamento implements Serializable {
    protected final double valorImovel;
    protected final int prazoFinanciamento;
    protected final double taxaJuros;
    @Serial
    private static final long serialVersionUID = 1L;

    public double getValorImovel(){
        return this.valorImovel;
    }

    public int getPrazoFinanciamento(){
        return this.prazoFinanciamento;
    }

    public double getTaxaJuros(){
        return this.taxaJuros;
    }

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJuros) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJuros = taxaJuros;
    }

    public abstract double calcularPagamentoMensal();

    public double calcularPagamentoTotal() {
        return (this.calcularPagamentoMensal() * this.getPrazoFinanciamento() * 12);
    }

    public void mostrarInformacoes() {
        String brm;
        String brt;
        Locale localBrasil = new Locale("pt", "BR");
        brm = NumberFormat.getCurrencyInstance(localBrasil).format(this.calcularPagamentoMensal());
        brt = NumberFormat.getCurrencyInstance(localBrasil).format(this.calcularPagamentoTotal());

        System.out.printf("\nO pagamento mensal do seu financiamento será: %s\n", brm);

        System.out.printf("O pagamento total do seu financiamento será: %s\n", brt);
    }

    public static String converterParaLinha(Financiamento financiamento) {
        StringBuilder linha = new StringBuilder();

        if (financiamento instanceof Casa casa) {
            linha.append("CASA; ")
                    .append(String.format("R$%.2f", casa.getValorImovel())).append("; ")
                    .append(casa.getPrazoFinanciamento()).append(" anos; ")
                    .append(casa.getTaxaJuros()).append("%; ")
                    .append(String.format("%.2f", casa.getAreaConstruida())).append(" m²; " )
                    .append(String.format("%.2f", casa.getAreaTerreno())).append(" m².");
        }else if (financiamento instanceof Apartamento apto) {
            linha.append("APARTAMENTO; ")
                    .append(String.format("R$%.2f", apto.getValorImovel())).append("; ")
                    .append(apto.getPrazoFinanciamento()).append(" anos; ")
                    .append(apto.getTaxaJuros()).append("%; ")
                    .append(apto.getVagasGaragem()).append(" vagas; ")
                    .append(apto.getAndarApartamento()).append(" andar.");

        } else if (financiamento instanceof Terreno terreno) {
            linha.append("TERRENO; ")
                    .append(String.format("R$%.2f", terreno.getValorImovel())).append("; ")
                    .append(terreno.getPrazoFinanciamento()).append(" anos; ")
                    .append(terreno.getTaxaJuros()).append("%; ")
                    .append(terreno.getTipoZona()).append(" zona.");
        }

        return linha.toString();
    }

    @Override
    public String toString() {
        return converterParaLinha(this);
    }
}
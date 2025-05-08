package src.modelo;

public class Terreno extends Financiamento{
    private final double tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJuros, double tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.tipoZona = tipoZona;
    }

    public double getTipoZona() {
        return tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        return (this.getValorImovel() / (this.getPrazoFinanciamento() * 12)) * (1 + (getTaxaJuros() / 12)) * 1.02;
    }

    @Override
    public void mostrarInformacoes() {
        super.mostrarInformacoes();
        String tipo = (getTipoZona() == 1) ? "Residencial" : "Comercial";
        System.out.println("Tipo de Zona do Terreno: " + tipo);
    }
}

package src.modelo;

import src.util.AumentoMaiorDoQueJurosException;

public class Casa extends Financiamento{
    private final double areaConstruida;
    private final double areaTerreno;
    private final boolean validarAcrescimo;
    private String mensagemAviso = "";

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJuros, double areaConstruida, double areaTerreno, boolean validarAcrescimo) {
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
        this.validarAcrescimo = validarAcrescimo;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getAreaTerreno() {
        return areaTerreno;
    }

    private void validarJurosMensal(double limiteJuros, double valorAcrescimo, boolean validarAcrescimo) throws AumentoMaiorDoQueJurosException {
        if (valorAcrescimo > limiteJuros) {
            if (validarAcrescimo) {
                throw new AumentoMaiorDoQueJurosException("Acréscimo maior que a metade dos juros mensais.");
            }
        }
    }

    @Override
    public double calcularPagamentoMensal() {
        double valorAcrescimo = 80;
        double parcela = this.getValorImovel() / (this.getPrazoFinanciamento() * 12);
        double taxaMensal = this.getTaxaJuros() / 100 / 12;
        double jurosMensal = parcela * taxaMensal;

        try {
            validarJurosMensal(jurosMensal / 2, valorAcrescimo, this.validarAcrescimo);
        } catch (AumentoMaiorDoQueJurosException e) {
            this.mensagemAviso = e.getMessage();
            valorAcrescimo = jurosMensal / 2;
        }

        return parcela + jurosMensal + valorAcrescimo;
    }

    @Override
    public void mostrarInformacoes() {
        super.mostrarInformacoes();
        System.out.printf("Área construída: %.2f m², Área do terreno: %.2f m²\n", areaConstruida, areaTerreno);

        if (!mensagemAviso.isEmpty()) {
            System.out.println(mensagemAviso);
        }
    }
}

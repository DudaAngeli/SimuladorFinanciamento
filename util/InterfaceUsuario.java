package src.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    Scanner sc = new Scanner(System.in);

    private void validarNumero(double numero) throws NumeroDigitadoInvalidoException {
        if (numero <= 0) {
            throw new NumeroDigitadoInvalidoException("O número digitado não pode ser menor ou igual a zero.");
        }
    }

    public double digiteAreaConstruida() {
        double areaDigitada = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Digite a área construída (m²): ");
                areaDigitada = sc.nextInt();
                validarNumero(areaDigitada);
                entradaValida = true;
            }catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                sc.next();
            }catch (NumeroDigitadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        return areaDigitada;
    }

    public double digiteAreaTerreno() {
        double areaDigitada = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Digite a área do terreno (m²): ");
                areaDigitada = sc.nextInt();
                validarNumero(areaDigitada);
                entradaValida = true;
            }catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                sc.next();
            }catch (NumeroDigitadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        return areaDigitada;
    }

    public int digiteVagasGaragem() {
        int vagas = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Digite o número de vagas disponíveis na garagem do prédio: ");
                vagas = sc.nextInt();
                validarNumero(vagas);
                entradaValida = true;
            }catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                sc.next();
            }catch (NumeroDigitadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        return vagas;
    }

    public int digiteAndar() {
        int andar = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Digite o andar do prédio em que seu apartamento está: ");
                andar = sc.nextInt();
                validarNumero(andar);
                entradaValida = true;
            }catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                sc.next();
            }catch (NumeroDigitadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        return andar;
    }

    public int digiteTipoZona() {
        int zona = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Qual o tipo de zona do terreno? 1-Residencial, 2-Comercial: ");
                zona = sc.nextInt();
                validarNumero(zona);
                entradaValida = true;
            }catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                sc.next();
            }catch (NumeroDigitadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        return zona;
    }

    public int escolhaUsuario() {
        int escolhaUser = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("\nQual o tipo de imóvel você deseja financiar? 1-Casa, 2-Apartamento, 3-Terreno ");
                escolhaUser = sc.nextInt();
                validarNumero(escolhaUser);
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                sc.next();
            } catch (NumeroDigitadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        return escolhaUser;
    }

    public double digiteValorImovel() {
        double digitadoValorImovel = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Digite o valor do imóvel: ");
                digitadoValorImovel = sc.nextDouble();
                validarNumero(digitadoValorImovel);
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                sc.next();
            } catch (NumeroDigitadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        return digitadoValorImovel;
    }


    public int digitePrazoFinanciamento() {
        int digitadoPrazo = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Digite o prazo do financiamento em anos: ");
                digitadoPrazo = sc.nextInt();
                validarNumero(digitadoPrazo);
                entradaValida = true;
            }catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                sc.next();
            }catch (NumeroDigitadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        return digitadoPrazo;
    }

    public double digiteTaxaJuros() {
        double digitadoTaxa = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Digite a taxa de juros ao ano: ");
                digitadoTaxa = sc.nextDouble();
                validarNumero(digitadoTaxa);
                entradaValida = true;
            }catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                sc.next();
            }catch (NumeroDigitadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        return digitadoTaxa;
    }
}
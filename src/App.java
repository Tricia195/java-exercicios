import java.util.Scanner;

public class App {

    
    static Scanner teclado = new Scanner(System.in);

   
    public static void tabuada(int numero) {
        int x = 1;

        do {
            System.out.println(numero + " x " + x + " = " + (numero * x));
            x++;
        } while (x <= 10);
    }

    
    public static void adivinhar(int numero) {
        int chute;

        do {
            System.out.println("Chute um numero inteiro:");
            chute = teclado.nextInt();

            if (chute < numero) {
                System.out.println("E MENOR");
            } else if (chute > numero) {
                System.out.println("E MAIOR");
            } else {
                System.out.println("E IGUAL");
            }
        } while (chute != numero);
    }

  
    public static void caixaEletronico() {
        float saldo, valor;
        int op;
        String continua;

        System.out.println("Informe o saldo inicial:");
        saldo = teclado.nextFloat();

        do {
            System.out.println("1 - Saldo");
            System.out.println("2 - Deposito");
            System.out.println("3 - Saque");
            System.out.println("Escolha uma opcao:");
            op = teclado.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Saldo = " + saldo);
                    break;

                case 2:
                    System.out.println("Informe o valor do deposito:");
                    valor = teclado.nextFloat();

                    if (valor > 0) {
                        saldo = saldo + valor;
                        System.out.println("Saldo atual: " + saldo);
                    } else {
                        System.out.println("O valor do deposito deve ser positivo.");
                    }
                    break;

                case 3:
                    System.out.println("Informe o valor do saque:");
                    valor = teclado.nextFloat();

                    if (valor <= 0) {
                        System.out.println("O valor do saque deve ser positivo.");
                    } else if (valor <= saldo) {
                        saldo = saldo - valor;
                        System.out.println("Saldo atual: " + saldo);
                    } else {
                        System.out.println("Saldo insuficiente: " + saldo);
                    }
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }

            System.out.println("Deseja continuar? S/N");
            continua = teclado.next();
        } while (continua.equalsIgnoreCase("S"));
    }

    public static int potencia(int base, int expoente) {
        int resultado = 1;

        for (int x = 1; x <= expoente; x++) {
            resultado = resultado * base;
        }

        return resultado;
    }

    
    public static double fatorial(int numero) {
        double resultado = 1;

        for (int x = 1; x <= numero; x++) {
            resultado = resultado * x;
        }

        return resultado;
    }

    public static void main(String[] args) throws Exception {
        int opcao;

        do {
            System.out.println("===== MENU DE EXERCICIOS =====");
            System.out.println("1 - Tabuada");
            System.out.println("2 - Jogo de adivinhacao");
            System.out.println("3 - Caixa eletronico");
            System.out.println("4 - Calcular potencia");
            System.out.println("5 - Calcular fatorial");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opcao:");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Informe um numero inteiro:");
                    int numeroTabuada = teclado.nextInt();
                    tabuada(numeroTabuada);
                    break;

                case 2:
                    System.out.println("Informe o numero que devera ser adivinhado:");
                    int numeroSecreto = teclado.nextInt();
                    adivinhar(numeroSecreto);
                    break;

                case 3:
                    caixaEletronico();
                    break;

                case 4:
                    System.out.println("Informe a base:");
                    int base = teclado.nextInt();

                    System.out.println("Informe o expoente (maior ou igual a zero):");
                    int expoente = teclado.nextInt();

                    if (expoente < 0) {
                        System.out.println("O expoente deve ser maior ou igual a zero.");
                    } else {
                        System.out.println("Resultado: " + potencia(base, expoente));
                    }
                    break;

                case 5:
                    System.out.println("Informe um numero inteiro nao negativo:");
                    int numeroFatorial = teclado.nextInt();

                    if (numeroFatorial < 0) {
                        System.out.println("Informe um numero não negativo.");
                    } else {
                        double resultado = fatorial(numeroFatorial);
                        System.out.printf("Fatorial: %.0f%n", resultado);
                    }
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (opcao != 0);

        teclado.close();
    }
}

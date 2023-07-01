package calculosalario;

import java.util.Scanner;

public class CalculoSalario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] salBruto = entradaDados();
        double[] inss = inss(salBruto);
        double[] impostoRenda = impostoRenda(salBruto);
        double[] salLiquido = calculoSalario(salBruto, inss, impostoRenda);

        mostrarFinal(salBruto, inss, impostoRenda, salLiquido);
    }

    public static double[] entradaDados(){
        Scanner scanner = new Scanner(System.in);

        double[] salBruto = new double[5];

        for (int i = 0; i < salBruto.length; i++){
            System.out.printf("Digite o salário bruto do %dº funcionário: \n", (i + 1));
            salBruto[i] = scanner.nextDouble();
        }

        System.out.println();
        return salBruto;
    }

    public static double[] inss(double[] salBruto) {

        double[] inss = new double[5];

        for (int i = 0; i < salBruto.length; i++) {
            double desconto = salBruto[i];
            if (desconto <= 1212) {
                inss[i] = desconto * 0.075;
            } else if (desconto > 1212 && desconto <= 2427.35) {
                inss[i] = desconto * 0.09;
            } else if (desconto > 2427.35 && desconto <= 3641.03) {
                inss[i] = desconto * 0.12;
            } else if (desconto > 3641.03) {
                inss[i] = desconto * 0.14;
            }
        }

        return inss;
    }

    public static double[] impostoRenda (double[] salBruto){

        double[] impostoRenda = new double[5];

        for (int i = 0; i < salBruto.length; i++) {
            double sal = salBruto[i];
            if (sal <= 1903.98) {
                impostoRenda[i] = sal * 0;
            } else if (sal > 1903.98 && sal <= 2826.65) {
                impostoRenda[i] = sal * 0.075;
            } else if (sal > 2826.65 && sal <= 3751.05) {
                impostoRenda[i] = sal * 0.15;
            } else if (sal > 3751.05 && sal <= 4664.68) {
                impostoRenda[i] = sal * 0.2250;
            } else if (sal > 4664.68) {
                impostoRenda[i] = sal * 0.2750;
            }
        }

        return impostoRenda;
    }

    public static double[] calculoSalario (double[] salBruto, double[] inss, double[] impostoRenda){
        double[] salLiquido = new double[5];

        for (int i = 0; i < salBruto.length; i++) {
            salLiquido[i] = salBruto[i] - (inss[i] + impostoRenda[i]);
        }

        return salLiquido;
    }

    public static void mostrarFinal(double[] salBruto, double[] inss, double[] impostoRenda, double[] salLiquido){
        for (int i = 0; i < salBruto.length; i++) {
            System.out.printf("As informações do %dº funcionário são: \n", (i + 1));

            System.out.printf("Salário bruto: %.2f.\n", salBruto[i]);
            System.out.printf("Desconto do INSS: %.2f.\n", inss[i]);
            System.out.printf("Desconto de imposto de renda: %.2f.\n", impostoRenda[i]);
            System.out.printf("Salário líquido: %.2f.\n", salLiquido[i]);

            System.out.println("\n---\n");
        }
    }
    
}

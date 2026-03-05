import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println();

        System.out.println("Seja bem vindo ao sistema de consulta de CEP :)");

        System.out.println();

        String cepInformado = " ";

        while (true){

            System.out.println("Informe o CEP que deseja consultar (Apenas Numeros): ");
            cepInformado = scanner.nextLine();

            if (cepInformado.equalsIgnoreCase("sair")){
                System.out.println();
                System.out.println("Sistema encerrado...");
                break;
            }

            System.out.println();

            System.out.println("Digite SAIR para encerrar o sistema.");

        }

    }
}

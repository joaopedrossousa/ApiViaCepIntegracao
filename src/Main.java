import br.dev.viacep.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSeja bem vindo ao sistema de consulta de CEP :) \n");

        int opcaoSelecionada;

        while (true) {

            System.out.println("[1] Informar CEP \n[2] CEP'S Consultados \n[3] Sair \nSelecione uma Opção: ");

            opcaoSelecionada = scanner.nextInt();
            scanner.nextLine();

            if (opcaoSelecionada == 1) {

                String cepInformado = " ";
                ConsultaCep consultaCep = new ConsultaCep();

                while (true) {

                    System.out.println("Informe o CEP que deseja consultar (Apenas Numeros): ");

                    cepInformado = scanner.nextLine();

                    if (cepInformado.equalsIgnoreCase("sair")) {
                        System.out.println("\nRetornando ao menu principal...");
                        break;
                    }

                    if (cepInformado.length() > 8) {
                        System.out.println("\nCEP invalido! (Apenas 8 digitos)");
                        continue;
                    }

                    try {
                        InfoCepJson novaConsulta = consultaCep.buscarEnd(cepInformado);
                        //System.out.println(novaConsulta);
                        GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
                        geradorDeArquivo.geradorDeArqJson(novaConsulta);

                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                        System.out.println("\nEncerrando Consulta...");
                        break;
                    }

                    System.out.println("\nDigite SAIR para retornar ao menu principal.");

                }
            } else if (opcaoSelecionada == 3) {
                System.out.println("\nEncerrando Sistema...");
                break;
            } else if (opcaoSelecionada == 2) {

                MostrarArquivos mostrarArquivos = new MostrarArquivos();

                mostrarArquivos.mostrarConsultas();

            }else{
                System.out.println("\nOpção Invalida...");
            }
        }
    }
}


import br.dev.viacep.InfoCep;
import br.dev.viacep.InfoCepJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println();

        System.out.println("Seja bem vindo ao sistema de consulta de CEP :)");

        System.out.println();

        String cepInformado = " ";

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        while (true){

            System.out.println("Informe o CEP que deseja consultar (Apenas Numeros): ");

            cepInformado = scanner.nextLine();

            if (cepInformado.length() > 8){
                System.out.println();
                System.out.println("CEP invalido! (Apenas 8 digitos)");
                continue;
            }

            String cepInformadoEncodada = URLEncoder.encode(cepInformado, StandardCharsets.UTF_8);

            String urlConsultaAPI = "https://viacep.com.br/ws/" + cepInformadoEncodada + "/json/";

            //realizando a requisição na API
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlConsultaAPI))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            InfoCepJson infoCepJson = gson.fromJson(json, InfoCepJson.class);

            InfoCep infoCep = new InfoCep(infoCepJson);

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

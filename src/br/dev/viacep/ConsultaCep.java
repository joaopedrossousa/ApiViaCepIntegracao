package br.dev.viacep;
import com.google.gson.Gson;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {

    public InfoCepJson buscarEnd (String cepInformado) throws URISyntaxException {
        URI endereco = new URI("https://viacep.com.br/ws/" + cepInformado + "/json/");
        //realizando a requisição na API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), InfoCepJson.class);

        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter o endereço.. :(");
        }


    }

}

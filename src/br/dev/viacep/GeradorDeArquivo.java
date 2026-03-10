package br.dev.viacep;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GeradorDeArquivo {

    public void geradorDeArqJson(InfoCepJson infoCepJson) throws IOException {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        Path pasta = Path.of("consultas_json");

        if (!Files.exists(pasta)){
            Files.createDirectories(pasta);
        }

        Path arquivo = pasta.resolve(infoCepJson.localidade() + ".json");

        try (FileWriter geradorArq = new FileWriter(arquivo.toFile())){
            geradorArq.write(gson.toJson(infoCepJson));
        }

        /*
        String diretorio = "consultas_json/" + infoCepJson.localidade() + ".json";

        FileWriter geradorDeArq = new FileWriter(diretorio);
        geradorDeArq.write(gson.toJson(infoCepJson));
        geradorDeArq.close();

         */

    }
}

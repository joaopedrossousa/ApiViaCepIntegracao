package br.dev.viacep;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class MostrarArquivos {

    public void mostrarConsultas(){

        Gson gson = new Gson();
        Path pasta = Path.of("consultas_json");

        try (Stream<Path> arquivos = Files.list(pasta)){
            arquivos
                    .filter(a -> a.toString().endsWith(".json"))
                    .forEach(arquivo -> {
                try {
                    String json = Files.readString(arquivo);

                    InfoCepJson consulta = gson.fromJson(json, InfoCepJson.class);
                    System.out.println("Cidade: " + consulta.localidade());
                    System.out.println("Estado: " + consulta.estado());
                    System.out.println("Região: " + consulta.regiao());
                    System.out.println("DDD: " + consulta.ddd());
                    System.out.println("--------------------");

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

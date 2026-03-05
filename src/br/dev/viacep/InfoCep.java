package br.dev.viacep;

public class InfoCep {
    private String nomeCidade;
    private String nomeEstado;
    private String regiao;
    private String ddd;

    public InfoCep(InfoCepJson infoCepJson) {
        this.nomeCidade = infoCepJson.localidade();
        this.nomeEstado = infoCepJson.estado();
        this.regiao = infoCepJson.regiao();
        this.ddd = infoCepJson.ddd();
    }

}

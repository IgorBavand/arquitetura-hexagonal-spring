package com.hexagonal.example.example.arq.hexagonal.application.core.domain;

public class EnderecoFrete {
    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Double frete;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getFrete() {
        return frete;
    }

    public void setFrete(Double frete) {
        this.frete = frete;
    }

    public static EnderecoFrete of(Endereco endereco) {
        var mapperEnderecoFrete = new EnderecoFrete();
        mapperEnderecoFrete.setBairro(endereco.getBairro());
        mapperEnderecoFrete.setCep(endereco.getCep());
        mapperEnderecoFrete.setCidade(endereco.getLocalidade());
        mapperEnderecoFrete.setRua(endereco.getLogradouro());
        mapperEnderecoFrete.setEstado(endereco.getUf());
        mapperEnderecoFrete.setComplemento(endereco.getComplemente());

        return mapperEnderecoFrete;
    }
}


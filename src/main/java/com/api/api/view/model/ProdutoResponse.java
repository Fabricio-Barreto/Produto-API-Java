package com.api.api.view.model;

//Essa classe é responsavel para mostrar o que será mandado como resposta para a requisição.
public class ProdutoResponse {
    
    //#region Atributos
    private Integer id;

    private String nome;

    private Integer quantidade;

    private Double valor;

    private String observacao;
    //#endregion

    
    //#region Getters and Setters
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    //#endregion
}

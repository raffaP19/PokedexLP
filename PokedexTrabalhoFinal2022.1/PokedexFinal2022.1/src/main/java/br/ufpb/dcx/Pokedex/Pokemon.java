package br.ufpb.dcx.Pokedex;

import java.util.Objects;

public class Pokemon {

    private String nome;
    private String habilidade;
    private String tipo;
    private String descricao;

    public Pokemon (String nome,String habilidade, String tipo, String descricao) {
        this.nome = nome;
        this.habilidade = habilidade;
        this.tipo = tipo;
        this.descricao = descricao;

    }


    public Pokemon() {
        this("","","","");

    }

    public String toString(){
        return "Pokemon " + this.getNome() + " de habilidade " + this.getHabilidade()+ " e de tipo "
                + this.getTipo()+ " com a descrição " + this.getDescricao();

    }

    public String getNome() {
        return this.nome;

    }

    public void setNome() {
        this.nome = nome;

    }

    public String getHabilidade() {
        return this.habilidade;

    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;

    }

    public String getTipo() {
        return this.tipo;

    }

    public void setTipo(String tipo) {
        this.tipo = tipo;

    }

    public String getDescricao() {
        return this.descricao;

    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(nome, pokemon.nome) && Objects.equals(habilidade, pokemon.habilidade) && Objects.equals(tipo, pokemon.tipo) && Objects.equals(descricao, pokemon.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, habilidade, tipo, descricao);

    }

}
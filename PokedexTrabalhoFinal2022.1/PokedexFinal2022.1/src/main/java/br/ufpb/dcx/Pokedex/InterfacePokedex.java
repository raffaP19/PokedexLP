package br.ufpb.dcx.Pokedex;

public interface InterfacePokedex {

    void cadastrarPokemon(Pokemon p) throws PokemonJaExisteException;

    Pokemon pesquisarPokemon(String nome) throws PokemonNaoExisteException;

    String listarPokemons();

    boolean apagarPokemon(String nome);


}

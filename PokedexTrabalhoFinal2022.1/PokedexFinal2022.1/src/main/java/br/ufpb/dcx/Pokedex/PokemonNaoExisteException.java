package br.ufpb.dcx.Pokedex;

public class PokemonNaoExisteException extends  Exception {

    public PokemonNaoExisteException (String notificacao) {
        super(notificacao);

    }

}

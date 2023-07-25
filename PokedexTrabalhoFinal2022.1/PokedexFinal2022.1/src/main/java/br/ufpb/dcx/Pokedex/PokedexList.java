package br.ufpb.dcx.Pokedex;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class PokedexList implements InterfacePokedex{

    private ArrayList<Pokemon> pokemon;
    private GravadorDeDados gravador = new GravadorDeDados("Pokemons.txt");
    public PokedexList() {
        this.pokemon = new ArrayList<>();

    }

    @Override
    public void cadastrarPokemon(Pokemon p) throws PokemonJaExisteException {
        if (this.pokemon.contains(p)) {
            throw new PokemonJaExisteException("Esse Pokémon já existe: " + p.toString());

        }else {
            this.pokemon.add(p);

        }

    }

    public void recuperaDados() throws IOException {
        ArrayList<String> textoLido = gravador.recuperaArquivo();
        for (String linha : textoLido) {
            String [] elementosLinhas = linha.split("#");
            Pokemon c = new Pokemon(elementosLinhas[0], elementosLinhas[1], elementosLinhas[2], elementosLinhas[3]);
            this.pokemon.add(c);

        }

    }

    public void salvarDados() throws IOException {
        ArrayList texto = new ArrayList<>();
        for (Pokemon c : this.pokemon) {
            String linha = c.getNome()+"#"+c.getHabilidade()+"#"+c.getTipo()+"#"+c.getDescricao();
            texto.add(linha);
        }
        gravador.gravaTextoEmArquivo(texto);

    }

    @Override
    public Pokemon pesquisarPokemon(String nome) throws PokemonNaoExisteException {
        for (Pokemon pk : this.pokemon) {
            if (pk.getNome().equals(nome)) {
                return pk;
            }
        }
        return null;

    }

    public Pokemon sorteiaPokemon() {
        Random random = new Random();
        int index = random.nextInt(pokemon.size());
        return this.pokemon.get(index);

    }

    @Override
    public String listarPokemons() {
        List <String> nomesPoke = new ArrayList<>();
        for (Pokemon pokemon: this.pokemon) {
            nomesPoke.add(pokemon.getNome());
        }
        return nomesPoke.toString();

    }

    @Override
    public boolean apagarPokemon(String nome) {
        for (Pokemon pk : this.pokemon) {
            if (pk.getNome().equals(nome)) {
                pokemon.remove(pk);
                JOptionPane.showMessageDialog(null, "Pokemon removido com sucesso ^-^");
                return true;
            }

        }
        return false;

    }

    public ArrayList<Pokemon> getPokemon() {
        return pokemon;

    }

    public void setPokemon(ArrayList<Pokemon> pokemon) {
        this.pokemon = pokemon;

    }

}
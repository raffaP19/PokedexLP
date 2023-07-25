package br.ufpb.dcx.ProjetoPokedex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import br.ufpb.dcx.Pokedex.PokedexList;
import br.ufpb.dcx.Pokedex.Pokemon;
import br.ufpb.dcx.Pokedex.PokemonJaExisteException;
import br.ufpb.dcx.Pokedex.PokemonNaoExisteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class PokedexListTest {

    PokedexList sistema;

    @BeforeEach
    void setUp() {
        this.sistema = new PokedexList();

    }

    @Test
    void testPesquisaPokemonNaPokedex() {
        try {
            sistema.pesquisarPokemon("Rafaela");

        } catch (PokemonNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
        //
        try {
            Pokemon poke = new Pokemon("Rafaela", "estudiosa", "estudante", "aluna acima da média");
            sistema.cadastrarPokemon(poke);
            sistema.pesquisarPokemon("Rafaela");
            assertEquals("Rafaela", poke.getNome());

        } catch (PokemonJaExisteException | PokemonNaoExisteException e) {
            fail("Não deveria lançar exceção");

        }
        //
    }

    @Test
    void cadastrarPokemon() {
        Pokemon poke = new Pokemon("Matheus", "gamer top", "estudante de LCC", "aluno acima da média");
        try {
            sistema.cadastrarPokemon(poke);
            assertEquals("Matheus", poke.getNome());
            assertEquals("gamer top", poke.getHabilidade());

        } catch (PokemonJaExisteException e) {
            fail("Não deveria lançar exceção");

        }
        //

    }

    @Test
    void remocaoPkemon() {
        Pokemon poke = new Pokemon("Rafaela", "estudiosa", "estudante", "aluna acima da média");
        try {
            sistema.cadastrarPokemon(poke);
        } catch (PokemonJaExisteException e) {
            //OK

        }
        sistema.apagarPokemon("Rafaela");
        try {
            assertEquals(null, sistema.pesquisarPokemon("Rafaela"));
        } catch (PokemonNaoExisteException e) {
            //OK
        }

    }

}
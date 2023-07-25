package br.ufpb.dcx.Pokedex;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.ArrayList;

public class MenuPokedex {

    public static void main (String [] args) {

        PokedexList sistema = new PokedexList();
        //
        try {
            //
            sistema.recuperaDados();
            JOptionPane.showMessageDialog(null, "Pokedex atualizada com sucesso :)");
            //
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel recuperar os dados");
            //
        }
        //
        JOptionPane.showMessageDialog(null,
                "******************************\n" +
                        "** Menu da Pokedex ^-^ **\n" +
                        "******************************");
        boolean continuar = true;
        //
        while(continuar) {
            try {
                //
                String opcao = JOptionPane.showInputDialog("DIgite uma opção:\n" +
                        "1. Cadastrar Pokémon\n" +
                        "2. Pesquisar Pokémon\n" +
                        "3. Lista de Pokémons Registrados\n" +
                        "4. Apagar Pokémon\n" +
                        "5. Sortear Pokémon\n" +
                        "6. Sair");
                //
                if (opcao.equals("1")) {
                    String nome = JOptionPane.showInputDialog("Digite o nome do Pokémon: ");
                    String habilidade = JOptionPane.showInputDialog("Digite a habilidade: ");
                    String tipo = JOptionPane.showInputDialog("Digite o tipo: ");
                    String descricao = JOptionPane.showInputDialog("Digite a descrição: ");
                    Pokemon p1 = new Pokemon(nome, habilidade, tipo, descricao);
                    sistema.cadastrarPokemon(p1);
                    JOptionPane.showMessageDialog(null, "Pokémon cadastrado com sucesso ^-^");
                    //
                } else if (opcao.equals("2")) {
                    String nome = JOptionPane.showInputDialog("Digite o nome do Pokémon: ");
                    Pokemon pokemonEncontrado = sistema.pesquisarPokemon(nome);
                    if (pokemonEncontrado == null) {
                        JOptionPane.showMessageDialog(null, "Pokémon não encontrado :/");
                    } else {
                        JOptionPane.showMessageDialog(null, "Pokémon que você está procurando é: \n" + pokemonEncontrado);
                    }
                    //
                } else if (opcao.equals("3")) {
                    JOptionPane.showMessageDialog(null, sistema.listarPokemons());
                    //
                } else if (opcao.equals("4")) {
                    String nome = JOptionPane.showInputDialog("Nome do Pokemon que vc deseja apagar da pokedex");
                    sistema.apagarPokemon(nome);
                    //
                } else if (opcao.equals("5")) {
                    JOptionPane.showMessageDialog(null, sistema.sorteiaPokemon().toString());
                    //
                } else if (opcao.equals("6")) {
                    continuar = false;
                    try {
                        sistema.salvarDados();
                        JOptionPane.showMessageDialog(null, "Pokemons Salvos com sucesso!");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Problemas ao salvar dados"+". Detalhes:"+ e.getMessage());
                    }

                    JOptionPane.showMessageDialog(null, "Fim da consulta a Pokedex. Até Mais!");
                    //
                }
                //
            }catch (PokemonJaExisteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
                //
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro no programa. Tente Novamente");
                e.printStackTrace();
                //
            }
            //
        }
        //
    }
    //
}

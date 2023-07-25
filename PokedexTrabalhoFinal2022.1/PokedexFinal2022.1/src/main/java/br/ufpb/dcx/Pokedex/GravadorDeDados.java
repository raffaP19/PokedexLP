package br.ufpb.dcx.Pokedex;

import java.io.*;
import java.util.ArrayList;

public class GravadorDeDados {

    private String nomeArquivo;

    public GravadorDeDados() {
        this.nomeArquivo = "Arquivo.txt";

    }

    public GravadorDeDados(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;

    }

    public ArrayList recuperaArquivo() throws IOException {
        BufferedReader leitor = null;
        ArrayList<String> textoLido = new ArrayList<>();
        try {
            leitor = new BufferedReader(new FileReader(this.nomeArquivo));
            String texto = null;
            do {
                texto = leitor.readLine();
                if (texto != null) {
                    textoLido.add(texto);
                }

            } while (texto != null);
        } finally {
            if (leitor != null) {
                leitor.close();
            }
        }
        return textoLido;

    }

    public void gravaTextoEmArquivo(ArrayList<String> texto) throws IOException {
        BufferedWriter gravador = null;
        try {
            gravador = new BufferedWriter(new FileWriter(this.nomeArquivo));
            for (String s : texto) {
                gravador.write(s+"\n");
            }
        } finally {
            if (gravador != null) {
                gravador.close();
            }

        }

    }

}

package com.example.classes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeituraArquivoTxt {
    public static List<String[]> lerArquivo(String nomeArquivo) {
        List<String[]> linhas = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                linhas.add(dados);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        
        return linhas;
    }

    public static char[] obterAlfabeto(List<String[]> vetores) {
        String primeiroCaminho = vetores.get(0)[1];
        return primeiroCaminho.toCharArray();
    }
}

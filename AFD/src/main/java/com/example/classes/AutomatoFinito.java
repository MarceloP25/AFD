package com.example.classes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutomatoFinito {
    private Map<String, Map<Character, String>> transicoes;
    private String[] estadosFinais;
    
    public AutomatoFinito(List<String[]> vetores, String[] estadosFinais) {
        this.transicoes = new HashMap<>();
        this.estadosFinais = estadosFinais;
        
        for (String[] vetor : vetores) {
            String estadoOrigem = vetor[0];
            char caminho = vetor[1].charAt(0);
            String estadoDestino = vetor[2];
            
            if (!transicoes.containsKey(estadoOrigem)) {
                transicoes.put(estadoOrigem, new HashMap<>());
            }
            
            Map<Character, String> transicoesDoEstado = transicoes.get(estadoOrigem);
            transicoesDoEstado.put(caminho, estadoDestino);
        }
    }
    
    public boolean testarPalavra(String palavra, String estadoInicial) {
        String estadoAtual = estadoInicial;
        char[] caracteres = palavra.toCharArray();
        String[] estadosPercurso = new String[caracteres.length];
        
        for (int i = 0; i < caracteres.length; i++) {
            char c = caracteres[i];
            
            if (!transicoes.containsKey(estadoAtual)) {
                return false;
            }
            
            Map<Character, String> transicoesDoEstado = transicoes.get(estadoAtual);
            if (!transicoesDoEstado.containsKey(c)) {
                return false;
            }
            
            estadoAtual = transicoesDoEstado.get(c);
            estadosPercurso[i] = estadoAtual;
        }
        
        imprimirPercurso(palavra, caracteres, estadosPercurso);
        
        return isEstadoFinal(estadoAtual);
    }
    
    private void imprimirPercurso(String palavra, char[] caracteres, String[] estadosPercurso) {
        System.out.println("Caractere \t Estado");
        
        for (int i = 0; i < caracteres.length; i++) {
            System.out.println(caracteres[i] + " \t " + estadosPercurso[i]);
        }
    }
    
    private boolean isEstadoFinal(String estado) {
        for (String estadoFinal : estadosFinais) {
            if (estadoFinal.equals(estado)) {
                return true;
            }
        }
        return false;
    }
}

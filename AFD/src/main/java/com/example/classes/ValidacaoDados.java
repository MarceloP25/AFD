package com.example.classes;
import java.util.List;

public class ValidacaoDados {
    public static boolean validarVetores(List<String[]> vetores) {
        for (String[] vetor : vetores) {
            if (vetor.length != 3) {
                return false;
            }
            
            if (!(vetor[0] instanceof String) || !(vetor[2] instanceof String)) {
                return false;
            }
            
            if (!(vetor[1].length() == 1 && Character.isLetter(vetor[1].charAt(0)))) {
                return false;
            }
        }
        
        return true;
    }
}

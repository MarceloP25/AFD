package com.example.classes;
import java.util.List;

public class ImpressaoAutomato {
    public static void imprimirAutomato(List<String[]> vetores, String[] estadosFinais) {
        System.out.println("Origem \t Caminho \t Destino");
        for (String[] vetor : vetores) {
            System.out.println(vetor[0] + " \t " + vetor[1] + " \t " + vetor[2]);
        }
        
        System.out.println("\nEstados finais: ");
        for (String estadoFinal : estadosFinais) {
            System.out.print(estadoFinal + " ");
        }
        
        System.out.println();
    }
}

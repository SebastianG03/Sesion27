package edu.universidad.sesion;

import java.util.HashMap;
import java.util.Map;

public class SistemaVotacion {
    private Map<String, Integer> votos;

    public SistemaVotacion() {
        votos = new HashMap<>();
    }

    // Método para registrar un voto para un candidato
    public void votar(String candidato) {
        if (candidato == null || candidato.isEmpty()) {
            throw new IllegalArgumentException("Nombre de candidato inválido.");
        }

        votos.put(candidato, votos.getOrDefault(candidato, 0) + 1);
    }

    // Método para contar votos de un candidato específico
    public int contarVotos(String candidato) {
        return votos.getOrDefault(candidato, 0);
    }

    // Método para mostrar todos los votos
    public void mostrarVotos() {
        if (votos.isEmpty()) {
            System.out.println("No hay votos registrados.");
            return;
        }

        System.out.println("Resultados de la votación:");
        for (Map.Entry<String, Integer> entry : votos.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " voto(s)");
        }
    }

    // Método auxiliar para pruebas (no imprime, sino retorna el mapa)
    public Map<String, Integer> obtenerVotos() {
        return votos;
    }
}

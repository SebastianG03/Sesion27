package edu.universidad.sesion;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaVotacionTest {

    // Clase interna para pruebas
    static class SistemaVotacion {
        private final Map<String, Integer> votos = new HashMap<>();

        public void votar(String candidato) {
            if (candidato == null || candidato.trim().isEmpty()) {
                throw new IllegalArgumentException("Nombre de candidato inválido.");
            }
            votos.put(candidato, votos.getOrDefault(candidato, 0) + 1);
        }

        public int contarVotos(String candidato) {
            return votos.getOrDefault(candidato, 0);
        }

        public Map<String, Integer> obtenerVotos() {
            return new HashMap<>(votos);
        }
    }

    @Test
    void testVotarYContar() {
        SistemaVotacion sistema = new SistemaVotacion();
        sistema.votar("Alice");
        sistema.votar("Alice");
        sistema.votar("Bob");

        assertEquals(2, sistema.contarVotos("Alice"));
        assertEquals(1, sistema.contarVotos("Bob"));
        assertEquals(0, sistema.contarVotos("Charlie"));
    }

    @Test
    void testVotarConNombreInvalido() {
        SistemaVotacion sistema = new SistemaVotacion();

        assertThrows(IllegalArgumentException.class, () -> sistema.votar(""));
        assertThrows(IllegalArgumentException.class, () -> sistema.votar(null));
    }

    @Test
    void testObtenerVotos() {
        SistemaVotacion sistema = new SistemaVotacion();
        sistema.votar("Alice");

        Map<String, Integer> votos = sistema.obtenerVotos();
        assertTrue(votos.containsKey("Alice"));
        assertEquals(1, votos.get("Alice"));
    }
}

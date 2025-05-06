package dijkstra.test;

import graph.Graph;
import graph.GraphListe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class GraphListeTest {

    @Test
    void testGetSuccesseurInexistant() {
        GraphListe<String> graph = new GraphListe<>();
        List<Graph.Arc<String>> successeurs = graph.getSucc("X");
        assertTrue(successeurs.isEmpty(), "Le sommet 'X' ne devrait avoir aucun successeur.");
    }

    @Test
    void testGetSuccesseurExistantSansArcs() {
        GraphListe<String> graph = new GraphListe<>();
        graph.ajouterSommet("Y");
        assertTrue(graph.getSucc("y").isEmpty(), "le sommet ne devrait pas avoir de successeur");
    }

    @Test
    void testGetSuccesseurAvecArcs() {
        GraphListe<String> graph = new GraphListe<>();
        graph.ajouterArc("A", "B", 3);
        graph.ajouterArc("A", "C", 5);

        List<Graph.Arc<String>> expected = List.of(
                new Graph.Arc<>(3, "B"),
                new Graph.Arc<>(5, "C")
        );

        assertEquals(expected, graph.getSucc("A"), "Les successeurs de A ne sont pas corrects.");

    }
}
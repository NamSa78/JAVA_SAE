package graph;

import java.util.*;

public class GrapheHHAdj implements VarGraph<String> {
    //Attribut : Une liste D'adjacence qui associe chaque sommet a ces successeur.
    private final Map<String, List<Arc<String>>> noeudVersSucceseur;

    //Constructeur d'une HashMap pour la liste D'adjacence
    public GrapheHHAdj() {
        this.noeudVersSucceseur = new HashMap<>();
    }

    //Méthodes
    public List<Arc<String>> getSucc(String s) {
        return noeudVersSucceseur.getOrDefault(s, List.of());
    }

    public void ajouterSommet(String noeud) {
        noeudVersSucceseur.putIfAbsent(noeud, new ArrayList<>());
    }

    public void ajouterArc(String source, String destination, Integer valuation) {
        if (noeudVersSucceseur.containsKey(source)) {
            noeudVersSucceseur.get(source).add(new Arc<>(valuation, destination));
        }
    }
}

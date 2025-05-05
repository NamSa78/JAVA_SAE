package graph;

import java.util.*;

public class GraphListe<T> implements Graph<T>{
        //Attribut : Une liste D'adjacence qui associe chaque sommet a ces successeur.
        private Map<T, List<Arc<T>>> adj;

        //Constructeur d'une HashMap pour la liste D'adjacence
        public GraphListe() {
            this.adj = new HashMap<>();
        }

    //Méthodes
    @Override
    public List<Arc<T>> getSucc(T s) {
        return adj.getOrDefault(s, List.of());
    }

    public void ajouterSommet(T sommet){
        if (!adj.containsKey(sommet)) {
            adj.put(sommet, new ArrayList<>());
        }
    }

    public void ajouterArc(T source, T destination, int valuation) {
        ajouterSommet(source);
        ajouterSommet(destination);
        adj.get(source).add(new Arc<>(valuation, destination));
    }
}

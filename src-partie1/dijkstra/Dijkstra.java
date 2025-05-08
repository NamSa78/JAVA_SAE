package dijkstra;

import graph.Graph;
import graph.ShortestPath;
import java.util.*;
import graph.Graph.Arc;

public class Dijkstra<T> implements ShortestPath<T> {

	@Override
	public Distances<T> compute(Graph<T> g, T src, Animator<T> animator) throws IllegalArgumentException {
		Map<T, Integer> dist= new HashMap<>();
		Map<T, T> pred = new HashMap<>();
		Set<T> visited = new HashSet<>();

		// file de priorité avec (sommet, distance)
		PriorityQueue<Map.Entry<T, Integer>> queue =
				new PriorityQueue<>(Map.Entry.comparingByValue());

		dist.put(src, 0);
		pred.put(src, null);
		queue.add(Map.entry(src, 0));


		//Algo Dijkstra
		while (!queue.isEmpty()) {
			T u = queue.poll().getKey();

			if (!visited.add(u)) continue;

			animator.accept(u, dist.get(u));

			for (Arc<T> arc : g.getSucc(u)) {
				T v = arc.dst();
				int weight = arc.val();

				if (weight < 0) throw new IllegalArgumentException("Arc de poids négatif");

				int newDist = dist.get(u) + weight;

				if (!dist.containsKey(v) || newDist < dist.get(v)) {
					dist.put(v, newDist);
					pred.put(v, u);
					queue.add(Map.entry(v, newDist));
				}
			}
		}


		return new ShortestPath.Distances<>(dist, pred);
	}

}

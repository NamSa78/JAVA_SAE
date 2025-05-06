package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrapheHHAdj implements VarGraph<String> {

	//Attribut
	private Map<String, List<String>> adjacencyList = new HashMap<String, List<String>>();

	@Override
	public List<Arc<String>> getSucc(String s) {
		return adjacencyList.getOrDefault(s, List.of());;
	}

	@Override
	public void ajouterSommet(String noeud) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterArc(String source, String destination, Integer valeur) {
		// TODO Auto-generated method stub
		
	}

}

package adaptator;

import graph.Graph;
import maze.regular.RegularMaze;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class GraphMaze implements Graph<Integer> {

    private final RegularMaze maze;

    public GraphMaze(RegularMaze maze) {
        this.maze = maze;
    }

    @Override
    public List<Arc<Integer>> getSucc(Integer from) {
        Set<Integer> opened = maze.openedNeighbours(from);
        return opened.stream()
                .map(to -> new Arc<>(1, to))
                .collect(Collectors.toList());
    }
}


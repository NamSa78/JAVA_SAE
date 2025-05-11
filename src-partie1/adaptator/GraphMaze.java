package adaptator;

import graph.Graph;
import maze.Maze;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GraphMaze<T> implements Graph<T> {

    private final Maze<T> maze;

    public GraphMaze(Maze<T> maze) {
        this.maze = maze;
    }

    @Override
    public List<Arc<T>> getSucc(T from) {
        Set<T> opened = maze.openedNeighbours(from);
        return opened.stream()
                .map(to -> new Arc<>(1, to)) // tous les arcs ont un coût de 1
                .collect(Collectors.toList());
    }
}


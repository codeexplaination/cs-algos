package codeexplaination.graphs.traversal;

import java.util.LinkedList;
import java.util.ListIterator;

public class DFS {
    private final int numberOfVertices; // number of vertices

    private final LinkedList<Integer>[] adjacencyList;

    DFS(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjacencyList = new LinkedList[this.numberOfVertices];

        for (int i = 0; i < numberOfVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    private void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    public static void main(String[] args) {
        DFS dfs = new DFS(4);
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);

        dfs.printDFS();
    }

    public void printDFS() {
        boolean[] visited = new boolean[numberOfVertices]; // initialize all vertices as non visited by default

        for (int i = 0; i < numberOfVertices; i++) {
            if (visited[i] == false) {
                printFDSUtil(i, visited);
            }
        }
    }

    private void printFDSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true; // mark the current vertex as visited
        System.out.print(vertex + " ");

        ListIterator<Integer> integerListIterator = adjacencyList[vertex].listIterator();

        while (integerListIterator.hasNext()) {
            int node = integerListIterator.next();
            if (!visited[node]) {
                printFDSUtil(node, visited);
            }
        }

    }
}

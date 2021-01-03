package codeexplaination.graphs.traversal;

import java.util.LinkedList;
import java.util.ListIterator;

public class BFS {
    private final int numberOfVertices; // number of vertices

    private final LinkedList<Integer>[] adjacencyList;

    BFS(int numberOfVertices) {
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
        BFS bfs = new BFS(4);
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);

        System.out.println("BFS of the graph from node vertex 2 is: ");
        bfs.printBFS(2);
    }

    public void printBFS(int sourceNode) {
        boolean[] visited = new boolean[numberOfVertices];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[sourceNode] = true;
        queue.add(sourceNode);

        while (queue.size() != 0) {
            sourceNode = queue.poll();
            System.out.print(sourceNode + " ");

            ListIterator<Integer> integerListIterator = adjacencyList[sourceNode].listIterator();
            while (integerListIterator.hasNext()) {
                int n = integerListIterator.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }

        }
    }
}

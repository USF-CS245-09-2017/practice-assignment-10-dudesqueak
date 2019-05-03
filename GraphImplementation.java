import java.io.*;
import java.util.*;

public class GraphImplementation implements Graph{
    public int V;   // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency List
    public int[][] adjacency_matrix; // Adjacency MATRIX
    public int vertices;

    //Constructor
    GraphImplementation(int vertices) {
        V = vertices;
        adjacency_matrix = new int [vertices][vertices];

    }

    // Function to add an edge into the graph
    public void addEdge(int v1, int v2) {
        adjacency_matrix[v1][v2] = 1;
    }

    //finds the vertex's neighbors
    @Override
    public int[] neighbors(int vertex) {
        List<Integer> neighbors = new ArrayList<Integer>();
        for (int j=0; j< adjacency_matrix[vertex].length; j ++) {
            if(adjacency_matrix[vertex][j] != 0) {
                neighbors.add(j);
            }
        }
        int[] n2 = new int[neighbors.size()];
        for (int i = 0; i < neighbors.size(); i++){
            n2 [i] = neighbors.get(i);
        }
        return n2;
    }


    // The function to do Topological Sort. It uses
    // recursive topologicalSortUtil()
    public List<Integer> topologicalSort() {
        List<Integer> res = new ArrayList<Integer>();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                topologicalSortUtil(i, visited, res);
            }
        }

        return res;

    }

    void topologicalSortUtil(int v, boolean visited[], List<Integer> res) {
        // Mark the current node as visited.
        visited[v] = true;


        int[] neighbors = neighbors(v);
        for(int i = 0; i < neighbors.length; i++){
            if(!visited[neighbors[i]]){
                topologicalSortUtil(neighbors[i], visited, res);
            }
        }


        res.add(0,v);
    }





}

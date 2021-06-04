package sample;

public class Graph<T extends Comparable<T>> extends WeightedGraph<T, Integer> {

    public boolean addEdge(T source, T destination) {
        return super.addEdge(source, destination, 1);
    }

    public boolean addUndirectedEdge(T v1, T v2, int w1, int w2) {
        boolean a, b;
        a = addEdge(v1, v2, w1);
        b = addEdge(v2, v1, w2);
        return (a && b);
    }
}
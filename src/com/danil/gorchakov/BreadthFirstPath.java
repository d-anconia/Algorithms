package com.danil.gorchakov;


public class BreadthFirstPath {

    private boolean[] marked; // Известен ли кратчайший путь к этой вершине
    private int[] edgeTo; // Последняя вершина на известном пути к данной вершине
    private final int s; // Исходящая вершина

    public BreadthFirstPath(Graph graph, int s) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.s = s;
        bfs(graph, s);
    }

    private void bfs(Graph graph, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true; // Пометка исходной вершины
        queue.enqueue(s); // и помещение ее в очередь
        while (!queue.isEmpty()) {
            int v = queue.dequeue(); // Извлечение из очереди следующей вершины
            for (int w : graph.adj(v))
                if (!marked[w]) { // Для каждой непомеченной смежной вершины

                    edgeTo[w] = v; // сохраненяем последнее ребро в кратчайшем пути
                    marked[w] = true; // получаем ее, т.к. путь известен
                    queue.enqueue(w); // и заносим ее в очередь

                }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

}

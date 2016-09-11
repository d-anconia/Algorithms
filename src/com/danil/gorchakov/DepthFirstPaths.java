package com.danil.gorchakov;


public class DepthFirstPaths {
    private boolean [] marked; // Вызывался ли dfs() для этой вершины
    private int [] edgeTo; // Последняя вершина на известном пути до данной вершины
    private final int s; // Исходная вершина

    public DepthFirstPaths(Graph graph, int s){
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.s = s;
        dfs(graph,s);
    }
    private void dfs(Graph graph, int v){
        marked[v] = true;
        for(int w : graph.adj(v))
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(graph,w);
            }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}

package com.danil.gorchakov;

// Поиск в глубину для нахождения связных компонентов в графе

public class CC {
    private boolean [] marked;
    private int [] id;
    private int count;

    public CC(Graph graph) {
        marked = new boolean[graph.V()];
        for(int s = 0; s < graph.V(); s++)
            if(!marked[s]){
            dfs(graph,s);
                count++;
            }
    }
    private void dfs(Graph graph, int v){
        marked[v] = true;
        id[v] = count;
        for(int w : graph.adj(v))
            if(!marked[w])
                dfs(graph,w);
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }
    public int id(int v){
        return id[v];
    }
    public int count(){
        return count;
    }

}

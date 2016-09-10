package com.danil.gorchakov;

import edu.princeton.cs.introcs.In;

import java.util.Iterator;

public class Graph {
    private final int V; // количество вершин
    private int E; // количество
    private Bag<Integer> [] adj; // списки смежных верщин
    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V]; // создание массива списков
        for(int v = 0; v < V; v++) // Вначале все списки создаются пустыми
            adj[v] = new Bag<Integer>();
    }
    public Graph(In in){
        this(in.readInt()); // Чтение V и создание графа
        int E = in.readInt(); // Чтение E
        for(int i = 0; i < E; i++){
            // Добавление ребра
            int v = in.readInt(); // чтение вершины
            int w = in.readInt(); // чтение другой вершины
            addEdge(v,w);         // и добавление соединяющего их ребра
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

}

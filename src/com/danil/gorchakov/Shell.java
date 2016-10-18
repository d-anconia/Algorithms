package com.danil.gorchakov;


public class Shell {
    public static void sort(Comparable[] a){
        // Сортировка по возрастанию
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3*h + 1; // 1, 4, 13 , 40, 121, ..
        while(h >=1){
            // h-сортировка массива
            for(int i = h; i < N; i++){
                // Вставка a[i] между a[i-h], a[i-2*h], a[i-3*h]..
                for(int j = i; j>= h && less(a[j],a[j-h]); j-=h)
                    exch(a,j,j-h);
            }
            h=h/3;
        }
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

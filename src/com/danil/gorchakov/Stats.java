package com.danil.gorchakov;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<Double>();
        while(!StdIn.isEmpty())
            numbers.add(StdIn.readDouble());
        int N = numbers.size();

        double sum = 0.0;
        for(double x : numbers)
            sum+=x;
        double mean = sum/N;

        sum = 0.0;
        for(double x : numbers)
            sum+= (x - mean)*(x - mean);
        double std = Math.sqrt(sum/(N-1));
        StdOut.printf("Среднее: %.2f\n", mean);
        StdOut.printf("Среднее кв. откл.: %.2f\n",std);
    }
}

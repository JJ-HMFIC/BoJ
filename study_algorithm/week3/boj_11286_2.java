package study_algorithm.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_11286_2 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) ->{
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if(first == second) return o1 > o2 ? 1 : -1;
            else return first - second;
        } ));

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            } else pq.add(x);

        }
    }
}
// public PriorityQueue(Comparator<? super E> comparator) {
//        this(DEFAULT_INITIAL_CAPACITY, comparator);
//    }

class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        int first = Math.abs(o1);
        int second = Math.abs(o2);

        if (first == second) {
            return o1 > o2 ? 1 : -1;
        } else {
            return first - second;
        }
    }
}
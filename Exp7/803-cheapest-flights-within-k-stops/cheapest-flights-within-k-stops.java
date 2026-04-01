import java.util.*;

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int cost = flights[i][2];

            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(v);
            temp.add(cost);
            al.get(u).add(temp);
        }

        Queue<int[]> q = new LinkedList<>();
        int diff[] = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Integer.MAX_VALUE;
        }

        diff[src] = 0;
        q.add(new int[]{src, 0, 0});  // node, cost, stops

        while (!q.isEmpty()) {
            int arr[] = q.remove();
            int u = arr[0];
            int w = arr[1];
            int s = arr[2];

            if (s > k) continue;

            for (int i = 0; i < al.get(u).size(); i++) {
                int v = al.get(u).get(i).get(0);
                int wt = al.get(u).get(i).get(1);

                if (w + wt < diff[v]) {
                    diff[v] = w + wt;
                    q.add(new int[]{v, diff[v], s + 1});
                }
            }
        }

        return diff[dst] == Integer.MAX_VALUE ? -1 : diff[dst];
    }
}
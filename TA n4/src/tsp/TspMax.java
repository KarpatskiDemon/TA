package tsp;

import java.util.Arrays;

public class TspMax {

    public static final int N1 = 4;
    public static int[] finalPath1 = new int[N1 + 1];
    public static boolean[] visited1 = new boolean[N1];
    public static int finalRes1 = Integer.MIN_VALUE;

    public static void tspMax(int[][] adj) {

        int[] currPath = new int[N1 + 1];
        int currBound = 0;
        Arrays.fill(finalPath1, - 1);
        Arrays.fill(visited1, false);

        for (int i = 0; i < N1; i++) {
            currBound += (firstMax(adj, i) + secondMax(adj, i));
        }
        currBound = (currBound %2 == 1) ?
                currBound/2 + 1 :
                currBound/2;

        visited1[0] = true;
        currPath[0] = 0;
        tspMaxRec(adj, currBound, 0, 1, currPath);
    }

    public static void tspMaxRec(int[][] adj, int currBound, int currWeight, int level, int[] currPath) {
        if (level == N1) {
            if (adj[currPath[level - 1]][currPath[0]] != 0) {

                int curRes = currWeight + adj[currPath[level - 1]][currPath[0]];

                if (curRes > finalRes1) {
                    copyToFinalMax(currPath);
                    finalRes1 = curRes;
                }
            }
            return;
        }

        for (int i = 0; i < N1; i++) {

            if (adj[currPath[level - 1]][i] != 0 && !visited1[i]) {
                int temp = currBound;
                currWeight += adj[currPath[level - 1]][i];

                if (level == 1) {
                    currBound -= ((firstMax(adj, currPath[level - 1]) + firstMax(adj, i)) / 2);
                } else {
                    currBound -= ((secondMax(adj, currPath[level - 1]) + firstMax(adj, i)) / 2);
                }

                if (currBound + currWeight > finalRes1) {
                    currPath[level] = i;
                    visited1[i] = true;
                    tspMaxRec(adj, currBound, currWeight, level + 1, currPath);
                }

                currWeight -= adj[currPath[level - 1]][i];
                currBound = temp;

                Arrays.fill(visited1, false);
                for (int j = 0; j <= level - 1; j++) {
                    visited1[currPath[j]] = true;
                }
            }
        }
    }

    public static int firstMax(int[][] adj, int i) {
        int max = Integer.MIN_VALUE;
        for (int k = 0; k < N1; k++) {
            if (adj[i][k] > max && i != k) {
                max = adj[i][k];
            }
        }
        return max;
    }

    public static int secondMax(int[][] adj, int i) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int j = 0; j < N1; j++) {
            if (i == j) continue;

            if (adj[i][j] >= first) {
                second = first;
                first = adj[i][j];
            } else if (adj[i][j] >= second &&
                    adj[i][j] != first) {
                second = adj[i][j];
            }
        }
        return second;
    }

    public static void copyToFinalMax(int[] currPath) {
        for (int i = 0; i < N1; i++) {
            finalPath1[i] = currPath[i];
        }
        finalPath1[N1] = currPath[0];
    }
}

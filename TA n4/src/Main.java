import tsp.*;

public class Main {
    public static void main(String[] args) {

        int[][] adj = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        TspMin.tspMin(adj);
        System.out.printf("%nМінімальна вартість : %d%n", TspMin.finalRes);
        System.out.print("Обраний маршрут : ");
        for (int i = 0; i <= TspMin.N; i++) {
            System.out.printf("%d ", TspMin.finalPath[i]);
        }

        TspMax.tspMax(adj);
        System.out.printf("%n%nМаксимальна вартість : %d%n", TspMax.finalRes1);
        System.out.print("Обраний маршрут : ");
        for (int i = 0; i <= TspMax.N1; i++) {
            System.out.printf("%d ", TspMax.finalPath1[i]);
        }
    }
}

package greedyAlgorithmsHomework;

/*
Максимальний прибуток зі змагань
Умова:
Дано n змагань. Кожне змагання має:
час початку start[i],
час закінчення end[i],
прибуток profit[i].
Потрібно вибрати набір неперетинаючихся змагань так, щоб максимізувати загальний прибуток.
 */
public class ContestProfit {
    public static void main(String[] args) {

        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int[] profit = {50, 20, 100, 200, 150, 80};
        int n = start.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (end[i] > end[j]) {
                    swap(start, i, j);
                    swap(end, i, j);
                    swap(profit, i, j);
                }
            }
        }

        int maxProfit = 0;

        for (int i = 0; i < n; i++) {
            int currentEnd = end[i];
            int currentProfit = profit[i];
            for (int j = i + 1; j < n; j++) {
                if (start[j] >= currentEnd) {
                    currentEnd = end[j];
                    currentProfit = currentProfit + profit[j];
                }
            }
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }
        System.out.println("Максимальний прибуток: " + maxProfit);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }//ctrl v
}
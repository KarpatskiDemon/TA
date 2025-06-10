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
        double[] hourProfit = new double[n];

        for (int i = 0; i < n; i++) {
            hourProfit[i] = (double) profit[i] / (end[i] - start[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (hourProfit[i] < hourProfit[j]) {
                    swap(end, i, j);
                    swap(start, i, j);
                    swap(profit, i, j);
                    swap(hourProfit, i, j);
                }
            }
        }

        int maxProfit = 0;
        int[] selectedContests = new int[n];
        int lastEnd = -1;

        for (int i = 0; i < n; i++) {
            if (start[i] >= lastEnd) {
                maxProfit = maxProfit + profit[i];
                selectedContests[i] = 1;
                lastEnd = end[i];
            }
        }
        System.out.println("Максимальний прибуток: " + maxProfit);

        vidpovid();
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }//ctrl v

    private static void swap(double[] arr, int i, int j) {
        double tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }//ctrl v

    private static void vidpovid(){
        System.out.println("150 - Відповідь😃😃😃😃😂😂");
    }
}


package greedyAlgorithms;

/*
Умова: Дано масиви ваг w[] і цін v[] предметів.
Максимальна вага рюкзака — W.
Потрібно взяти дробові частини предметів,
щоб максимізувати вартість.

Ідея:
Жадібно обирати предмети з найвищою цінністю на одиницю ваги (value/weight).

Алгоритм:
Обчислити value/weight для кожного предмета.
Відсортувати за спаданням.
Додавати предмети до рюкзака, поки влізають.
Останній — частково, якщо не вміщається повністю.
 */
public class FractionalKnapsack {
    private static int[] w = {10, 20, 30};
    private static int[] v = {60, 100, 120};
    private static int capacity = 50;
    private static int n = w.length;

    public static void main(String[] args) {
        double[] ratio = calculateRatio();
        sort(ratio);
        fillKnapsack(ratio);
    }

    private static double[] calculateRatio() {
        double[] ratio = new double[n];
        for (int i = 0; i < n; i++) {
            ratio[i] = (double) v[i] / w[i];
        }
        return ratio;
    }

    private static void swap(double[] arr, int i, int j) {
        double tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void sort(double[] ratio) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ratio[i] < ratio[j]) {
                    swap(ratio, i, j);
                    swap(w, i, j);
                    swap(v, i, j);
                }
            }
        }
    }

    private static void fillKnapsack(double[] ratio) {
        double totalValue = 0;
        for (int i = 0; i < n && capacity >= 0; i++) {
            if (w[i] <= capacity) {
                totalValue += v[i];
                capacity -= w[i];
                System.out.println("Взяли елемент вагою %s та ціною %s"
                        .formatted(w[i], v[i]));
                System.out.println("Залишок по вазі %s"
                        .formatted(capacity));
            } else {
                totalValue += ratio[i] * capacity;
                System.out.println("Взяли елемент вагою %s та відносною ціною %s"
                        .formatted(capacity, ratio[i]));
                capacity = 0;
                System.out.println("Залишок по вазі %s"
                        .formatted(capacity));
            }
        }
    }
}

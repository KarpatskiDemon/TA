package greedyAlgorithms;

/*
Умова: Дано початки та кінці інтервалів.
Обрати максимальну кількість таких, що не перекриваються.

Ідея:
Жадібно завжди вибирати інтервал з найменшим кінцем, який не перекривається з попереднім.

Алгоритм:
Відсортувати всі інтервали за end[i].
Почати з першого.
Для кожного наступного перевірити: якщо не перетинається з попереднім — додати.
 */
public class IntervalScheduling {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int n = start.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (end[i] > end[j]) {
                    swap(start, i, j);
                    swap(end, i, j);
                }
            }
        }

        int count = 1;
        int lastEnd = end[0];
        System.out.println("взяли подію з початком %s та кінцем %s".formatted(start[0], end[0]));
        for (int i = 1; i < n; i++) {
            if (start[i] >= lastEnd) {
                count++;
                lastEnd = end[i];
                System.out.println("взяли подію з початком %s та кінцем %s".formatted(start[i], end[i]));
            }
        }
        System.out.println("максимальна кількість інтервалів, що неперетинаються: %s".formatted(count));
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }  //ctrl c
}

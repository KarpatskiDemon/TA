package greedyAlgorithms;

/*
Покриття відрізка точками
Умова: Дано n відрізків. Потрібно вибрати найменшу кількість точок так, щоб кожен відрізок мав хоча б одну точку всередині.

Ідея:
Жадібно вибираємо найранішу точку — праву межу інтервалу, що ще не покритий.

Алгоритм:
Відсортувати інтервали за r.
Встановити першу точку в r[0].
Пропустити всі інтервали, які ця точка покриває.
Повторити для решти.
 */
public class SegmentCovering {
    public static void main(String[] args) {
        int[] left = {4, 1, 2, 5};
        int[] right = {7, 3, 5, 6};
        int n = left.length;

        // Сортуємо за правим кінцем
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (right[i] > right[j]) {
                    swap(left, i, j);
                    swap(right, i, j);
                }
            }
        }

        int[] points = new int[n];
        int pointCount = 0;
        int lastPoint = -1;

        for (int i = 0; i < n; i++) {
            if (lastPoint < left[i]) {
                lastPoint = right[i];
                points[pointCount++] = lastPoint;
            }
        }

        System.out.print("Потрібно точок: " + pointCount + "\nТочки: ");
        for (int i = 0; i < pointCount; i++) {
            System.out.print(points[i] + " ");
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}


package sort;
/*
Відсортувати тільки непарні елементи масива за спаданням.
Парні елементи залишаються на своїх місцях.
Сортування вибором
 */

public class SortOdds {
    public static void main(String[] args) {
        int[] arr = {4, 7, 3, 2, 9, 6};
        selectionSortOddsDesc(arr);
        printArray(arr);
    }

    public static void selectionSortOddsDesc(int[] array) {
        int count = 0;
        for (int value : array) {
            if (value % 2 != 0) {
                count++;
            }
        }

        int[] oddIndexes = new int[count];
        int idx = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                oddIndexes[idx++] = i;
            }
        }

        for (int i = 0; i < count - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < count; j++) {
                if (array[oddIndexes[j]] > array[oddIndexes[maxIdx]]) {
                    maxIdx = j;
                }
            }
            swap(array, oddIndexes[i], oddIndexes[maxIdx]);
        }
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) return;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArray(int[] array) {
        for (int el : array) {
            System.out.print(el + " ");
        }
    }

}

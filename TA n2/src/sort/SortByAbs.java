package sort;
/*
Відсортувати масив цілих чисел за зростанням модуля чисел(абсолютне значення).
Якщо модулі дорівнюють одне одному, порядок може бути будь-яким.
Вхідний масив: 3, -1, -7, 4, -2, 0
Вихідний масив: 0, -1, -2, 3, 4, -7
 */
public class SortByAbs {
    public static void main(String[] args) {
        int[] array = {3, -1, -7, 4, -2, 0};
        printArray(insertionSortByAbs(array));
    }

    public static int[] insertionSortByAbs(int[] array) {
        for (int partIndex = 1; partIndex < array.length; partIndex++) {
            int curUnsorted = array[partIndex];
            int i = 0;
            for (i = partIndex; i > 0 && Math.abs(array[i - 1]) > Math.abs(curUnsorted); i--) {
                array[i] = array[i - 1];
            }
            array[i] = curUnsorted;
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int el : array) {
            System.out.print(el + " ");
        }
    }

}

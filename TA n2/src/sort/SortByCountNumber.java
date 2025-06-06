package sort;
/*
Відсортувати масив цілих чисел по зростанню кількості цифр в числі.
Якщо в чисел однакова кількість цифр - зберегти вхідний порядок(стабільне сортування не потрібне)
Ввід: [5, 100, 23, 4, 9999]
Вивід: [5, 4, 23, 100, 9999]
 */
public class SortByCountNumber {
    public static void main(String[] args) {
        int[] array = {5, 100, 23, 4, 9999};
        printArray(sortByDigitCount(array));
    }

    public static int[] sortByDigitCount(int[] array) {
        for (int partIndex = array.length - 1; partIndex > 0; partIndex--) {
            int largestAt = 0;
            for (int i = 1; i <= partIndex; i++) {
                if (digitCount(array[i]) > digitCount(array[largestAt])) {
                    largestAt = i;
                }
            }
            swap(array, largestAt, partIndex);
        }
        return array;
    }

    public static int digitCount(int num) {
        num = Math.abs(num);
        if (num == 0) return 1;
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
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

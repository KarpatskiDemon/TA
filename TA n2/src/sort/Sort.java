package sort;

public class Sort {
    public static void main(String[] args) {
        int[] array = {4, 2, 45, 23, -1};
//        printArray(bubbleSort(array));
//        printArray(selectionSort(array));
        printArray(insertionSort(array));
    }


    public static int[] bubbleSort(int[] array) {
        for (int partIndex = array.length - 1; partIndex > 0; partIndex--) {
            for (int i = 0; i < partIndex; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }

        return array;
    }

    public static int[] selectionSort(int[] array) {
        for (int partIndex = array.length - 1; partIndex > 0; partIndex--) {
            int largestAt = 0;
            for (int i = 1; i <= partIndex; i++) {
                if (array[i] > array[largestAt]) {
                    largestAt = i;
                }
            }
            swap(array, largestAt, partIndex);
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {
        for (int partIndex = 1; partIndex < array.length; partIndex++) {
            int curUnsorted = array[partIndex];
            int i = 0;
            for (i = partIndex; i > 0 && array[i - 1] > curUnsorted; i--) {
                array[i] = array[i - 1];
            }
            array[i] = curUnsorted;
        }
        return array;
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

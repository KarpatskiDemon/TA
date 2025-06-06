package sort;
/*
Є масив строк. Необхідно відсортувати по першій літері слів(по алфавіту, ігноруючи регістр)
Ввід: ["banana", "Apple", "cherry", "avocado"]
Вивід: ["Apple", "avocado", "banana", "cherry"]
 */
public class SortByFirstChar {
    public static void main(String[] args) {
        String[] arr = {"banana", "Apple", "cherry", "avocado", "Avocado"};
        selection(arr);
        printArray(arr);
    }

    public static void selection(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < array.length; j++) {
                char c1 = Character.toLowerCase(array[j].charAt(0));
                char c2 = Character.toLowerCase(array[minIdx].charAt(0));
                if (c1 < c2) {
                    minIdx = j;
                }
            }
            swap(array, i, minIdx);
        }
    }

    public static void swap(String[] array, int i, int j) {
        if (i == j) return;
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArray(String[] array) {
        for (String s : array) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}

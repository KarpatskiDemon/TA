public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 5, 3, 56, 56, 34, 56};

        System.out.print("Масив до заміни : ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                arr[i] = min;
            }
        }

        System.out.print("Масив після заміни : ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

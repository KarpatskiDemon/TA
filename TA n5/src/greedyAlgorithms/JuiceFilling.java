package greedyAlgorithms;

/*
Розлив соку (бутилки)
Умова: Є пляшки з різними об’ємами та великий графин.
Потрібно наповнити якомога більше соку з графина в пляшки.
Наповнювати потрібно з найменших пляшок, поки вистачає соку.

Ідея:
Жадібно починаємо з найменших пляшок, щоб помістилося якомога більше.

Алгоритм:
Відсортувати об’єми пляшок за зростанням.
Іти по черзі, поки сік ще є.
Додавати пляшки до рахунку, поки вміщаються.
 */
public class JuiceFilling {
    public static void main(String[] args) {
        int[] bottles = {2, 3, 1, 5, 4};
        int juice = 10;
        int n = bottles.length;

        for(int i = 0; i < n -1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (bottles[i] > bottles[j]) {
                    swap(bottles, i, j);
                }
            }
        }

        int filledBottles = 0;
        for (int i = 0; i < n; i++) {
            if (juice >= bottles[i]) {
                juice -= bottles[i];
                filledBottles++;
                System.out.println("Наповнюємо пляшку ємністю %s"
                        .formatted(bottles[i]));
                System.out.println("соку залишилось %s"
                        .formatted(juice));
                System.out.println("Поточна кількість наповнених пляшок %s"
                        .formatted(filledBottles));
            }
        }
        System.out.println("наповнено пляшок: %s"
                .formatted(filledBottles));
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}

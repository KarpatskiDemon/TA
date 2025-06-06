package greedyAlgorithms;

/*
Мінімальна кількість заправок
Умова: Автомобіль має бак на maxDist км. Є відстані між заправками.
Знайти мінімальну кількість зупинок, щоб доїхати до фінішу.

Ідея:
Жадібно на кожному етапі їхати якнайдалі, вибираючи останню доступну заправку в межах досяжності.

Алгоритм:
Почати з першої точки.
Поки можливо, рухатись до найдальшої досяжної заправки.
Кожен такий стрибок — одна зупинка.
Якщо немає доступної — рішення неможливе.
 */
public class RefuelingStops {
    public static void main(String[] args) {
        int[] stations = {0, 100, 200, 300, 400, 500}; // координати заправок
        int maxDist = 150; // макс. відстань без заправки
        int n = stations.length;
        int refills = 0;
        int pos = 0;

        while (pos < n - 1) {
            int next = pos;
            while (next + 1 < n && stations[next + 1] - stations[pos] <= maxDist) {
                next++;
            }
            if (pos == next) {
                System.out.println("Неможливо доїхати");
                return;
            }
            if (next < n - 1) {
                refills++;
            }
            pos = next;
        }

        System.out.println("Мінімум заправок: " + refills);
    }
}


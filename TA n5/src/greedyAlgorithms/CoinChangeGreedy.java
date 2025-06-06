package greedyAlgorithms;

/*
Розмін монети (мінімальна кількість монет)
Умова: Дано номінали монет та суму S.
Знайти мінімальну кількість монет,
необхідних для утворення цієї суми.
Кожен номінал можна використовувати необмежену кількість разів.

*/
public class CoinChangeGreedy {
    public static void main(String[] args) {
        int[] coins = {25, 10, 5, 1};
        int sum  = 63; //25 + 25 + 10 + 1 + 1 + 1

        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            while (sum >= coins[i]) {
                sum = sum - coins[i];
                count++;
                System.out.println("Беремо монету номіналом %s"
                        .formatted(coins[i]));
                System.out.println("Залишилось добрати %s"
                        .formatted(sum));
            }
        }
        System.out.println("Мінімальна кількість монет: %s"
                .formatted(count));
    }
}

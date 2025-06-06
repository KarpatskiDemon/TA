package tsp;

import java.util.Arrays;

public class TspMin {


// Java програма для розв'язання задачі комівояжера
// за допомогою методу гілок та меж (Branch and Bound).

    public static final int N = 4;
    // final_path[] зберігає кінцеве рішення, тобто
    // маршрут комівояжера.

    public static int[] finalPath = new int[N + 1];
    // visited[] відстежує вже відвідані вузли
    // на певному маршруті
    public static boolean[] visited = new boolean[N];

    // Зберігає кінцеву мінімальну вагу найкоротшого туру.
    public static int finalRes = Integer.MAX_VALUE;

    public static void tspMin(int[][] adj) {

        // Обчислюємо початкову нижню межу для кореневого вузла
        // за формулою 1/2 * (сума першої мінімальної +
        // другої мінімальної вартості ребер для всіх вузлів).
        // Також ініціалізуємо curr_path та visited масиви
        int[] currPath = new int[N + 1];
        int currBound = 0;
        Arrays.fill(finalPath, - 1);
        Arrays.fill(visited, false);

        // Обчислення початкової межі
        for (int i = 0; i < N; i++) {
            currBound += (firstMin(adj, i) + secondMin(adj, i));
        }

        // Округлення нижньої межі до цілого числа
        currBound = (currBound %2 == 1) ?
                currBound/2 + 1 :
                currBound/2;

        // Починаємо з вершини 0, тому
        // перша вершина у curr_path[] — це 0
        visited[0] = true;
        currPath[0] = 0;

        // Виклик TSPRec з curr_weight рівним
        // 0 і level 1
        tspMinRec(adj, currBound, 0, 1, currPath);
    }

    // Функція, яка приймає аргументи:
    // curr_bound -> нижня межа кореневого вузла
    // curr_weight -> зберігає вагу шляху на даний момент
    // level -> поточний рівень при обході дерева пошуку
    // curr_path[] -> де зберігається розв’язок, який
    //               пізніше буде скопійовано в final_path[]
    public static void tspMinRec(int[][] adj, int currBound, int currWeight, int level, int[] currPath) {

        // базовий випадок — коли досягнуто рівня N, що
        // означає, що всі вузли відвідані по одному разу
        if (level == N) {

            // перевіряємо, чи існує ребро від останньої вершини в
            // маршруті назад до першої вершини
            if (adj[currPath[level - 1]][currPath[0]] != 0) {
                // curr_res має загальну вагу
                // отриманого рішення
                int curRes = currWeight + adj[currPath[level - 1]][currPath[0]];

                // Оновити кінцевий результат та маршрут,
                // якщо поточний результат кращий.
                if (curRes < finalRes) {
                    copyToFinalMin(currPath);
                    finalRes = curRes;
                }
            }
            return;
        }

        // для інших рівнів перебираємо всі вершини
        // для побудови дерева пошуку рекурсивно
        for (int i = 0; i < N; i++) {

            // Розглядаємо наступну вершину, якщо вона не та сама (не діагональ
            // в матриці суміжності) і ще не була відвідана
            if (adj[currPath[level - 1]][i] != 0 && !visited[i]) {
                int temp = currBound;
                currWeight += adj[currPath[level - 1]][i];

                // різні обчислення curr_bound для
                // рівня 2 у порівнянні з іншими рівнями
                if (level == 1) {
                    currBound -= ((firstMin(adj, currPath[level - 1]) + firstMin(adj, i)) / 2);
                } else {
                    currBound -= ((secondMin(adj, currPath[level - 1]) + firstMin(adj, i)) / 2);
                }

                // curr_bound + curr_weight - фактична нижня межа
                // для вузла, на який ми прийшли
                // Якщо поточна нижня межа < final_res, досліджуємо вузол далі
                if (currBound + currWeight < finalRes) {
                    currPath[level] = i;
                    visited[i] = true;

                    // виклик TSPRec для наступного рівня
                    tspMinRec(adj, currBound, currWeight, level + 1, currPath);
                }

                // Інакше обрізаємо цю гілку, скидаючи
                // усі зміни в curr_weight та curr_bound
                currWeight -= adj[currPath[level - 1]][i];
                currBound = temp;

                // Також скидаємо масив visited
                Arrays.fill(visited, false);
                for (int j = 0; j <= level - 1; j++) {
                    visited[currPath[j]] = true;
                }
            }
        }
    }

    // Функція знаходить мінімальну вартість ребра,
    // що закінчується у вершині i
    public static int firstMin(int[][] adj, int i) {
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < N; k++) {
            if (adj[i][k] < min && i != k) {
                min = adj[i][k];
            }
        }
        return min;
    }

    // Функція знаходить другу мінімальну вартість ребра,
    // що закінчується у вершині i
    public static int secondMin(int[][] adj, int i) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int j = 0; j < N; j++) {
            if (i == j) continue;

            if (adj[i][j] <= first) {
                second = first;
                first = adj[i][j];
            } else if (adj[i][j] <= second &&
                    adj[i][j] != first) {
                second = adj[i][j];
            }
        }
        return second;
    }

    // Функція копіює тимчасове рішення до
    // кінцевого рішення
    public static void copyToFinalMin(int[] currPath) {
        for (int i = 0; i < N; i++) {
            finalPath[i] = currPath[i];
        }
        finalPath[N] = currPath[0];
    }

}

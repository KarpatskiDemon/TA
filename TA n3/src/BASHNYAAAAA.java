public class BASHNYAAAAA {

    public static final int N = 5;

    public static void main(String[] args) {
        solve();
    }

    public static void placeBashnya(int[] pole, int row) {
        if (row == N) {
            printPole(pole);
            return;
        }
        for (int col = 0; col < N; col++) {
            if (isSafe(pole, row, col)) {
                pole[row] = col;
                placeBashnya(pole, row + 1);
            }
        }
    }

    public static void printPole(int[] pole) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                System.out.print(pole[row] == col ? "R\t" : ".\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafe(int[] pole, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (pole[i] == col) {
                return false;
            }
        }
        return true;
    }

    public static void solve() {
        int[] pole = new int[N];
        placeBashnya(pole, 0);
    }

}

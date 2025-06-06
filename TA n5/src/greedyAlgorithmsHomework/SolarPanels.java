package greedyAlgorithmsHomework;

/*
Задача про сонячні панелі
Умова: Встановити якнайбільше панелей, які вміщуються на даху довжиною L.
 */
public class SolarPanels {
    public static void main(String[] args) {
        int[] panels = {3, 2, 5, 1};
        int L = 7;

        //Сортування за зростанням
        for (int i = 0; i < panels.length - 1; i++){
            for(int j = i + 1; j <  panels.length; j++) {
                if (panels[i] > panels[j]) {
                    swap(panels, i, j);
                }
            }
        }

        int total = 0;
        int count = 0;

        for (int i = 0; i < panels.length; i++) {
            if (total + panels[i] <= L) {
                total = total + panels[i];
                count = count + 1;
            }
        }
        System.out.println("Установлено панелей: " + count);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }//ctrl v

}

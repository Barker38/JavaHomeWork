package JavaHomeWork;
// Реализовать алгоритм сортировки массива слиянием
// Создать массив
// В методе сортировки слиянием мы должны брать массив, делить его пополам. У нас должно получиться 2 части.
// Левая и правая. Далее нужно сравнивать значения этих двух половинок и меньшее из 2х значений ложить в новый массив.
//

public class Task003 {

    public static void main(String[] args) {

        int[] src = { 17, -24, 20, -15, -21, -3, 13, 2, 4, 5, 23, 5, 435, 56, 7, 546 };
        int d = src.length;

        System.out.println("Исходный массив: ");
        for (int i = 0; i < src.length; i++)
            System.out.print(src[i] + " ");

        System.out.println();

        // Отсоритровать массив
        mergeSort(src, d);

        System.out.println("Отсортированный массив: ");
        for (int i = 0; i < src.length; i++)
            System.out.print(src[i] + " ");
    }

    public static void mergeSort(int[] src, int n) {

        if (n < 2)
            return;

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        System.arraycopy(src, 0, left, 0, mid);
        System.arraycopy(src, mid, right, 0, n - mid);

        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(src, left, right, mid, n - mid);

    }

    public static void merge(int[] src, int[] left, int[] right, int leftLength, int rightLength) {
        int k = 0, i = 0, j = 0;

        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j])
                src[k++] = left[i++];
            else
                src[k++] = right[j++];
        }

        while (i < leftLength) {
            src[k++] = left[i++];
        }

        while (j < rightLength) {
            src[k++] = right[j++];
        }

    }
}



import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[100000];
        int[] b = new int[100000];

        a = mergeSort(a);
        b = bubbleSort(b);

        long start = System.nanoTime();
        System.out.println("Merge Sort");
        long time = System.nanoTime() - start;
        System.out.println(time + " Nanosegundos");

        System.out.println("Bubble Sort");
        long time1 = System.nanoTime() - start;
        System.out.println(time1 + " Nanosegundos");
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int c = 0; c < arr.length; c++) {
                if (arr[i] < arr[c]) {
                    int temp = arr[i];
                    arr[i] = arr[c];
                    arr[c] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int medio = arr.length / 2;

        int[] abajo = new int[medio];
        int[] arriba = new int[arr.length - medio];
        for (int a = 0; a < medio; a++) {
            abajo[a] = arr[a];
        }

        for (int a = 0; a < arriba.length; a++) {
            arriba[a] = arr[a + abajo.length];
        }
        return merge(mergeSort(abajo), mergeSort(arriba));
    }

    public static int[] merge(int[] a, int[] b) {
        int[] retval = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (j < a.length && k < b.length) {
            if (a[j] < b[k]) {
                retval[i++] = a[j++];
            } else {
                retval[i++] = b[k++];
            }
        }
        while (j < a.length) {
            retval[i++] = a[j++];
        }
        while (k < b.length) {
            retval[i++] = b[k++];
        }
        return retval;
    }
}

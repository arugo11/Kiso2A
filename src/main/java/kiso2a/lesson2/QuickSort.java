    package kiso2a.lesson2;

    public class QuickSort {
        public static void main(String[] args)
        {
            String[] a = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

            for(int i = 0; i < a.length; i++)
            {
                System.out.println(a[i]);
            }
            sort(a,0,a.length-1);
            for(int i = 0; i < a.length; i++)
            {
                System.out.println(a[i]);
            }
        }
static void sort(String a[], int low, int high) {
    if (low < high) {
        int i = low, j = high;
        String pivot = a[(low + high) / 2];
        while (i <= j) {
            while (a[i].compareTo(pivot) < 0) i++;
            while (a[j].compareTo(pivot) > 0) j--;
            if (i <= j) {
                String temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) sort(a, low, j);
        if (i < high) sort(a, i, high);
    }
}


    }


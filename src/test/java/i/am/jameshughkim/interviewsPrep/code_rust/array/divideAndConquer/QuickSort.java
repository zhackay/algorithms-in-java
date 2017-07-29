package i.am.jameshughkim.interviewsPrep.code_rust.array.divideAndConquer;

public class QuickSort {
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int partition(int arr[], int lo, int hi)
    {
        int pivot = arr[hi];
        int i = (lo-1); // index of smaller element
        for (int j=lo; j<hi; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, hi);

        return i+1;
    }

    void sort(int arr[], int lo, int hi)
    {
        if (lo >= hi) return;

        /* pi is partitioning index, arr[pi] is now at right place */
        int p = partition(arr, lo, hi);

        // Recursively sort elements before partition and after partition
        sort(arr, lo, p-1);
        sort(arr, p+1, hi);
    }
}

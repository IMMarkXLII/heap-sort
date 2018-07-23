/**
 * @author ashish.adhikari
 */
package sort.heap;

/**
 * @author ashish.adhikari
 *
 */
public class HeapSort {
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
 
    // Driver program
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;
 
        HeapSort ob = new HeapSort();
        ob.sort(arr);
 
        System.out.println("Sorted array is");
        printArray(arr);
    }

	/**
	 * @param arr
	 */
	private void sort(int[] arr) {
		int l = arr.length;
		
		for(int i=l/2-1; i>=0;i--) {
			heapify(arr, l, i);
		}
		
		for(int i=l-1; i>=0; i--) {
			int t = arr[0];
			arr[0] = arr[i];
			arr[i] = t;
			
			heapify(arr, i, 0);
		}
		
	}

	/**
	 * @param arr
	 * @param i
	 * @param j
	 */
	private void heapify(int[] arr, int length, int i) {
		int largest = i;
		int left = i*2 + 1;
		int right = i*2 + 2;
		
		if(left < length && arr[left] > arr[largest])
			largest = left;
		if(right < length && arr[right] > arr[largest])
			largest = right;
		
		if(largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			heapify(arr, length, largest);
		}
	}
}

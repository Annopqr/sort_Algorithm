package sort_Algorithm;

public class QuickSort {
	public static void sort(int[] a) {
		l_pivot_sort(a, 0, a.length - 1);
	}
	
	private static void l_pivot_sort(int[] a, int lo, int hi) {
		if(lo >= hi) { 
			// 요소가 1개인 경우
			return;
		}
		
		int pivot = l_partition(a, lo, hi);
		
		l_pivot_sort(a, lo, pivot - 1);
		l_pivot_sort(a, pivot + 1,hi);
	}
	
	private static int l_partition(int[] a, int left, int right) {
		int lo = left;
		int hi = right;
		int pivot = a[left];
		
		while(lo < hi) {
			while(a[hi] > pivot && lo < hi) {
				/**
				 * hi의 요소는 lo보다 크면서, pivot보다 작거나 같은 요소를 찾으면 반복문 break;
				 * */
				hi--;
			}
			
			while(a[lo] <= pivot && lo < hi) {
				/**
				 * lo의 요소는 hi보다 작으면서, pivot보다 큰요소를 찾으면 반복문 break;
				 * */
				lo++;
			}
			
			swap(a, lo, hi);
			
			
		}
		
		swap(a, left, lo);
		
		return lo;
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}

package sort_Algorithm;

public class MergeSort {
private static int[] sorted;
	
	public static void merge_sort(int[] a) {
		sorted = new int[a.length];
		merge_sort(a, 0 , a.length - 1);
		sorted = null;
	}
	
	// bottom - up 방식 구현
	private static void merge_sort(int[] a, int left, int right) {
		
		for(int size = 1; size <= right; size += size) {
			for(int l = 0; l <= right - size; l += (2 * size)) {
				int low = l;
				int mid = l + size - 1;
				int high = Math.min(l + (2 * size) - 1, right);
				merge(a, low, mid, high); // 병합작업
			}
		}
		
	}
	
	private static void merge(int[] a, int left, int mid, int right) {
		int l = left; 
		int r = mid + 1; 
		int idx = left; 
		
		while(l <= mid && r <= right) {
			if(a[l] <= a[r]) {
				sorted[idx] = a[l];
				idx++;
				l++;
			}
			else {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		}
		
		if(l > mid) {
			while(r <= right) {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		}
		else {
			while(l <= mid) {
				sorted[idx] = a[l];
				idx++;
				l++;
			}
		}
		
		
		for(int i = left; i <= right; i++) {
			a[i] = sorted[i];
		}
	}


}

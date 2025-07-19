public class Main
{
	public int findMinApproach1(int n,int[] arr){
		/*the time complexity is O(n) because we are looping throw every element in the array */
		int min = arr[0];
		for(int i=1;i<n;i++){
			if(arr[i] < min){
				min = arr[i];
			}
		}
		return min;
	}	
	public int findMinApproach2(int n,int[] arr) { //n is the size of array
		/* here the time complexity is O(log n) */
		int low = 0;
		int high = n-1;
		while(low < high){
		    int mid = (low+high)/2;
		    if(arr[mid] > arr[high]){
		        low = mid+1;
		    } else {
		        high = mid;
		    }
		}
		return arr[low];
	}
}   

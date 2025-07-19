
public class Main
{
	public static int countSubarraysApproach1(int n, int[] arr,int k) {
	    /* First approach : time complexity is O(n³) */
    int count = 0;
	    for(int i=0;i<n;i++){
	        for(int j=i;j<n;j++){
	            int sum = 0;
	            for(int l = i ;  l <= j;l++){
	                sum += arr[l];
	            }
	            if(sum == k){
	                count++;
	            }
	        }
	    }
    return count;
	}
  
  public static int countSubarraysApproach2(int n,int[] arr, int k ){
    /* there is a another function which can find count of subarray sum equal to k but the time complexty 
  here is O(n²). */
    int count = 0;
      for(int i=0;i<n;i++){
        int sum = 0;
        for(int j=i;j<n;j++){
          sum += arr[j];
          if(sum == k){
            count++;
          }
        }
      }
    return count;
  }

public static int countSubarraysApproach3(int n,int[] arr,int k){
  /* this approach has time complexity of O(n) where n is the size of array and space complexity 
  is also O(n) */
  int count = 0;
  int sum = 0;
  HashMap<Integer,Integer> map = new HashMap<>();
  map.put(0,1); //base case
    for(int num : arr){
    sum += num;
    if(map.containsKey(sum-k)){
      count += map.get(sum-k);
    }
    //now updating the sum
    map.put(sum,map.getOrDefault(sum,0)+1);
  }
  return count;
 }
}
  

  







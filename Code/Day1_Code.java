//Question-:
//
//Given an array of 4 digits, return the largest 24 hour time that can be made.
//
//The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, 
//a time is larger if more time has elapsed since midnight.
//
//Return the answer as a string of length 5. 
//If no valid time can be made, return an empty string.
//
// 
//
//Example 1:
//
//Input: [1,2,3,4]
//Output: "23:41"
//Example 2:
//
//Input: [5,5,5,5]
//Output: ""
// 
//
//Note:
//
//A.length == 4
//0 <= A[i] <= 9



class Solution {
    int max= -1;
	    public String largestTimeFromDigits(int[] A) {
	        lt(A,0);
	        
	        if(max==-1){
	            return "";
	        }
	        else{
	            return String.format("%02d:%02d",max/60,max%60);
	        }
	     }
	    private void lt(int[] arr,int start){
	        if(start==arr.length){
	            buildTime(arr);
	            return;
	        }
	        for(int i=start;i<arr.length;i++){
	            swap(arr,i,start);
	            lt(arr,start+1);
	            swap(arr,i,start);
	        }
	    }
	    private void buildTime(int[] arr){
	        int hour=arr[0]*10+arr[1];
	        int minute=arr[2]*10+arr[3];
	        if(hour<24 && minute<60){
	            max=Math.max(max,hour*60+minute);
	            
	        }
	    }
	    private void swap(int[] arr,int i,int j){
	        if(i==j) {
	            return;
	        }
	        else{
	            int temp=arr[i];
	            arr[i]=arr[j];
	            arr[j]=temp;
	        }
	    }
	    public static void main(String[] args) {
	    	System.out.println("enter the elements of array");
	    	Scanner sc=new Scanner(System.in);
	    	int[] arr=new int[4];
	    	for(int i=0;i<4;i++) {
	    		arr[i]=sc.nextInt();
	    	}

	    	
	    }
}

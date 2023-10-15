public class Main
{
	public static void main(String[] args) {
	int arr[]={-5,6,7,12,34};//input array 
	int target=23;//target element 
	int low=0;
	int high=arr.length-1;
	while(low<=high){
	    int midp=(low+high)/2;
	    int midnum=arr[midp];
	    if(target==midnum){
	        System.out.print(midp); //if element present in the array return the index number 
	    }
	    else if(midnum<target){
	        low=midp+1;
	    }
	    else{
	        high=midp-1;
	    }
	}
	System.out.print(low); //if the target element not found insert the position it should be placed 
	}
}

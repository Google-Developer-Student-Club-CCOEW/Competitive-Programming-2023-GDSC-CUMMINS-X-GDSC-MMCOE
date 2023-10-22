public class Largest
{
	public static void main(String[] args) {
	int arr[]={12,-3,4,56,6,7,8};
	int n=arr.length;
	int max=-1;
	for(int i=0;i<n;i++){
	    if(arr[i]>max){
	        max=arr[i];
	        
	    }
	}
	System.out.println(max);
	}
}

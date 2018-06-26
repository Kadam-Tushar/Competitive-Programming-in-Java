import java.util.*;

class binarySearch{
static int[] arr={-3,5,6,1}; //test i/p
public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		pn("Enter number of elements");
		int n=sc.nextInt();
		arr=new int[n];
		for(int i=0;i<n;++i) arr[i]=sc.nextInt();

		Arrays.sort(arr);

		pn("enter key to search ");
		int key=sc.nextInt();	
		pn("Result from Iterative BS "+bsi(key));
		pn("Result from Recursive BS "+bsr(0,arr.length-1,key));



}

static int bsi(int key)
{
	int start=0,end=arr.length-1;
	int mid=0;
	while(start<end){
		mid=(start+end)/2;
		if(arr[mid]>key)
			end=mid-1;
		else if(arr[mid]==key) {
				break;
			}
		else start=mid+1;	
	}
	if(arr[start]!=key) return -1;
	return start;

}
static int bsr(int start ,int end, int key)
{
	if(start>=end)
	{
		return arr[start]==key?start:-1; 
	}
	int mid=(start+end)/2;
	if(arr[mid]>key)
		return bsr(start,mid-1,key);
	else if(arr[mid]==key) return mid;
	else return bsr(mid+1,end,key);

}

static void pn(Object o)
{System.out.println(o);}
static void pa(int[] arr)
{System.out.println(Arrays.toString(arr));}
}
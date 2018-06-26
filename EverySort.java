import java.util.*;
class EverySort{
public static void main(String[] args) {
	int n=10;
	

	int [] arr=createRandomInput(n);
	pn("Initial array"); pa(arr);
	selectionSort(arr);
	pn(" selectionSort ");pa(arr);


	pn("");
	pn("");

	arr=createRandomInput(n);
	pn("Initial array"); pa(arr);
	insertionSort(arr);
	pn(" insertionSort ");pa(arr);

	pn("");
	pn("");

	arr=createRandomInput(n);
	pn("Initial array"); pa(arr);
	quickSort(arr,0,n-1);
	pn("quickSort ");pa(arr);

	pn("");
	pn("");


	arr=createRandomInput(n);
	pn("Initial array"); pa(arr);
	mergeSort(arr,0,n-1);
	pn("mergeSort ");pa(arr);







}

static void mergeSort(int[] arr,int start ,int end){
	if(start<end)
	{
		int mid=(start+end)/2;
		mergeSort(arr,start,mid);
		mergeSort(arr,mid+1,end);
		merge(arr,start,mid,end);
	}

}
static void  merge(int[] arr,int start,int mid,int end){
	
	int[] left=new int[mid-start+2]; // one extra element in left and right for 
	int[] right=new int[end-mid+1]; // adding infinity at end of each array

	left[left.length-1]=Integer.MAX_VALUE;
	right[right.length-1]=Integer.MAX_VALUE;

	for(int i=0;i<left.length-1;++i) left[i]=arr[start+i];
	for(int i=0;i<right.length-1;++i) right[i]=arr[i+mid+1];
		
	int i=0,j=0;
	for(int k=start;k<=end;++k){
		
		if(left[i]<right[j]){
			arr[k]=left[i];
			i++;
		}
		else{
			arr[k]=right[j];
			j++;
		} 
	}

}

static void quickSort(int[] arr,int p,int q)
{
	if(p<q)
	{	
	int r=partition(arr,p,q);
	quickSort(arr,p,r-1);
	quickSort(arr,r+1,q);
	}

}
static int partition(int[] arr,int p,int q)
{
	int pivot=arr[q];
	int i=p-1;
	for(int j=p;j<=q-1;++j)
	{
		if(arr[j]<pivot)
		{
			i++;
			swap(arr,i,j);
		}
	}
	swap(arr,i+1,q);

	return i+1;
}

static void insertionSort(int[] arr)
{
	for(int i=1;i<arr.length;++i)
	{
		int key=arr[i];
		int j=i-1;
		while(j>-1&&key<arr[j]) //Dont use key<arr[j]&&j>-1 
								//check if j is valid index and then check condition    
		{
			arr[j+1]=arr[j];
			j--;
		}
		arr[j+1]=key;
	}
}

static void selectionSort(int[] arr){
	for(int i=0;i<arr.length;++i){
		
		int ind=findMinimumIndex(arr,i);	
		swap(arr,ind,i);
	}

}

static int findMinimumIndex(int[] arr,int start)
{
	int ind=start;
	int key=arr[ind];
	for(int i=start;i<arr.length;++i){
		if(arr[i]<key){
			key=arr[i];
			ind=i;
		}
	}
	return ind;
}

static  void swap(int [] arr,int i,int j)
{
	int temp=arr[i];
	arr[i]=arr[j];
	arr[j]=temp;
}


static int[] createRandomInput(int size)
{
	Random r=new Random();
	int [] arr=new int[size];

	for(int i=0;i<size;++i) arr[i]=r.nextInt(100);
		return arr;
}
	static void pn(Object o)
	{ System.out.println(o);}
	static void pa(int[] arr)
	{ System.out.println(Arrays.toString(arr));}
}
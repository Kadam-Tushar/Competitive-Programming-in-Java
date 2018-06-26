import java.util.*;
class prims{
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
		pn("Enter vertices ");
		int v=sc.nextInt();

	
		int adjMat[][]=new int[v][v];
		pn("Enter matrixz");

		for(int i=0;i<v;++i)
			for(int j=0;j<v;++j)
					adjMat[i][j]=sc.nextInt();
		
		int cost[]=new int[v];
		boolean visited[] =new boolean[v];
		pn("Enter source");
		int src=sc.nextInt();
		cost[src-1]=0;
		for(int i=0;i<v;++i) 
			if(i!=src-1) cost[i]=1000; //infinity

		int [] parent=new int[v];
		ArrayList<String> edjList=new ArrayList<>();
		int mstWt=0;
		for(int i=0;i<v;++i)
		{
			int vertex=minimum_NotVisited(cost,visited);
			visited[vertex]=true;
			edjList.add((vertex+1)+" "+(parent[vertex]+1));
			mstWt+=adjMat[vertex][parent[vertex]];
			for(int j=0;j<v;++j)
			{
				if(adjMat[vertex][j]<cost[j])
				{
					cost[j]=adjMat[vertex][j];
					parent[j]=vertex;
				}
			}

		}
		pn("mstwt "+mstWt);
		pn("edjList is "+edjList);
		//test input
		// 0 10 6 5 
		// 10 0 1000 15
		// 6 1000 0 4
		// 5 15 4 0

}
static int minimum_NotVisited(int[] arr,boolean[] vis){
    int min=Integer.MAX_VALUE;
    int minIndex=-1;

    for(int i=0;i<arr.length;++i)
    {
        if(min>arr[i]&&(!vis[i])) {
        	min=arr[i];
        	minIndex=i;
        }
    }
    return minIndex;
}
static void pn(Object o){
	System.out.println(o);
}
}
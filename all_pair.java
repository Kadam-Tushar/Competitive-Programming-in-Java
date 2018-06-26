import java.util.*;
class all_pair{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		pn("Enter num of vertices ");
		int v=sc.nextInt();
		int[][] cost=new int[v][v];
		int[][] path=new int[v][v];
		for(int i=0;i<v;++i)
			for(int j=0;j<v;++j) cost[i][j]=sc.nextInt();

		//infinity=1000,no-path=-1
		for(int i=0;i<v;++i){
			for(int j=0;j<v;++j) {
					if(cost[i][j]!=1000&&i!=j) path[i][j]=i;
					else path[i][j]=-1;

			}

		}
		for(int i=0;i<v;++i) pa(path[i]);
		pn("");		

		for(int k=0;k<v;++k){
			for(int i=0;i<v;++i){
				for(int j=0;j<v;++j){
					if(cost[i][j]>cost[i][k]+cost[k][j]){
						cost[i][j]=cost[i][k]+cost[k][j];
						path[i][j]=path[k][j];

					}
				}

			}
		}

		for(int i=0;i<v;++i) pa(cost[i]);
			pn("");
		for(int i=0;i<v;++i) pa(path[i]);





		for(int i=0;i<v;++i){

			for(int j=0;j<v;++j){
				if(i==j) continue;
				pn("Path from "+(i+1)+" "+(j+1));
				int s=i,d=j;
					System.out.print((j+1)+" ");
				while(path[s][d]!=i){
					System.out.print((d+2)+" ");
					d=path[s][d];

				}
				System.out.println((i+1)+" ");
				pn("");
				

			}
			}

// 5
// 0 3 8 1000 -4
// 1000 0 1000 1 7
// 1000 4 0 1000 1000
// 2 1000 -5 0 1000
// 1000 1000 1000 6 0



	}
static void pn(Object o){
	System.out.println(o);
}
static void pa(int[] arr)
{
	pn(Arrays.toString(arr));

}
}
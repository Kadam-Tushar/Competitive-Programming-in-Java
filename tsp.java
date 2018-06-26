import java.util.*;
class tsp{
	static int[][] adjMat;
	static int v;
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	pn("Enter num of vertices and matrix");
	 v=sc.nextInt();
	 adjMat=new int[v][v];
	for(int i=0;i<v;++i)
			for(int j=0;j<v;++j) adjMat[i][j]=sc.nextInt();

	pn("Start vertex for tsp");
	int start=sc.nextInt();		
	HashSet<Integer> vis=new HashSet<>();
	vis.add(start);
	int minDist=1000;
	for(int i=0;i<v;++i)
	{
		if(!vis.contains(i))
		{
			vis.add(i);
			minDist=Math.min(adjMat[start][i]+tspDist(i,start,vis),minDist);
			//pn("mid from 1 to "+i+" "+minDist);
			vis.remove(i);
		}		
		
	}
	pn(minDist);
	// 0 10 15 20 
	// 10 0 35 25
	// 15 35 0 30
	// 20 25 30 0



}
static int tspDist(int src,int dest,HashSet<Integer> vis)
{
	if(vis.size()==v) return adjMat[src][dest];

	int minDist=1000;
	int i=0;
	while(vis.size()<v&&i<v)
	{
		if(!vis.contains(i))
		{
			vis.add(i);
			minDist=Math.min(adjMat[src][i]+tspDist(i,dest,vis),minDist);
			//pn("from "+src+" to "+dest+" "+minDist);
			vis.remove(i);
		}
		i++;
	}
	return minDist;
}
static void pn(Object o){
	System.out.println(o);
}
}
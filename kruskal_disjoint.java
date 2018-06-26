import java.util.*;
class kruskal_disjoint{
	static int[] P,R;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		pn("Enter vertices and edges ");
		int v=sc.nextInt();
		int e=sc.nextInt();
		create_set(v);
		ArrayList<pair> al=new ArrayList<>();
		for(int i=0;i<e;++i){
				al.add(new pair(sc.nextInt(),sc.nextInt(),sc.nextInt()));  //enter wt,x,y
		}
		Collections.sort(al);
		pn(al);
		int mstWt=0;
		
		ArrayList<pair> mstSet=new ArrayList<>();
		
		for(pair p:al){
			if(find_set(p.x)!=find_set(p.y)){
				union(p.x,p.y);
				mstSet.add(p);
				mstWt+=p.wt;
			} 

		}
		pn(mstWt);
		pn(mstSet);






	}
static void pn(Object o){
	System.out.println(o);
}
static void create_set(int v){
	P=new int[v+1];
	R=new int[v+1];
	for(int i=0;i<P.length;++i) P[i]=i;
}	

static int find_set(int x){
 	if(x!=P[x])
 		P[x]=find_set(P[x]);
 	return P[x];
 }
 static void union(int x,int y){
 	int px=find_set(x);
 	int py=find_set(y);

 	if(R[px]>R[py]) P[py]=px;
 	else P[px]=py;
 	if(R[px]==R[py]) R[py]=R[py]+1;
 }

} class pair implements Comparable<pair>{
	int wt,x,y;
	pair(int wt,int x,int y)
	{
		this.wt=wt;
		this.x=x;
		this.y=y;
	}
	public int compareTo(pair p)
	{
		return this.wt-p.wt;
	}
	public String toString()
	{
		return wt+" "+x+" "+y;
	}

}
import java.util.*;
class Disjoint{
	static int[] P,R;
	public static void main(String[] args) {
		
		create(10);

		union(0,1); union(1,2); union(2,3);
		pn("Parents of 0,1,2,3 must be same "+find(0)+" "+find(1)+" "+find(2)+" "+find(3));
		union(4,5);
		pn("parent of (4,5) is  "+find(4)+" "+find(5));
		
		union(2,4);
        
		pn("AFter union parent 4 is "+find(4)+" parent of 1 is "+find(1));

		/* output
		Parents of 0,1,2,3 must be same 1 1 1 1
        parent of (4,5) is  5 5
        AFter union parent 4 is 5 parent of 1 is 5
        */
	}
static void pn(Object o){
	System.out.println(o);
}
static void create(int v){
	P=new int[v]; R=new int[v];
	for(int i=0;i<v;++i)   P[i]=i;
}	
 static int find(int x){
    return P[x]=(x!=P[x]?find(P[x]):P[x]);
 }
static void union(int x,int y){
 	int px=find(x),py=find(y);
 	if(R[px]>R[py])  P[py]=px;
 	 else P[px]=py;
 	if(R[px]==R[py]) R[py]+=1;
 }

}


ArrayList<ArrayList<pair>> g=new ArrayList<>();
LinkedList<Integer> q=new LinkedList<>();
boolean blocked[];
int[] subTreeSum,parent;

long solveTree(int root,int componentSize){
    return 0l;
}


void dfs(int s,int par){
	ArrayList<pair> adj=g.get(s);
	subTreeSum[s]=1;
	parent[s]=par;
	for(pair p:adj){
		if(p.x==par || blocked[p.x]) continue;
		dfs(p.x,s);
		subTreeSum[s]+=subTreeSum[p.x];
	}
}

long go(int entryP){
	dfs(entryP,entryP);
	int centroid=entryP;
	int bestSize = subTreeSum[entryP];
	q.add(entryP);
	int componentSize=0;
	while(!q.isEmpty()){
		int i=q.poll();
		componentSize++;
		
		int size=subTreeSum[entryP]-subTreeSum[i];
		ArrayList<pair> adj=g.get(i);
		for(pair p:adj){
			if( p.x == parent[i] || blocked[p.x] ) continue;
			q.add(p.x);
			size=Math.max(size,subTreeSum[p.x]);		
		}
		
		if( bestSize > size ){
			bestSize=size;
			centroid=i;
		}

		
		
	}
	// pn("centroid "+centroid);
	// long ways = solveTree(centroid,componentSize);
	// blocked[centroid] =true;
	// ArrayList<pair> adj=g.get(centroid);
	// for(pair p:adj){
	// 	if(blocked[p.x]) continue;
	// 	ways += go(p.x); 
	// }
	// return ways;
}
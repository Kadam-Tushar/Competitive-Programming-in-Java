ArrayList<ArrayList<Integer>> g ;
boolean vis[] ;


void dfs(int s,int p){
	if(vis[s]) return ;
	vis[s] = true ;
	for(int x: g[s]){
		if(x==p) continue ;
		dfs(x,s); 
	}
}


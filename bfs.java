void bfs(int s){
	LinkedList<pair> q = new LinkedList<>();
	boolean[] vis= new boolean[g.length];
	int[] dist = new int[g.length];
	q.add(new pair(s,0));
	dist[0] = -1; 
	while(!q.isEmpty()){
		pair p = q.pollFirst();
        int vertex = (int)p.x; 
        int parent = (int)p.y ;

		if(vis[vertex]) continue ;
		vis[vertex] = true ;
		dist[vertex] = dist[parent] +1 ;

		for(int x:g[vertex]){
			q.add(new pair(x,vertex));
		}
    }
   // dbg(dist);
    
}
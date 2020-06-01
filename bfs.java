void bfs(int s){
	LinkedList<pair> q = new LinkedList<>();
	boolean[] vis= new boolean[g.size()];
	int[] dis = new int[g.size()];
	q.add(new pair(s,0));
	dis[0] = -1; 
	while(!q.isEmpty()){
		pair p = q.pollFirst();
		if(vis[p.x]) continue ;
		vis[p.x] = true ;
		dis[p.x] = dis[p.y] +1 ;

		for(int x:g.get(p.x)){
			q.add(new pair(x,p.x));
		}
	}
}

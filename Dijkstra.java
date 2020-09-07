int n,m;
int[][][] g;
int[] from,to,wt;
long[]cost ;
void solve() throws Exception {
    n= ni();m=ni();
    from = new int[m];  
    to   = new int[m]; 
    wt   = new int[m]; 

    for(int i=0;i<m;++i){
        from[i]=ni(); to[i]=ni(); wt[i]=ni();
    }
    g = nwg(n,m,from,to,true);

    dijsktra();
/*input Graph from wikipedia page of Dijsktra's Algorithm
6 9
1 2 7
1 3 9
1 6 14
2 3 10
3 6  2
2 4 15
3 4 11
6 5 9
5 4 6


Out : [0, 0, 7, 9, 20, 20, 11]
*/


    pn(Arrays.toString(cost));
}

void dijsktra(){
    cost=new long[n+1];
    cost[1]=0;
    boolean vis[]=new boolean[n+1];
    PriorityQueue<pair> pq=new PriorityQueue<>();
    pq.add(new pair(0,1));
    while(!pq.isEmpty()){
    // dbg(pq);
        pair p=pq.poll();
        int vertex = (int)p.y;
        long weight= p.x ;
        if(vis[vertex]) continue; 
        vis[vertex]=true;
        cost[vertex]=p.x;
        for(int[] q :g[vertex]){
            if(vis[q[0]]) continue;
            pq.add(new pair(wt[q[1]]+weight,q[0]));
        }
    }
}

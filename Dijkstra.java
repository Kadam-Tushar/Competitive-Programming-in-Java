int n,m;
int[][][] g;
int[] from,to,wt;
long[]cost ;
void solve() throws Exception {
n= ni();m=ni();
from = new int[m];  to =  new int[m]; wt =  new int[m]; 

for(int i=0;i<m;++i){
    from[i]=ni(); to[i]=ni(); wt[i]=ni();
}
g = nwg(n,m,from,to,true);

dijsktra();

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

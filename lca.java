int[][] g ;
int[] lvl;
int[][] par ; 
int dfs_time ;
int[] st,end;
int n,m;

void solve() throws Exception {
 n=ni(); m=n-1;

// everything is 0-based indexing
int[] to = new int[m]; int[] from = new int[m];
for(int i=0;i<m;++i){
    int x=ni()-1,y=ni()-1;
    from[i]=x;to[i]=y;
}

g = ng(n,n-1,from,to,true);
init();
int u =2;
int v =10;

//lca(9,10) = 3 lca(3,11) = 3 , lca(9,11) = 3 ,lca(2,10) = 1

/*
tree : 
12
1 2
1 3
1 4
3 5
3 6
3 7
5 8
5 9
6 10
7 11
7 12
*/

u--; v--;
pn(lca(u,v)+1);




}
void init(){
    par = new int[n][20];
    lvl = new int[n];
    st = new int[n]; end = new int[n];
    dfs_time = 0 ;
// here it is necessary to make par of root as root cause all parents of root at each height is root only
    lca_dfs(0,0);
}
void lca_dfs(int s,int p){
    st[s] = dfs_time ;
    dfs_time++; 

    par[s][0] = p;
    for(int i=1;i<20;++i){
        par[s][i] = par[par[s][i-1]][i-1];
    }

    for(int x: g[s]){
        if(x==p) continue;
        lvl[x] = lvl[s] + 1 ;
        lca_dfs(x,s);
    }

    end[s]  = dfs_time ;
    dfs_time++;
}

boolean ancestor(int u,int v){
    // is u is some ancestor of v
    return (st[v] > st[u] && end[v] < end[u]);
}

int lca(int u,int v){

    if(ancestor(u,v)) return u;
    if(ancestor(v,u)) return v;

    for(int i=19;i>=0;--i){
        if(!ancestor(par[u][i],v)){
            u =  par[u][i];
        }
    }


    return par[u][0];
}


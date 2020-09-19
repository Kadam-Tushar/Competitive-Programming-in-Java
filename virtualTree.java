//lca and graph inits

int[][] g ;
int[] lvl;
int[][] par ; 
int dfs_time ;
int[] st,end;
int n,m;

//virtual tree inits
int[] subTreeCnt;
ArrayList<ArrayList<Integer>> adjVirtual;
TreeSet<Integer> vert ;
HashSet<Integer> imp; 


void solve() throws Exception {

/*
10
1 2
1 3
2 4
2 5
5 6
6 7
5 8
3 9
3 10
2
3
7 8 10
2
7 8

ans : 14,3

Problem Description : for given set of k nodes find for all pair of vertices (unordered) sum of distance between them
Youtube Tutorial : https://www.youtube.com/watch?v=czySm7bUHgY

*/

n=ni(); m=n-1;

// everything is 0-based indexing
int[] to = new int[m]; int[] from = new int[m];
for(int i=0;i<m;++i){
    int x=ni()-1,y=ni()-1;
    from[i]=x;to[i]=y;
}

g = ng(n,n-1,from,to,true);
init();
int q=ni();
adjVirtual = new ArrayList<>();
subTreeCnt =  new int[n];

for(int i=0;i<n;++i) adjVirtual.add(new ArrayList<>());

while(q-->0){
    int k=ni();
    
    vert= new TreeSet<>((Integer a,Integer b)->Integer.compare(st[a],st[b]));
    imp=  new HashSet<>();
    while(k-- > 0){
        int x=ni()-1;
        vert.add(x);
        imp.add(x);
    }
    int root = createVirtualTree();
    pn(adjVirtual);
    pn(solve_dfs(root,-1));

    for(int x: vert) {
        adjVirtual.get(x).clear();
        subTreeCnt[x] = 0;
        
    }
}
}
long solve_dfs(int s,int p){
    int ans = 0;
    subTreeCnt[s] = (imp.contains(s)?1:0);

    for(int x: adjVirtual.get(s)){
        if(x==p) continue;
        ans += solve_dfs(x,s);
        subTreeCnt[s] += subTreeCnt[x];
    }

    // adding edge contribution
    if(p!=-1){
        long w = (lvl[s] - lvl[p]);
        //pn("for edge "+s+" "+p+ " w: "+w);
        ans += w*subTreeCnt[s]*(imp.size()-subTreeCnt[s]);
    }

        return ans ; 
}
int createVirtualTree(){
    // creates virtual tree and returns root of virtual tree

    
    ArrayList<Integer> al =new ArrayList<>(vert);
    for(int i=0;i<al.size()-1;++i){
        vert.add(lca(al.get(i),al.get(i+1)));
    }
    al = new ArrayList<>(vert);
    
    LinkedList<Integer> stk = new LinkedList<>();
  
 
    stk.add(al.get(0));

    
    for(int i=1;i<al.size();++i){
        int u = al.get(i);
       // while(stk.size() >=2 && !ancestor(stk.peekLast(),al.get(i))){
         while(!ancestor(stk.peekLast(),u)){
            // remove vertices till you reach right parent of given al.get(i) vertex
            // while removing also add edges to virtual tree of removed vertices
            // you will surely get atleast one vertex as ancestor because initially we have added global lca in stk
            int last =  stk.pollLast();
            adjVirtual.get(last).add(stk.peekLast());
            adjVirtual.get(stk.peekLast()).add(last); 

        }
        stk.add(u);
    }
    while(stk.size()>=2){
        int last = stk.pollLast();
        int u = stk.peekLast();
        adjVirtual.get(last).add(u);
        adjVirtual.get(u).add(last);

    }
    

    return stk.pollLast();

 
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

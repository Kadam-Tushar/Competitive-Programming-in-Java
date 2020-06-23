import java.util.*;

class Main{
     static ArrayList<ArrayList<Integer>> g;
    static int[] lvl,par;
    static int[][] dp;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
         g=new ArrayList<>();
        int n=sc.nextInt(),m=sc.nextInt();
        for(int i=0;i<n;++i) g.add(new ArrayList<>());
        for(int i=0;i<m;++i){
            int x=sc.nextInt(),y=sc.nextInt();
            g.get(x).add(y);
            g.get(y).add(x);
        }
              
          // This is 0 based indexing
            System.out.println(lca(4,5));
       
        
        
        
    }
void init(){
    lvl=new int[n]; par=new int[n]; dp=new int[n][32];
    for(int i=0;i<n;++i) Arrays.fill(dp[i],-1);
    
     dfs(0,0);
    Arrays.fill(dp[0],0);
    for(int i=0;i<n;++i) dp[i][0]=par[i];

    for(int j=1;j<32;++j) for(int i=1;i<n;++i) dp[i][j]=dp[ dp[i][j-1] ][ j-1 ];
       
}
int lca(int u,int v){
 
    
    if(u==v) return u;
    if(lvl[u]==lvl[v]){
        for(int i=31;i>=0;--i){
        
            if(dp[u][i]!=dp[v][i]){
            
                if(dp[dp[u][i]][0]==dp[dp[v][i]][0])
                {
                    return dp[dp[u][i]][0];
                }
                return lca(dp[u][i],dp[v][i]);
            }
        }   
        return dp[u][0];
    }

    int max=lvl[u]>lvl[v]?u:v;
    int min=lvl[u]<lvl[v]?u:v;
    u=max;v=min;
    int diff=lvl[u]-lvl[v];
    for(int i=0;i<30;++i){
        if(((diff>>i)&1)>=1)
                u=dp[u][i];
    }
    return lca(u,v);
}
void dfs(int s,int p){
    par[s]=p;
    ArrayList<Integer> adj=g.get(s);
    for(int x:adj){
        if(x==p) continue;
        
        lvl[x]=lvl[s]+1;
        dfs(x,s);
    }
}    
}

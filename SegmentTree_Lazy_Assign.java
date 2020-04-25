void solve() throws Exception{

	// Range Update : Lazy propagation 
	// query get element at pos  
	// update : asign l r  with x 
	// 1 indexed everyting 
	int n =5 ;
	int[] arr = {0,5,3,2,8,-7};
	int[] segt = new int[4*n];
	boolean[] marked = new boolean[4*n];
	build(1,1,n,arr,segt);
	update(1,1,n,2,3,66,segt,marked);

	for(int i=1;i<=n;++i){
		pn(get(1,1,n,i,segt,marked));
	}
	update(1,1,n,1,4,22,segt,marked);

	pn("");
	for(int i=1;i<=n;++i){
		pn(get(1,1,n,i,segt,marked));
	}
	
	

	


}
void build(int v,int tl,int tr,int[]arr,int[] segt){

	if(tl==tr){
		
		segt[v]= arr[tl] ;
	}
	else{
		int tm = (tl+tr)/2;
		build(2*v,tl,tm,arr,segt);
		build(2*v+1,tm+1,tr,arr,segt);
		segt[v] = Math.max(segt[2*v] , segt[2*v + 1 ]); 
	}
}
void push(int v,int[] t,boolean[] marked) {
    if (marked[v]) {
        t[v*2] = t[v*2+1] = t[v];
        marked[v*2] = marked[v*2+1] = true;
        marked[v] = false;
    }
}

void update(int v, int tl, int tr, int l, int r, int new_val ,int[] t ,boolean[] marked) {
    if (l > r) 
        return;
    if (l == tl && tr == r) {
        t[v] = new_val;
        marked[v] = true;
    } else {
        push(v,t,marked);
        int tm = (tl + tr) / 2;
        update(v*2, tl, tm, l, Math.min(r, tm), new_val,t,marked);
        update(v*2+1, tm+1, tr, Math.max(l, tm+1), r, new_val,t,marked);
    }
}

int get(int v, int tl, int tr, int pos,int[] t,boolean[] marked) {
    if (tl == tr) {
        return t[v];
    }
    push(v,t,marked);
    int tm = (tl + tr) / 2;
    if (pos <= tm) 
        return get(v*2, tl, tm, pos,t,marked);
    else
        return get(v*2+1, tm+1, tr, pos,t,marked);
}


void solve() throws Exception{

	// Range Update : Lazy propagation 
	// query max element between l,r 
	// update : add l r x 
	// 1 indexed everyting 
	int n =5 ;
	int[] arr = {0,5,3,2,8,-7};
	int[] segt = new int[4*n];
	int[] lazy = new int[4*n];

	//Arrays.fill(segt,Integer.MIN_VALUE);
	build(1,1,n,arr,segt);
	update(1,1,n,1,5,4,segt,lazy);
	update(1,1,n,2,4,-4,segt,lazy);
	update(1,1,n,1,3,4,segt,lazy);

	for(int i=1;i<=n;++i){
		pn(i+" :"+query(1,1,n,i,i,segt,lazy));
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
void push(int v,int[] segt ,int[] lazy){
	segt[2*v] += lazy[v];
	lazy[2*v] += lazy[v];
	segt[2*v + 1] += lazy[v];
	lazy[2*v + 1] += lazy[v];
	lazy[v] = 0; 
}



int query(int v,int tl,int tr ,int l ,int r,int[] segt,int[] lazy){
	if(l>r) 
		return  Integer.MIN_VALUE;
	if(l<=tl && tr<= r) 
		return segt[v];
	push(v,segt,lazy);
	int tm = (tl+tr)/2 ; 
	return Math.max(query(2*v,tl,tm,l,Math.min(tm,r),segt,lazy) , query(2*v+1,tm+1,tr,Math.max(tm+1,l),r,segt,lazy)); 
}
void update(int v,int tl ,int tr,int l,int r,int addend,int[] segt,int[] lazy){
	if (l > r) 
	return;
	if (l == tl && tr == r) {
		segt[v] += addend;
		lazy[v] += addend;
	}else{
		push(v,segt,lazy);
		int tm = (tl + tr) / 2;
		update(v*2, tl, tm, l, Math.min(r, tm), addend,segt,lazy);
		update(v*2+1, tm+1, tr, Math.max(l, tm+1), r, addend,segt,lazy);
		segt[v] = Math.max(segt[v*2], segt[v*2+1]);
	}
}


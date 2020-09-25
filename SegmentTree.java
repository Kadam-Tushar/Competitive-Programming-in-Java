int[] arr,segt ;

void solve() throws Exception{
   
    	// finding first el greater than x
	// 1 indexed everyting 
	int n =5 ;
	int[] arr = {0,1,3,-2,8,-7};
	int[] segt = new int[4*n];
	build(1,1,n,arr,segt);
	
	pn(sum(1,1,n,3,5,segt));
    
    
	// pn(Arrays.toString(segt));
	// pn(sum(1,1,n,2,5));
	


}

// Query Sum 
void build(int v,int tl,int tr,int[]arr,int[] segt){
	if(tl==tr){
		segt[v]= arr[tl] ;
	}
	else{
		int tm = (tl+tr)/2;
		build(2*v,tl,tm,arr,segt);
		build(2*v+1,tm+1,tr,arr,segt);
		segt[v] = segt[2*v] + segt[2*v + 1 ]; 
	}
}
int sum(int v,int tl,int tr ,int l ,int r,int[] segt){
	if(l>r) return  0;
	if(l==tl && r==tr) return segt[v];
	int tm = (tl+tr)/2 ; 
	return sum(2*v,tl,tm,l,Math.min(tm,r),segt) + sum(2*v+1,tm+1,tr,Math.max(tm+1,l),r,segt) ; 
}
void update(int v,int tl ,int tr,int pos,int newval,int[] segt){
	int tm = (tl+tr)/2;
	if(tl == tr){
		segt[v] = newval ; 
	}	
	else{
		if(pos<= tm ){
			update(2*v, tl,tm,pos,newval,segt) ; 
		}
		else{
			update(2*v + 1, tm+1,tr,pos,newval,segt) ; 
		}
		segt[v] = segt[2*v] + segt[2*v+1];
	}
}







// Query Max  Segment Tree 
void build(int v,int tl,int tr,int[]arr,int[] segt){
	if(tl==tr){
		segt[v]= arr[tl] ;
	}
	else{
		int tm = (tl+tr)/2;
		build(2*v,tl,tm,arr,segt);
		build(2*v+1,tm+1,tr,arr,segt);
		segt[v] = Math.max(segt[2*v], segt[2*v + 1 ]); 
	}
}
int query_max(int v,int tl,int tr ,int l ,int r,int[] segt){
	if(l>r) return  0;
	if(l==tl && r==tr) return segt[v];
	int tm = (tl+tr)/2 ; 
	return Math.max(query_max(2*v,tl,tm,l,Math.min(tm,r),segt),query_max(2*v+1,tm+1,tr,Math.max(tm+1,l),r,segt)) ; 
}
void update(int v,int tl ,int tr,int pos,int newval,int[] segt){
	int tm = (tl+tr)/2;
	if(tl == tr){
        segt[v] = newval ; 
        segarr[pos] = newval;
	}	
	else{
		if(pos<= tm ){
			update(2*v, tl,tm,pos,newval,segt) ; 
		}
		else{
			update(2*v + 1, tm+1,tr,pos,newval,segt) ; 
		}
		segt[v] = Math.max(segt[2*v] , segt[2*v+1]);
	}
}
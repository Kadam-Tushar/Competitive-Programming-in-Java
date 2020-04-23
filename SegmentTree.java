int[] arr,segt ;

void solve() throws Exception{
    //1 indexed array 
    // 1 indexed seg-tree 

    int n=5;
	arr= new int[]{0,1,3,-2,8,-7} ; 
	segt = new int[4*n]; 

    build(1,1,n);
    
    
	// pn(Arrays.toString(segt));
	// pn(sum(1,1,n,2,5));
	


}
void build(int v,int tl,int tr){
	if(tl==tr){
		segt[v]= arr[tl] ;
	}
	else{
		int tm = (tl+tr)/2;
		build(2*v,tl,tm);
		build(2*v+1,tm+1,tr);
		segt[v] = segt[2*v] + segt[2*v + 1 ]; 
	}
}
int sum(int v,int tl,int tr ,int l ,int r){
	if(l>r) return  0;
	if(l==tl && r==tr) return segt[v];
	int tm = (tl+tr)/2 ; 
	return sum(2*v,tl,tm,l,Math.min(tm,r)) + sum(2*v+1,tm+1,tr,Math.max(tm+1,l),r) ; 
}
void update(int v,int tl ,int tr,int pos,int newval){
	int tm = (tl+tr)/2;
	if(tl == tr){
		segt[v] = newval ; 
	}	
	else{
		if(pos<= tm ){
			update(2*v, tl,tm,pos,newval) ; 
		}
		else{
			update(2*v + 1, tm+1,tr,pos,newval) ; 
		}
		segt[v] = segt[2*v] + segt[2*v+1];
	}
}
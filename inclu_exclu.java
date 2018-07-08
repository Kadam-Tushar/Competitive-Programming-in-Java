long inclu_exclu(ArrayList<Integer> v,long num){
 long N=v.size(),pow=(1<<N),sum=0;
 	for(int i=1;i<pow;++i){
 		long ct=1;
		for(int k=0;k<N;k++) if((i&(1<<k))>=1) ct=lcm(ct,v.get(k));
 
 		if((Integer.bitCount(i))%2==1) sum+=(num/ct); 
		else sum-=(num/ct); 
	}
	return sum;
}
long lcm(long x,long y){
		long g=gcd(x,y);
		long ans=(x*y)/g;
		return ans;
}
long gcd(long x,long y){
	  if(y==0) return x;
	  return gcd(y,x%y);
}

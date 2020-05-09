long mod  = 998244353L ;
int N = (int)2e5+5;
long[] fact = new long[N+1];
long[] ifact = new long[N+1];


void init(){

	fact[0] =1 ;
	ifact[0] = 1 ;
	for(int i=1;i<=N;++i){
		fact[i] = (fact[i-1] * i )%mod ; 
		ifact[i] = pow(fact[i],mod-2) ; 
	}

}
long nCr (long n,long r){
	long ans =1 ;
	
	if(r>n || r< 0) return 0L ;

	ans = (ans*fact[(int)n])%mod ;
	ans= (ans*ifact[(int)(n-r)])%mod ;
	ans= (ans*ifact[(int)r])%mod ;
	return ans ; 
	
}
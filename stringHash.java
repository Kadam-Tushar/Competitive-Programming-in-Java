int p = 31;
int m = (int)1e9 + 9;
long[] prefix_hash ;
long[] p_pow = new long[(int)1e5 + 5];
int n;

// This 1 based indexing for prefix_hash


void init(){

    p_pow[0] = 1 ;
    for(int i=1;i<p_pow.length;++i){
        p_pow[i] = (p*p_pow[i-1])%m;
    }
    
}
long substring_hash(int i,int j){
    return ( ((prefix_hash[j] - prefix_hash[i-1] + m )%m)*p_pow[n-i] )%m;
}

long  compute_hash_prefix(char[] s) {
    
    int len= s.length;
    
    long hash_value = 0;
    // long p_pow = 1;
    for (int i=0;i<len;++i) {
        char c= s[i];
        hash_value = (hash_value + (c - 'a' + 1) * p_pow[i]) % m;
        prefix_hash[i+1] = hash_value; 
        //p_pow = (p_pow * p) % m;
    }
    return hash_value;
}
long  compute_hash(char[] s) {
   
    int p = 31;
    int m = (int)1e9 + 9;
    long hash_value = 0;
    int z= 0;
    for (char c : s) {
        hash_value = (hash_value + (c - 'a' + 1) * p_pow[z]) % m;
        z++;
        //p_pow = (p_pow * p) % m;
    }

    return hash_value;
}
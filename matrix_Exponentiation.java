/*
 - use matrix expo when its O(n) iterative dp and O(1) space to speed up from O(n) to O(log)
 - find recurence of problem 
 - if recurrence depends on k states of problem then create k*k matrix 
 - use binary exponentiation for finding A^n in  Ax = B matrix equation 
*/


long[][] mat_expo(long[][] mat, long p){
    
    int k = mat.length;
    long[][] res = new long[k][k];
    for(int i=0;i<k;++i) res[i][i]=1;

    while(p>0){
        if(p%2==1){
            res = mat_multiply(mat,res);
        }

        mat = mat_multiply(mat,mat);
        p/=2;
    }
    return res;
}
long[][] mat_multiply(long[][] A,long[][] B){
    int n= A.length;

    long[][] res = new long[n][n];
    for(int i=0;i<n;++i){
        for(int j=0;j<n;++j){
            for(int k=0;k<n;++k){

            //     long base = (1L<<16); 
            //     long[] first = {A[i][k]/(base),A[i][k]%base};
            //    res[i][j] = ((res[i][j] +((B[k][j]*first[0])%mod*base)%mod)%mod + (B[k][j]*first[1])%mod)%mod ;
            res[i][j]+=(A[i][k]*B[k][j])%mod;  
            res[i][j]%= mod;
            
            }
        }
    }
    return res ;
}

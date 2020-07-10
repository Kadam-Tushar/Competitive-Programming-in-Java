// nlogn way of finding len of LIS and printing it  using Binary seach and dp 
// ref : https://cp-algorithms.com/sequences/longest_increasing_subsequence.html

void solve() throws Exception {
    int[] arr = {0,0, 1, 2, 3,4};
    pn(LIS_len(arr));
    
}
int LIS_len(int[] arr){
    // array should be 1 indexed 
    int n= arr.length -1 ;
    int[] lcs = new int[n+1];
    Arrays.fill(lcs,inf);
    lcs[0]= -inf ;
    
    // for maintaining sequence 
    int[] position = new int[n+1];
    int[] prev = new int[n+1];
        for(int i=1;i<=n;++i){
            // always gurranted that bs() wont return -1 cause atmax lis len can be n 
            int j = bs(arr[i],lcs) ;
            // position[j] : index of element from arr who is  at jth element in j len LIS 
            position[j] = i ; 
            // prev[i]: index of element from arr who is at (j-1)th postion in lis 
            prev[i] = position[j -1] ;
            
            lcs[j] = arr[i];
        
        }
    // finding where is our first inf cause before that last element of LIS is present 1,2,5,inf,inf 
        int len = bs(inf,lcs); 
        if(len == -1 ) len  = n ; // no inf present hence LIS_len = n
        else len--;     
        
        int ind  =  position[len] ;
        while(ind != prev[ind]){
            p(arr[ind]+" ");
            ind = prev[ind];
        }
        pn("");
        return len ;
    }

// binary search 
int bs(int key,int[] lcs){
    int n=  lcs.length -1 ;
    int start = 1 , end= n;
    int ind = -1 ;
    while(start<=end){
        int mid=  start + (end-start)/2 ;
        if(lcs[mid]>= key){
            ind = mid ;
            end = mid - 1;
        }
        else{
            start = mid + 1 ;
        }
    }
    return ind ;
}

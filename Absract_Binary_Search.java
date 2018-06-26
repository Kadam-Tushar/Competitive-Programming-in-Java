int[] arr={-2,5,6,7,9,100};
void solve()
{ 
    Arrays.sort(arr);
    pn("ind "+bsLF(7,0,5));
    
}
boolean check(int key){
    return arr[key]>9;
}
int bsFT(int key,int s,int e){  //First True FFFTTT
    int mid=(s+e)/2;
    while(s<e){
        mid=(s+e)/2;
        if(check(mid)) e=mid;
        else s=mid+1;
    }
    if(check(s))  return s;
    else return -1; //complain
    
}
int bsLF(int key,int s,int e){ //Last False FFFTTT
    int mid=0;
    while(s<e){
        mid=(s+e+1)/2;  //Round up for the Case F T T T T
        if(check(mid)) e=mid-1;
        else s=mid;
    }
    if(check(s))  return -1; //I want False 
    else return s;
    
}

long[] bit;
void rangeUpdate(int l,int r,long del){
    //you can not use rangeUpdate and RangeQuery at same time 
    //because both have different notions for bit[] 
    // 1 indexed 
    int n= 5 ;
    bit = new long[n+5];

    //add elements in bit by update(arr[i],1);

    update(l,del);
    update(r+1,-del);
}
void update(int pos,long del){
    while(pos<bit.length){
        bit[pos] += del;
        pos += Long.lowestOneBit(pos);
    }
}
long sum(int pos){
    long sum=0;
    while(pos>0){
        sum = (sum + bit[pos]);
        pos -= Long.lowestOneBit(pos);
    }
    return sum;
}
long rangeSum(int l ,int r){
    return sum(r)-sum(l-1);
}

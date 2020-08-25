 /* 1 indexed 
to insert elements use update(arr[i],1) if want to find kth order;
insert update(i,arr[i]) if you want rangeQuery and point update
 */


long[] bit=new long[8+2];

//get method should be used when kth order statistic is used : on BIT
int get(int pos){
    int start = 1,end = (int)1e6+5;
			int ans = -1;
			while(start<=end){
				int m = start + (end-start)/2 ;
				int countOfElements = sum(m);
				if(countOfElements>=K){
					ans = m ;
					end = m-1;
				}
				else{
					start = m+1;
				}
			}
}

void rangeUpdate(int l,int r,long del){
    //you can not use rangeUpdate and RangeQuery at same time 
    //because both have different notions for bit[] 
   
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

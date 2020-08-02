

int[] arr ={0,100,50,25,12,6};
int[] index ;
int[][] segt ;


void solve() throws Exception {

/* 
segt[][] : each node stores sorted subsegment of elements present in segment
segt[x] : Nodes of seg tree 1 indexed
query(): for finding kth smallest in in subarray [l:r] (0th indexed)

Steps to use this :
arr : array for which you want kth smallest
index: 0 based indices of sorted arr 

Maintaining index array cause it helps to build seg tree sorted segment
these segments helps to find out just one thing:
In child nodes (Lets say left child node): how many elements are present from [l:r]
We can get this by binary searching over sorted subsegments of indices

query : it just finds elements of interest(kth element) by removing k-1 elements among [l:r] on by one

l:r should be 0 indexed 

no updates are allowed in data structure

*/
int n=5 ;

segt = new int[4*n][];

build(1,1,n);

pn(Arrays.toString(segt[1]));
pn(Arrays.toString(segt[2]));
pn(Arrays.toString(segt[3]));
pn(Arrays.toString(segt[4]));
pn(Arrays.toString(segt[5]));
pn(Arrays.toString(segt[6]));
pn(Arrays.toString(segt[7]));
pn(Arrays.toString(segt[8]));

//int[] ind ={0,4,3,2,1,0};
//int[] arr ={0,100,50,25,12,6}

pn(query(1,1,n,0,4,3));

// for(int i=0;i<m;++i){
//     int x =ni(),y=ni();
//     pn(ans.get(x-1).get(y-1).y);
// }



}
void build(int v,int tl,int tr){
	if(tl==tr){
        int[] temp  = {arr[tl]};
		segt[v]= temp ;
	}
	else{
		int tm = (tl+tr)/2;
		build(2*v,tl,tm);
        build(2*v+1,tm+1,tr);
        int[] l = segt[2*v]; int[] r = segt[2*v+1] ;  
        int n= l.length , m=r.length;

        int[] temp = new int[n+m];
        
        int i =0,j=0,k=0;
        while(i<n && j < m){
            if(l[i]<r[j]){
                temp[k] = l[i];
                k++;
                i++;
            }
            else{
                temp[k] = r[j];
                k++;
                j++;
            }
        }
        while(i<n){
            temp[k] = l[i];
            k++; i++;
        }
        while(j<m){
            temp[k] = r[j];
            k++; j++;
        }


		segt[v] = temp; 
	}
}
int query(int v,int tl,int tr ,int l ,int r,int kth){
//pn("Searching in "+Arrays.toString(segt[2*v])+" for kth ="+kth);
    if(tl==tr){
       // pn("got "+Arrays.toString(segt[v]));
        return segt[v][0];
    }
    int i1 = Arrays.binarySearch(segt[2*v],l);
    int i2 = Arrays.binarySearch(segt[2*v],r);
    //pn("i1 i2 "+i1+" "+i2);

    
    int tm = (tl+tr)/2 ;
    int el = 0;
    /*
    Both postive : r-l+1
    Both negative : r-l
    if l negative : r-l+1
        r negative : r-l

    */

    if(i1>=0 && i2>=0){
        el  =i2 -i1 + 1;
    }
    else{
        if(i1<0 && i2<0){
            el = Math.abs(i2)- Math.abs(i1);
        }
        else{
            if(i1<0){
                i1= -i1-1;
                el = i2 - i1 +1; 
            }
            else{
                i2 = -i2-1;
                el = i2 -i1 ;
            }
            //el = i2-i1;
        }
    }
   
   // pn("el are "+el);
    if(kth<el){
        return query(2*v,tl,tm,l,r,kth);
    }
    else return query(2*v+1,tm+1,tr,l,r,kth-el);


}

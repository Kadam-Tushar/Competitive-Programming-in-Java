/* 
- Finding a pair of points with minimum distance from given N points in 2 D space in O(nlogn)
- Using line-sweep algorithm : https://www.topcoder.com/community/competitive-programming/tutorials/line-sweep-algorithms/ 
- Use pair class with 'double' as type

- Short explanation : 
Sort all points according to x coordinates (We will process them in this order (Sweep line ))
initialize minDist with first two points and add these two points as processed points
add new point in processed set : remove all points from processed set with x-mindist 
simultaneously maintain this same set (proceessed) with different order i.e sorted by y-cordinate 
After removing points far from current point by distance minDist , find only the points vertical range from  y+minDist and y-minDist
These small O(1) set of points are our area of interest , find trivally all possible minimum distances and set it to minDist
Try adding next point ... So on 
*/

void solve(){
int n=ni();
ArrayList<pair> al= new ArrayList<>();

HashMap<pair,Integer> index = new  HashMap<>(); // for storing indices of points
for(int i=0;i<n;++i){
    double x=nd(),y=nd();
    pair p = new pair(x,y);
    
    al.add(p);
    index.put(p,i);

}

Collections.sort(al);

// x sorted and y sorted sets of same elements (Processed points )
TreeSet<pair> xsorted= new TreeSet<>();
TreeSet<pair> ysorted= new TreeSet<>((pair p1,pair p2)->{
    if(p1.y != p2.y) return Double.compare(p1.y,p2.y);
    return Double.compare(p1.x,p2.x);
});

pair f = al.get(0);
pair s = al.get(1);

int firstIndex = 0,secondIndex = 1 ;
double minDist= dist(f,s);
xsorted.add(f); ysorted.add(f) ;
xsorted.add(s); ysorted.add(s) ;


for(int i=2;i<al.size();++i){
    pair p = al.get(i);
    xsorted.add(p);
    ysorted.add(p);

    
    TreeSet<pair> toRemove = new TreeSet<>((TreeSet<pair>)xsorted.subSet(new pair(-1e14,-1e14), new pair(p.x-minDist+0.01,1e14)));
   // removing points which are not required 
    for(pair pp : toRemove) {
        xsorted.remove(pp);
        ysorted.remove(pp);
    }
    TreeSet<pair> worthy = new TreeSet<>((TreeSet<pair>)ysorted.subSet(new pair(-1e14,p.y-minDist-0.01),new pair(1e14,p.y+minDist+0.01)));
    ArrayList<pair>  list = new ArrayList<>(worthy);

    //finding minDist by bruteforce for small number of elements
    
    for(int ii=0;ii<list.size();++ii){
        for(int j=ii+1;j<list.size();++j){
            pair p1= list.get(ii);
            pair p2=  list.get(j);
            double newDist=  dist(p1,p2);
            if(minDist> newDist){
                minDist = newDist;
                int i1 = index.get(p1);
                int i2 = index.get(p2);
                firstIndex = Math.min(i1,i2);
                secondIndex = Math.max(i1,i2);
            }
            
        }
    }
    
}

System.out.printf("%d %d %.6f\n",first,second,round(minDist,6));

}








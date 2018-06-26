import java.util.*;
class 01knap{
public static void main(String[] args) {
	 int val[] = new int[]{60, 100, 120};
    int wt[] = new int[]{10, 20, 30};
    int  W = 50;
    int n=val.length;
    int K[][]=new int[n+1][W+1];

    for(int i=0;i<=n;++i){
    	for(int w=0;w<=W;++w)
    	{
    		if(i==0||w==0) K[i][w]=0;
    		else 
    			if(w-wt[i]>=0){
    				K[i][w]=Math.min(val[i-1]+K[i-1][w-wt[i]],K[i-1][w]);
    			}
    			else K[i][w]=K[i-1][w];
    	}

    }
    System.out.println(K[n][W]);






}
}
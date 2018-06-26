import java.util.*;
class fractional_knap{
	public static void main(String[] args) {
		int[] p={60,100,120};
		int[] w={10,20,30};
		double size=50.0;
		ArrayList<pair> al=new ArrayList<>();
		for(int i=0;i<p.length;++i) al.add(new pair((double)p[i]/w[i],i));
	
		Collections.sort(al,Collections.reverseOrder());
	pn(al);
		double wt=0.0;
		int i=0;
		double profit=0;
		while(wt<size&&i<al.size())
		{
			pair pp=al.get(i++);
			double currWt=Math.min(size-wt,w[pp.y]);
			wt+=currWt;
			profit+=currWt*pp.x;

		}
		pn("Total profit is "+profit);


	}
static void pn(Object o)
{
	System.out.println(o);
}

}
class pair implements Comparable<pair>{
	double x;
	int y;
	pair(double x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public int compareTo(pair p)
	{
		if(this.x-p.x>0) return 1;
		else if(this.x-p.x==0) return 0;
		else return -1;
	}
	public String toString()
	{
		return x+" "+y;
	}

}
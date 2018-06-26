import java.util.*;
class job_seq{

public static void main(String[] args) {
	int p[]={100,19,27,25,15};
	int deadLine[]={2,1,2,1,3};
	int slots=3;

	ArrayList<pp> al=new ArrayList<>();
	for(int i=0;i<p.length;++i) al.add(new pp(p[i],deadLine[i],i));
		Collections.sort(al,Collections.reverseOrder());
		//pn(al);
		
		boolean[] ans=new boolean[slots];
		ArrayList<Integer> ansId=new ArrayList<>();
		int profit=0;
	for(int i=0;i<al.size();++i){

		pp job=al.get(i);
		for(int j=Math.min(ans.length-1,job.y-1);j>=0;--j)
		{
			if(!ans[j]){
				ans[j]=true;
				profit+=job.x;
				ansId.add(job.id);
				break;
			}
		}

	}
	pn("profit "+profit);
	pn("Job with ids "+ansId);

	
	
	
	}
	static void pn(Object o)
	{
		System.out.println(o);
	}


}
class pp implements Comparable<pp>{
int x,y,id;
pp(int x,int y,int id)
{
	this.x=x;
	this.y=y;
	this.id=id;
}
public int compareTo(pp p)
{
	return (this.x-p.x);
}
public String toString()
{
	return x+" "+y;
}

}
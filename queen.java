import java.util.*;
class queen{
	static ArrayList<pair> al=new ArrayList<>();
	static int n=4;
	public static void main(String[] args) {
		nqueen(1);





	}
	static void nqueen(int level)
	{
		if(level==n+1) {
		
				System.out.println(al);
			return ;
		}

		for(int j=1;j<=4;++j)
		{
			if(isValid(level,j)){
			al.add(new pair(level,j));
			nqueen(level+1);
			al.remove(al.size()-1); 
			}
		}	


	}
	static boolean isValid(int i,int j){
		for(pair p :al)
		{
			if(p.y==j||Math.abs(p.y-j)==Math.abs(p.x-i)) return false;
		}
		return true;
	}

}
class pair{
	int x,y;
	pair(int x,int y){
		this.x=x;
		this.y=y;
	}
	public String toString()
	{
		return x+" "+y;
	}
}
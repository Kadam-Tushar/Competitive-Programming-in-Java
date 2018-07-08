void select(ArrayList<Integer> ans,int start,int remain){
	if(remain==0){
	//do here whaterver you want
	return ;
	}

for(int i=start;i<=al.size()-remain;++i){
	ans.add(al.get(i));
	select(ans,i+1,remain-1);
	ans.remove(ans.size()-1);
}

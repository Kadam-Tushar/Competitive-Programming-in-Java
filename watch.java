void watch(Object ... a) throws Exception{
    int i=1;
    pn("watch starts :");
    for(Object o : a ) {
        //print(o);
        boolean notfound = true;
        if(o.getClass().isArray()){
            
            String type = o.getClass().getName().toString();
            print("type is "+type);
            switch (type) {
                case "[I":{
                    int[] test = (int[])o ;
                    pn(i+" "+Arrays.toString(test));
                    break;
                }
                case "[[I":{
                    int[][] obj = (int[][])o;
                    
                    pn(i+" "+Arrays.deepToString(obj));
                    break;
                }
                case "[J" : {
                    
                    long[] obj  = (long[])o ;
                    pn(i+" "+Arrays.toString(obj));
                    break;
                }
                case "[[J": {
                    
                    long[][] obj = (long[][])o;
                    pn(i+" "+Arrays.deepToString(obj));
                    break;
                }
                case "[D" :{
                    
                    double[] obj= (double[])o;
                    pn(i+" "+Arrays.toString(obj));
                    break;
                }
                case "[[D" :{
                    
                    double[][] obj = (double[][])o;
                    pn(i+" "+Arrays.deepToString(obj));
                    break;
                }
                case "[Ljava.lang.String": {
                    
                    String[] obj = (String[])o ;
                    pn(i+" "+Arrays.toString(obj));
                    break;
                }
                case "[[Ljava.lang.String": {
                    
                    String[][] obj = (String[][])o ;
                    pn(i+" "+Arrays.deepToString(obj));
                    break ; 
                }
                case "[C" :{
                    char[] obj = (char[])o ;
                    pn(i+" "+Arrays.toString(obj));
                    break;
                }
                case "[[C" :{
                    
                    char[][] obj = (char[][])o;
                    pn(i+" "+Arrays.deepToString(obj));
                    break;
                }

                    
            
                default:{
                    pn(i+" type not identified");
                    break;
                }
            }
            notfound = false;
            
        }
        if(o.getClass() == ArrayList.class){
            pn(i+" al: "+o);
            notfound = false;
        }
        if(o.getClass() == HashSet.class){
            pn(i+" hs: "+o);
            notfound = false;
        }
        if(o.getClass() == TreeSet.class){
            pn(i+" ts: "+o);
            notfound = false;
        }
        if(o.getClass() == TreeMap.class){
            pn(i+" tm: "+o);
            notfound = false;
        }
        if(o.getClass() == HashMap.class){
            pn(i+" hm: "+o);
            notfound = false;
        }
        if(o.getClass() == LinkedList.class){
            pn(i+" ll: "+o);
            notfound = false;
        }
        if(o.getClass() == PriorityQueue.class){
            pn(i+" pq : "+o);
            notfound = false;
        }
        if(o.getClass() == pair.class){
            pn(i+" pq : "+o);
            notfound = false;
        }
        
        if(notfound){
            pn(i+" unknown: "+o);
        }
        i++;
    }
    pn("watch ends ");
}

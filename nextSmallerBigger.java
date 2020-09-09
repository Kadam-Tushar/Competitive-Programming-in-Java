void solve{


    int n= 8;
    int[] arr ={1,1,2,4,3,2,4,5};
    int[] nheL = new int[n];
    int[] nheR = new int[n];
    int[] nseR = new int[n];
    int[] nseL = new int[n];
    
    LinkedList<Integer> ll = new LinkedList<>();
    
    
    /*
    next higher of arr[i] is first element after arr[i] which >= arr[i] 
    you can make it strictly > arr[i] by toggling '=' sign
    */
    for(int i=0;i<n;++i){
        if( ll.isEmpty() || arr[ll.peekLast()] > arr[i]){
                ll.add(i);
        }
        else{
            while(!ll.isEmpty() && arr[i]>=arr[ll.peekLast()])
                nheR[ll.pollLast()] = i ;
            ll.add(i);
        }
    }
    
    while(!ll.isEmpty()){
        nheR[ll.pollLast()] = -1 ;
    }
    
    
    for(int i=n-1;i>=0;--i){
        if( ll.isEmpty() || arr[ll.peekLast()] > arr[i]){
                ll.add(i);
        }
        else{
            while(!ll.isEmpty() && arr[i]>=arr[ll.peekLast()])
                nheL[ll.pollLast()] = i ;
            ll.add(i);
        }
    }
    
    while(!ll.isEmpty()){
        nheL[ll.pollLast()] = -1 ;
    }
    
    
    for(int i=0;i<n ; ++i){
        if( ll.isEmpty() || arr[ll.peekLast()] < arr[i]){
            ll.add(i);
        }
        else{
            while(!ll.isEmpty() && arr[i]<=arr[ll.peekLast()])
                nseR[ll.pollLast()] = i ;
            ll.add(i);
        }
    }
    while(!ll.isEmpty()){
        nseR[ll.pollLast()] = -1 ;
    }
    
    
    
    
    
    
    for(int i=n-1;i>=0 ; --i){
        if( ll.isEmpty() || arr[ll.peekLast()] < arr[i]){
                ll.add(i);
        }
        else{
            while(!ll.isEmpty() && arr[i]<=arr[ll.peekLast()])
                nseL[ll.pollLast()] = i ;
            ll.add(i);
        }
    }
    
    while(!ll.isEmpty()){
        nseL[ll.pollLast()] = -1 ;
    }
    
    
    pn(Arrays.toString(arr));
    pn("next smaller R "+Arrays.toString(nseR));
    pn("next smaller L "+Arrays.toString(nseL));
    pn("next higher R "+Arrays.toString(nheR));
    pn("next higher L "+Arrays.toString(nheL));
    
    
}

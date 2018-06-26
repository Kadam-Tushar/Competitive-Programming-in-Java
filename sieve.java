ArrayList<Integer> sieve(int n){
    ArrayList<Integer> al=new ArrayList<>();
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;
    for(int p = 2; p*p <=n; p++)
      {
         if(prime[p])
          {
              for(int i = p*2; i <= n; i += p)
               prime[i] = false;
          }
       }
   for(int i = 2; i <= n; i++)
   {
      if(prime[i] == true) 
          al.add(i);
   }
     return al;
        
   }

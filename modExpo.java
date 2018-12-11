int power(int x, int y, int p) 
{ 
   int res = 1;      
  x = x % p;  
    while (y > 0) 
    { 
        if((y & 1)==1) 
            res = (res * x) % p; 
        y = y >> 1;  
        x = (x * x) % p;  
    } 
    return res; 
} 

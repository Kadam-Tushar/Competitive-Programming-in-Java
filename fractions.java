int fracCompare(pair p1,pair p2){
    long f = p1.x*p2.y, s = p2.x*p1.y ;
    if(f > s) return 1 ;
    else if(f==s) return 0;
    return -1; 
}

void reducedFrac(pair p){
    long g = gcd(p.x,p.y);
    p.x /=g; p.y /=g; 
}




import java.util.*;
class stupid{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int ans = 0;
        int[] arr= new int[n];
        for(int i=0;i<n;++i) arr[i]=sc.nextInt();

        for(int i=0;i<n;++i){
            for(int j=i;j<n;++j){
                
                int xor =0 ,sum =0;
                for(int k=i;k<=j;++k){
                    xor ^=arr[k];
                    sum += arr[k];
                }

                // pn("for i,j "+i+" "+j);
                // pn(xor+" "+sum);
                // pn("");
                if(xor == sum) ans++;

            }
        }
        pn(ans);
    }
    static void pn(Object o){
        System.out.println(o);
    }
    static void p(Object o){
        System.out.print(o);
    }
}
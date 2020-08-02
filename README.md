[![Open Source Helpers](https://www.codetriage.com/kadam-tushar/data-structures-and-algorithms-in-java/badges/users.svg)](https://www.codetriage.com/kadam-tushar/data-structures-and-algorithms-in-java)



# Data-Structures-and-Algorithms-in-Java
This repository contains all the important data structures and algorithms that I use in Competitive Programming. 

I had not followed Object-oriented paradigm for implementing this DS and Algorithms because these codes are primarily used by me in 

Competitive programming where instead of code compatibility implementation time matters most. That's why I had tried to decrease code length in these implementations.

Feel free to use these codes and if you find anything wrong then don't forget to report me. 

Links:

<details>
<summary> Data Structures </summary>

 - [Disjoint Set Data Structure using Arrays](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/DisjointSet.java)

 - [ Centroid Decomposition ](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/centroid.java)
  


- [LCA - Lowest Common Ancestor](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/lca.java)

- [ BIT/ Fenwick Tree ](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/BIT.java)



- [Segment Tree : Basic](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/SegmentTree.java)

- [Segment Tree : Range Updates (add)](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/SegmentTree_Lazy_add.java)

- [ Segment Tree : Range Updates (assign)](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/SegmentTree_Lazy_Assign.java)

- [ Segment Tree : Kth Order statistic on subarray (No updates allowed)](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/SegmentTree_KthOrder.java)


  
</details>

<details>

<summary> Algorithms </summary>

- [ Binary Search](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/Absract_Binary_Search.java)

- [BFS](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/bfs.java)

- [DFS](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/dfs.java)

- [Kruskal's MST Algorithm using Disjoint Set Union](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/kruskal_disjoint.java)


- [Dijkstra using Priority Queue](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/Dijkstra.java)

- [ Floyd Warshalls  (with all shortest paths )](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/all_pair.java)


- [LIS : Longest Incresing Subsequence O(nlogn) ](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/LIS.java)

- [PIE : Principle of Inclusion Exclusion](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/inclu_exclu.java)







 
  
</details>


<details>
<summary> Strings </summary>

- [String hashing - Rolling Polynomial Hash](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/stringHash.java)
</details>

<details>
<summary> Maths related </summary>

 - [Sieve for finding prime numbers  n<=10^7](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/sieve.java)

- [ Handling Fractions](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/fractions.java)

- [Geometry -Segments Intersections and Polygon Area from Co-ordinates](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/Geomtry.java)

- [nCr with mod](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/nCr.java)

- [Next Permutation for n! permutations (C++ equivalent)](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/next_permut.java)

- [Selection Of r Things from n things ](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/select_r_things.java)


- [Power function -Modular ](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/power.java)



</details>

<br>

**Miscellaneous**

- [Debug-Watch function](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/watch.java)

- [Java template for Competitive Programming](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/Main.java)











 
## Fast IO for JAVA : [Template](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/Main.java).

 - Java is a little bit slower than C++/C and the main factor behind this is slow console input/output.

- Java's Scanner, as well as BufferedReader class, is too slow. So the best option is creating your own input-output classes.

- I had never faced Time Limit Exceed Error (i.e  Code  takes too much time because of an inefficient/wrong algorithm ) after I started using this template. 


- To use this template you have to write all your code in solve() method.

- From main() method we are calling solve() method which is supposed to solve the asked problem.


## Documentation of methods from this template :

**INPUT METHODS**

- ```int x=ni()``` -to input single number  Short form of nextInt()

- ```long x=nl() ```  -to input long number nextLong()

- ```double x=nd()``` - to input double values nextDouble()

String x=**ns()**- to input string nextString()

char x=**nc()**- to input character  nextChar()

int[] arr=**na(int n)**  -to input array of size n i.e parameter is integer with  value n. It will allocate a new array and return its reference. nextArray()

char [][] matrix =**nm(int n,int m)** this is method is used tor inputing character matrix nextMatrix()

**OUTPUT METHODS**

pn(Object o)  - **pn() method is used to print anthing on consolve 
                                 the parameter is Object is you can pass anthing.
                           It is similar as System.out.println()**
                           
p(Object o) **Similar as System.out.print()**

**UTILITY FUNCTIONS**

int x=**max( int[] arr)**  -it will find max element from array

int y=**min(int [] arr)** it will find min element from array

int a=**nCr(int n,int rc)** for Combinatorics 

int g=**gcd(x,y)** for finding gcd

**I had to implement pair class because there is no inbuilt pair class.
You can use the pair in Hashed Collections as well as Tree Collections because hashCode() and compareTo() methods are implemented in this pair class**



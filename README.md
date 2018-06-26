# Data-Structures-and-Algorithms-in-Java
This repository contains all the important data structures and algorithms that I use in Competitive Programming. 

I had not followed Object-oriented paradigm for implementing this DS and Algorithms because these codes are primarily used by me in 

Competitive programming where instead of code compatibility implementation time matters most. That's why I had tried to decrease code length in these implementations.

Feel free to use these codes and if you find anything wrong then don't forget to report me. 
 
## Fast IO for JAVA : [Link to Fast IO](https://github.com/Kadam-Tushar/Data-Structures-and-Algorithms-in-Java/blob/master/Main.java).

Java is a little bit slower than C++/C and the main factor behind this is slow console input/output.

Java's Scanner, as well as BufferedReader class, is too slow. So the best option is creating your own input-output classes.

I had never got Time Limit Exceed Error (i.e Your code is taking too much time because of an inefficient/wrong algorithm )  because of  **JAVA** after using this template. 

I had taken this template from legendary coder @uwi.

You have to write all your code in solve() method.

From main() method we are calling solve() method which is supposed to solve the asked problem.

Let me tell you how to use this template:

###### Methods and their use in code:

int x=**ni()** -to input single number

long x=**nl()**  -to input long number

double x=**nd()**- to input double values

String x=**ns()**- to input string

char x=**nc()**- to input character

int[] arr=**na(int n)**  -to input array of size n i.e parameter is integer with  value n. It will allocate a new array and return its reference.

char [][] matrix =**nm(int n,int m)** this is method is used tor inputing character matrix

pn(Object o)  - **pn() method is used to print anthing on consolve 
                                 the parameter is Object is you can pass anthing.
                           It is similar as System.out.println()**
                           
p(Object o) **Similar as System.out.print()**

int x=**max( int[] arr)**  -it will find max element from array;
int y=**min(int [] arr)** it will find min element from array

int a=**nCr(int n,int rc)** for Combinatorics 
int g=**gcd(x,y)** for finding gcd

**I had to implement pair class because there is no inbuilt pair class.
You can use the pair in Hashed Collections as well as Tree Collections because hashCode() and compareTo() methods are implemented in this pair class**



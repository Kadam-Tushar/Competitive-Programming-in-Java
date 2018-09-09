# CLOCK:

[Contest Link ](https://www.codechef.com/KPR32018/problems/CLOCK)

**Author:** 

[ Codechef-Tushar Kadam](https://www.codechef.com/users/cis_pie)     

[Github](https://github.com/Kadam-Tushar)

**Tester:** 

[Codechef- Sangram Desai](https://www.codechef.com/users/sangram123)   

[Github](https://github.com/sangramdesai123)

**Editorialist:** [Tushar Kadam](https://www.codechef.com/users/cis_pie)

# DIFFICULTY:
SIMPLE


# PREREQUISITES:
- Understanding of Normal 12 hr clock. 

- [Mod operator](https://en.wikipedia.org/wiki/Modulo_operation)


# PROBLEM:
Given time in HH MM SS format and you have to find what will be time after hour hand moves by x degrees.

# EXPLANATION:
If hour hand moves by 1 degree then 2 minutes will happen in 12 hour clock. As x is integer and smallest change in x can be only 1 degree hence 
second hand will come to its original position whatever may be the value of x i.e **SS** field will not change.
Now find if minutes to add in MM field is greater than 60 or not . If final MM field > 60 then add extra minutes in hour by converting minutes to
hour.

Note : if x > 360 that means hour hand has moved by more than 360 degrees i.e several complete rotations have happened.
so to solve one can do x = x%360 which will have same effect.  



```java
// x= degrees to change , h= intials hour, m = initail mins , s=initial secs 
    x = x%360;        
      m += (x*2);         // add  2 minutes for every x in total mins
	h += m/60;            // if total mins > 60 then convert mins to hours and add those extra hours to h
	m = m % 60;             //change mins to remaining mins
	h = h % 12;           // finally it is 12 hour clock so hh can not be >12  
	if(h == 0)     
	  	h=12;           // it may happen that h can '0' after applying mod operator so instead of 0 it will  be 12 o clock in our clock

```

Possible testcases where you may get wrong answers:
input :

6

11 58 59 1

11 59 1 1

12 58 55 28

11 2 23 29

11 2 0 361

11 59 27 62


output:

12 0 59

12 1 1

1 54 55

12 0 23

11 4 0

2 3 27




# AUTHOR'S AND TESTER'S SOLUTIONS:

Author's solution [ Java Solution ](https://ideone.com/W5WJ59)

Tester's solution [Python Solution](https://ideone.com/DK8bjd). 

# Starting from the template, implement the following exercises:

1) Write a program that ask you to read a random number of numbers(between 2 and 10) from keyboard. Then display the arithmetic mean of the numbers. 
The random generated numbers should be between 1 and 1000. 

2) Given the Liga 1 ranking. Write a program which ask the user to enter a number of points. If the number match the exact number of points of a team then display the team name.
If the user do not enter an exact number of points then show this message:"No team from Liga 1 have ${numberOfPointsEnteredByUser} points".
<br>The ranking to consider is:<br>
1 CFR Cluj 49 points<br>
2 Universitatea Craiova 46 points<br>
3 FCSB 43 points<br>
4 FC Botosani 42 points<br>
5 Gaz Metan 40 points<br>
6 Astra Giurgiu 39 points<br>

3) Write a program which display the geometric mean of the primes number from [a,b] where a,b->[1,200] a<b, a and b are read from keyboard.
Also display the number of prime numbers which have the sum of digits an even number.

4) Given an vector of N integer elements. Display the first prime/odd/even number from the vector and their respective position

5) Generate a vector of size 20 with random elements from [-1000,1000].
	<br>-display the vector.
	<br>-sort the vector using bubbleSort or quickSort or mergeSort or any sort method
	<br>-display the sorted vector

6) Generate a vector which multiply the precedent 2 values from the vector. First 2 elements of the vector are always 1 and 2. Generate first n elements(n >= 8)
<br> EX: 1, 2, 2, 4, 8, 32, 256, 8192, ...
	<br>a) non-recursively 
	<br>b) recursively

7) Giving the vector ucl[1,2,3,4,5,6,7,13] meaning the times a team wins the UCL trophy.
Generate aRandom -> [0,7] ask user "How many teams win the UCL trophy ucl[aRandom] times"
(the matching values are [10,4,2,1,2,1,1,1] according to https://en.wikipedia.org/wiki/List_of_European_Cup_and_UEFA_Champions_League_finals).
If user give a number bigger than the correct answer or smaller show an appropriate message. Give the user the chance to enter the number 2 times.   

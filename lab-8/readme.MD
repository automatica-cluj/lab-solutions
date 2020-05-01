# Lab 8 - Working with IO streams


## Exercise 1 

Write a program that encrypt and decrypt text files using a very simple algorithm (each character ascii code is shifted left with 1). Encrypted file extension will be '.enc'. The application will receive the operation (encript\decript) and the file on which the operation must be applied as arguments from command line. Decrypted files will be stored having the same name as encripted file but with '.dec' extension.

## Exercise 2 

Considering exercise 1 from Lab 7, create a new version of the program which store each event in a separate binary file by serializing the _AccessLog_ object (as naming convention will be used : _accesslog-{timestamp}.dat_). 
 Create a class which reads all .dat serialized files, load them in an ArrayList (using deserialization) and display restul of _toString()_ method for each of them. 


# Implement the following exercises


## Exercise 1
![Exercise 1 image](docs/ex1.jpg)

Given the UML class diagram above, implement the corresponding Java program.

1. Create Java class based on the diagram above. 
    * _SensorReading_ should should implement ```Comparable<SensorReading>``` for comparing by date and time
    * _Sensor_ should use ```Comparator<SensorReading>``` for comparing _SensorReading_ by value
2. Demonstrate the functionality of application in Exercise1 class main method.
    * Use _SensorsCluster.addSensor_ to add few sensors. NOTE: The method should return an instance to the newly created Sensor object or null if a sensor with given id already exists
    * Use _SensorsCluster.writeSensorReading_ to add some readings for previously added sensors. This method should search for sensor by sensorId and use the sensor addSensorReading() to add a new value. Method will return false if sensor cannot be found
    * Use _SensorsCluster.getSensorById_ to obtain a reference for a previously added sensor and display sorted readings by the 2 provided criterias
3. Create minimal unit tests for testing the behavior of the program.

**Note 1: Constructors and setter\getter methods are not represented in the diagram but can\should be implemented."**

**Note 2: You can add any extra methods if required.**


## Exercise 2
![Exercise 2 image](docs/ex2.jpg)

Given the UML class diagram above, implement the corresponding Java program.

1. Create Java class based on the diagram above
    * _addWord_ method should override existing word if already exists. If synonyms are provided, all synonyms should already be in the dictionary. Method should return true if the word was successfully added or false if a particular synonym not found in the dictionary.
    * _deleteWord_ should return true if word was found and successfully deleted. 
2. Demonstrate the functionality of application in Exercise1 class main method.
3. Create unit tests for _addWord_, _deleteWord_, _searchWord_, _findSynonyms_ methods.

## Exercise 3

Create a new version of ATM exercise from Laboratory 5 and use ArrayList instead of simple arrays[] for storing accounts in Bank class.

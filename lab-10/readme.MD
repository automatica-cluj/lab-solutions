# Air Traffic Control System

In this lab you will implement a simplified air traffic control (ATC) sistem which allow user to add airplains and controll them.

## Use Case Diagram
![Exercise 1 image](docs/UseCaseDiagram1.jpg)

## Aircraft State Machine Diagram
![Exercise 2 image](docs/StatechartDiagram1.jpg)

## ATC Class Diagram
![Exercise 1 image](docs/ClassDiagram1.jpg)

## Requirements

- R0 - When added aircraft is in On Stand state. In this state airplain is waiting for a comand from ATC;
- R1 - When aircraft receives takeoff command will go into Taxing state and will stay there for 10 seconds; 
- R2 - From Taxing aircraft will go into Taking off state and will stay there for 5 seconds;
- R3 - Take off command contains cruising altitude for the aircraft;
- R4 - Aircraft will stay in Ascending state till aircraft reach cruising altitude. Altitude is given by ATC in 1.000 meters increments and needs 10 seconds for each increment. Example: altitude 3 = means aircraft cruising altitude is 3.000 meters and will need 30 seconds to reach that altitude;
- R5 - Aircraft can receive land command only when is at cruising altitude;
- R6 - Descending will be done in 1.0000 meters increments;
- R7 - When aircraft has reached altitude 0 is considered landed;
- R8 - Aircraft will keep track of number of seconds spent in "Cruising" state and will display it after it landed;
- [OPTIONAL] - Add a graphical user interface to let user interact wit ATC system;

## Implementation recommendations

- User interaction is done trough a console based user interface (Example: user will enter command TAKEOFF {aircraftid} {altitude} or LAND {aircrfatid}); 
- Aircraft objects are implemented as threads;
- After aircraft land the thread will be finished;
- Use wait()\notify() mechanism to implement mechanism for aircraft to wait for ATC command; 

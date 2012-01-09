
/*
This is an example for the Accelerometer implementation of the Simpleface library
*/

import simpleface.*;

SimpleAccelerometer myAcc;
int x1 = 50;
int y1 = 50;

int x2 = 100;
int y2 = 50;

int x3 = 100;
int y3 = 200;

int x4 = 50;
int y4 = 200;


void setup() {
  size(400,400);
  background(0);
  smooth();
  
  myAcc = new SimpleAccelerometer();
  myAcc.setTolerance(20);
  
  quad(x1, y1, x2, y2, x3, y3, x4, y4);

}

void draw() {
  
  if (myAcc.isRollingLeft()) {
    background(0);
    x1 = x1 - 10;
    x2 = x2 - 10;
    x3 = x3 - 10;
    x4 = x4 - 10;
    quad(x1, y1, x2, y2, x3, y3, x4, y4);
    println("Left!");
  }
  
  if (myAcc.isRollingRight()) {
    background(0);
    x1 = x1 + 10;
    x2 = x2 + 10;
    x3 = x3 + 10;
    x4 = x4 + 10;
    quad(x1, y1, x2, y2, x3, y3, x4, y4);
    println("Right!");
  }
  
}

package com.shibaura.system;

public class Car {
    double speed = 0.0;
    public void setSpeed(double ds){
        speed = ds;
    }
    public double getSpeed(){
        return speed * 3600.0 / 1000.0; // converted (km/h)
    }
}

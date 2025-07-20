package models.state;

import models.TrafficLight;

public interface SignalState {
    void handle(TrafficLight trafficLight) throws InterruptedException;
    SignalState nextState();
}

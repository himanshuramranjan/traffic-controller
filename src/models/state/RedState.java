package models.state;

import models.SignalType;
import models.TrafficLight;

import static java.lang.Thread.sleep;

public class RedState implements SignalState {
    @Override
    public void handle(TrafficLight trafficLight) throws InterruptedException {
        trafficLight.changeSignal(SignalType.RED);
        System.out.println("Current Signal : RED");
        sleep(trafficLight.getRedDuration());
    }

    @Override
    public SignalState nextState() {
        return new GreenState();
    }
}

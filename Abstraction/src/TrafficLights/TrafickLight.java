package TrafficLights;

import java.awt.*;

public class TrafickLight {
    private Light light;

    public TrafickLight(Light light) {
        this.light = light;
    }

    public Light getLight(){
        return this.light;
    }
    public void update() {
        switch (this.light) {
            case RED:
                this.light = Light.GREEN;
                break;
            case GREEN:
                this.light = Light.YELLOW;
                break;
            case YELLOW:
                this.light = Light.RED;
        }
    }
}

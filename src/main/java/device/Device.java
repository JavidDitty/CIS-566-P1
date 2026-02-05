package device;

import component.battery.Battery;
import component.display.Display;
import component.processor.Processor;

import java.util.HashMap;

public abstract class Device {
    protected static HashMap<String, Integer> instances = new HashMap<String, Integer>();

    public static Device getInstance() {
        return null;
    }

    public abstract Battery createBattery();
    public abstract Display createDisplay();
    public abstract Processor createProcessor();
}

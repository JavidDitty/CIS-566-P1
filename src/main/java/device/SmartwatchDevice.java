package device;

import component.battery.Battery;
import component.battery.SmartwatchBattery;
import component.display.Display;
import component.display.SmartwatchDisplay;
import component.processor.Processor;
import component.processor.SmartwatchProcessor;

public class SmartwatchDevice extends Device {
    private SmartwatchDevice() {}

    public static Device getInstance() {
        String name = SmartwatchDevice.class.getSimpleName();

        // Initialize the device in the instances maps
        if (!SmartwatchDevice.instances.containsKey(name)) {
            SmartwatchDevice.instances.put(name, 0);
        }

        // Return an instance (if fewer than 2 exist)
        int count = SmartwatchDevice.instances.get(name);
        if (count < 2) {
            SmartwatchDevice.instances.put(name, count+1);
            return new SmartwatchDevice();
        }
        return null;
    }

    @Override
    public Battery createBattery() {
        return new SmartwatchBattery();
    }

    @Override
    public Display createDisplay() {
        return new SmartwatchDisplay();
    }

    @Override
    public Processor createProcessor() {
        return new SmartwatchProcessor();
    }
}

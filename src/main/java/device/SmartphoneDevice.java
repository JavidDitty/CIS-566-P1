package device;

import component.battery.Battery;
import component.battery.SmartphoneBattery;
import component.display.Display;
import component.display.SmartphoneDisplay;
import component.processor.Processor;
import component.processor.SmartphoneProcessor;

public class SmartphoneDevice extends Device {
    private SmartphoneDevice() {}

    public static Device getInstance() {
        String name = SmartphoneDevice.class.getSimpleName();

        // Initialize the device in the instances maps
        if (!SmartphoneDevice.instances.containsKey(name)) {
            SmartphoneDevice.instances.put(name, 0);
        }

        // Return an instance (if fewer than 2 exist)
        int count = SmartphoneDevice.instances.get(name);
        if (count < 2) {
            SmartphoneDevice.instances.put(name, count+1);
            return new SmartphoneDevice();
        }
        return null;
    }

    @Override
    public Battery createBattery() {
        return new SmartphoneBattery();
    }

    @Override
    public Display createDisplay() {
        return new SmartphoneDisplay();
    }

    @Override
    public Processor createProcessor() {
        return new SmartphoneProcessor();
    }
}

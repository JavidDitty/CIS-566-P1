package device;

import component.battery.Battery;
import component.battery.LaptopBattery;
import component.display.Display;
import component.display.LaptopDisplay;
import component.processor.LaptopProcessor;
import component.processor.Processor;

public class LaptopDevice extends Device {
    private LaptopDevice() {}

    public static Device getInstance() {
        String name = LaptopDevice.class.getSimpleName();

        // Initialize the device in the instances maps
        if (!LaptopDevice.instances.containsKey(name)) {
            LaptopDevice.instances.put(name, 0);
        }

        // Return an instance (if fewer than 2 exist)
        int count = LaptopDevice.instances.get(name);
        if (count < 2) {
            LaptopDevice.instances.put(name, count+1);
            return new LaptopDevice();
        }
        return null;
    }

    @Override
    public Battery createBattery() {
        return new LaptopBattery();
    }

    @Override
    public Display createDisplay() {
        return new LaptopDisplay();
    }

    @Override
    public Processor createProcessor() {
        return new LaptopProcessor();
    }
}

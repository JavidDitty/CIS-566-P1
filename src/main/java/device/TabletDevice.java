package device;

import component.battery.Battery;
import component.battery.TabletBattery;
import component.display.Display;
import component.display.TabletDisplay;
import component.processor.Processor;
import component.processor.TabletProcessor;

public class TabletDevice extends Device {
    private TabletDevice() {}

    public static Device getInstance() {
        String name = TabletDevice.class.getSimpleName();

        // Initialize the device in the instances maps
        if (!TabletDevice.instances.containsKey(name)) {
            TabletDevice.instances.put(name, 0);
        }

        // Return an instance (if fewer than 2 exist)
        int count = TabletDevice.instances.get(name);
        if (count < 2) {
            TabletDevice.instances.put(name, count+1);
            return new TabletDevice();
        }
        return null;
    }

    @Override
    public Battery createBattery() {
        return new TabletBattery();
    }

    @Override
    public Display createDisplay() {
        return new TabletDisplay();
    }

    @Override
    public Processor createProcessor() {
        return new TabletProcessor();
    }
}

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
        if (!SmartphoneDevice.instances.containsKey(name)) { // 2. If the key (Smartphone) exists in Device.instances, it returns true
            SmartphoneDevice.instances.put(name, 0);
        }

        // Return an instance (if fewer than 2 exist)
        int count = SmartphoneDevice.instances.get(name); // 3. Device.instances return the count as 2 since 2 devices exist at this point
        if (count < 2) {
            SmartphoneDevice.instances.put(name, count+1);
            return new SmartphoneDevice();
        }
        return null; // 4. null is returned to Main.main() from Device.getInstance() since 2 exist at this point
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

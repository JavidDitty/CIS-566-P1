import component.battery.Battery;
import component.display.Display;
import component.processor.Processor;
import device.Device;

public class TestBench {
    public void runTest(Device device) {
        // Create the components of the device
        Battery battery = device.createBattery();
        Display display = device.createDisplay();
        Processor processor = device.createProcessor();

        // Print the components of the device
        System.out.println(battery);
        System.out.println(display);
        System.out.println(processor);
    }
}

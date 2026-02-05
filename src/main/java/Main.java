import device.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Check that an argument has been provided
        if (args.length < 1) {
            System.out.println("ERROR: Path to configuration file not provided!");
            System.exit(1);
        }

        // Get the devices in the configuration file
        String filename = args[0];
        File config = new File(filename);
        ArrayList<String> ids = new ArrayList<String>();
        try (Scanner scanner = new Scanner(config)) {
            while (scanner.hasNextLine()) {
                String id = scanner.nextLine();
                ids.add(id);
            }
        } catch (FileNotFoundException e) {
            System.out.printf("ERROR: Path \"%s\" could not be found!\n", filename);
            System.exit(1);
        }

        // Perform a test run on the devices
        TestBench testBench = new TestBench();
        for (String id: ids) {
            Device device = null;
            switch (id.strip().toLowerCase()) {
                case "laptop":
                    device = LaptopDevice.getInstance();
                    break;
                case "smartphone":
                    device = SmartphoneDevice.getInstance();
                    break;
                case "smartwatch":
                    device = SmartwatchDevice.getInstance();
                    break;
                case "tablet":
                    device = TabletDevice.getInstance();
                    break;
                default:
                    System.out.printf("ERROR: Device \"%s\" is not registered!\n", device);
                    System.exit(1);
                    break;
            }
            if (device != null) {
                testBench.runTest(device);
            } else {
                System.out.printf("Device \"%s\" has already been tested 2 times! Skipping...\n", id);
            }
        }
    }
}

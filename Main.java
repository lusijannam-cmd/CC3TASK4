import java.util.ArrayList;
import java.util.LinkedHashMap; // Import para sa counting
import java.util.Map;         

public class Main {
    public static void main(String[] args) {

        HardwareRepository repo = new HardwareRepository();
        ArrayList<Hardware> list = repo.getAllHardware();

        System.out.println("=== Hardware Masterlist ===\n");

        System.out.printf("%-3s %-20s %-5s %-10s %-25s\n",
                "ID", "Brand", "Spec", "Type", "Expected Interpretation");

        System.out.println("--------------------------------------------------------------------------");

        
        Map<String, Integer> summary = new LinkedHashMap<>();

        for (Hardware h : list) {

            System.out.printf("%-3d %-20s %-5d %-10s %-25s\n",
                    h.getId(), 
                    h.getBrand(), 
                    h.getSpec(), 
                    h.getType(), 
                    h.interpretSpec()
            );


            if (h instanceof Laptop) {
                String key = "Laptop (" + h.interpretSpec() + ")"; 
                summary.put(key, summary.getOrDefault(key, 0) + 1);
            } else if (h instanceof Phone) {
                String key = "Phone (" + h.interpretSpec() + ")";
                summary.put(key, summary.getOrDefault(key, 0) + 1);
            }
        }

        System.out.println("\n=== Inventory Summary ===");

        for (Map.Entry<String, Integer> entry : summary.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
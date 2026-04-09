import java.util.ArrayList;
import java.util.LinkedHashMap; 
import java.util.Map;         

public class Main {
    public static void main(String[] args) {

        HardwareRepository repo = new HardwareRepository();
        boolean shouldSave = true;

        Hardware.Builder builder = new Hardware.Builder()
                .setBrand("Acer nirvana")
                .setSpec(228) ;
          

        Hardware newLaptop = new Laptop(builder);

        if (shouldSave) {
    repo.addHardware(newLaptop);
} else {
    System.out.println("");
}
     

        ArrayList<Hardware> list = repo.getAllHardware();

        
        System.out.println("\n=== Hardware Masterlist ===\n");
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

           
            String key = h.getType() + " (" + h.interpretSpec() + ")";
            summary.put(key, summary.getOrDefault(key, 0) + 1);

        }

     
System.out.println("\n=== Inventory Summary ===");


for (Map.Entry<String, Integer> entry : summary.entrySet()) {
    if (entry.getKey().startsWith("Laptop")) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}


for (Map.Entry<String, Integer> entry : summary.entrySet()) {
    if (entry.getKey().startsWith("Phone")) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}
    }
}
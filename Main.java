import java.util.List;

public class Main {
    public static void main(String[] args) {
        HardwareRepository repo = new HardwareRepository();
<<<<<<< HEAD
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
=======
        List<Hardware> masterList = repo.getAllHardware();
>>>>>>> bbef75d (updated)

        // 1. Prints Hardware Masterlist
        System.out.println("ID\tBrand\t\tInterpretation");
        System.out.println("---------------------------------------");
        for (Hardware h : masterList) {
            System.out.println(h.getId() + "\t" + h.getBrand() + "\t\t" + h.interpretSpec());
        }

        System.out.println("\n--- Laptop and Phone Inventory ---");


        String countedSpecs = "";

        for (Hardware h : masterList) {

            String currentLabel = h.getSpec() + (h instanceof Laptop ? "GB Laptop" : "MP Phone");

            if (!countedSpecs.contains(currentLabel)) {
                int count = 0;


                for (Hardware search : masterList) {
                    String searchLabel = search.getSpec() + (search instanceof Laptop ? "GB Laptop" : "MP Phone");
                    if (currentLabel.equals(searchLabel)) {
                        count++;
                    }
                }


                System.out.println("Total number of " + currentLabel + "s: " + count);


                countedSpecs += currentLabel + ",";
            }
        }
    }
}
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        HardwareRepository repo = new HardwareRepository();
        ArrayList<Hardware> list = repo.getAllHardware();

        System.out.println("=== Hardware Masterlist ===\n");

        System.out.printf("%-3s %-20s %-5s %-10s %-25s\n",
                "ID", "Brand", "Spec", "Type", "Expected Interpretation");

        System.out.println("--------------------------------------------------------------------------");

        int laptop16 = 0, laptop32 = 0, phone50 = 0;

        for (Hardware h : list) {

            System.out.printf("%-3d %-20s %-5d %-10s %-25s\n",
                    h.getId(),
                    h.getBrand(),
                    h.getSpec(),
                    h.getType(),
                    h.interpretSpec()
            );

            // Polymorphic counting
            if (h instanceof Laptop) {
                if (h.getSpec() == 16) laptop16++;
                if (h.getSpec() == 32) laptop32++;
            }

            if (h instanceof Phone) {
                if (h.getSpec() == 50) phone50++;
            }
        }

        System.out.println("\n=== Inventory Summary ===");
        System.out.println("16GB Laptops: " + laptop16);
        System.out.println("32GB Laptops: " + laptop32);
        System.out.println("50MP Phones: " + phone50);
    }
}
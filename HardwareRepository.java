import java.sql.*;
import java.util.ArrayList;

class HardwareRepository {

    private final String URL = "jdbc:mysql://localhost:3306/hardware_db";
    private final String USER = "root";
    private final String PASS = "Gomer*1203";

    // --- DITO MO SIYA ISISINGIT (BAGO O PAGKATAPOS NG getAllHardware) ---
    public void addHardware(Hardware hardware) {
        String sql = "INSERT INTO hardware (brand, spec, type) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, hardware.getBrand());
            pstmt.setInt(2, hardware.getSpec());
            pstmt.setString(3, hardware.getType());

            pstmt.executeUpdate();
            System.out.println("Success: Na-add na ang bagong specs!");

        } catch (SQLException e) {
            System.out.println("Error sa pag-add: " + e.getMessage());
        }
    }

    public ArrayList<Hardware> getAllHardware() {
        ArrayList<Hardware> list = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM hardware");

            while (rs.next()) {
                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                int spec = rs.getInt("spec");
                String type = rs.getString("type");

                Hardware.Builder builder = new Hardware.Builder()
                        .setId(id)
                        .setBrand(brand)
                        .setSpec(spec)
                        .setType(type);

                if (type.equalsIgnoreCase("Laptop")) {
                    list.add(new Laptop(builder));
                } else {
                    list.add(new Phone(builder));
                }
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
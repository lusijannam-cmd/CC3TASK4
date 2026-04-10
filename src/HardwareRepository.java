import java.sql.*;
import java.util.ArrayList;

class HardwareRepository {
    private final String URL = "jdbc:mysql://localhost:3306/hardware_db";
    private final String USER = "root";
    private final String PASS = "kyhoon0808";

    public void addHardware(Hardware hardware) {
        String sql = "INSERT INTO hardware (brand, spec, type) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, hardware.getBrand());
            pstmt.setInt(2, hardware.getSpec());
            pstmt.setString(3, hardware.getType());
            pstmt.executeUpdate();
            System.out.println(">>> System: Na-save na si " + hardware.getBrand());

        } catch (SQLException e) {
            System.out.println(">>> SQL Error (Add): " + e.getMessage());
        }
    }

    public ArrayList<Hardware> getAllHardware() {
        ArrayList<Hardware> list = new ArrayList<>();
        String sql = "SELECT * FROM hardware ORDER BY id ASC";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            int sequenceCounter = 1;

            while (rs.next()) {
                Hardware.Builder builder = new Hardware.Builder()

                        .setId(sequenceCounter++)

                        .setBrand(rs.getString("brand"))
                        .setSpec(rs.getInt("spec"));

                String type = rs.getString("type");

            if (type != null && type.equalsIgnoreCase("Laptop"))

                if (rs.getString("type").equalsIgnoreCase("Laptop")) {
                    list.add(new Laptop(builder));
                } else if (type != null && type.equalsIgnoreCase("Phone")) {
                    list.add(new Phone(builder));
                } else {
                    // fallback (optional)
                    list.add(new Phone(builder));
                }
            }
        } catch (SQLException e) {
            System.out.println(">>> SQL Error (Get): " + e.getMessage());
        }
        return list;
    }
}
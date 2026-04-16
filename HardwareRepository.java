import java.sql.*;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
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
<<<<<<< HEAD
            System.out.println(">>> System: Saved " + hardware.getBrand());
=======
            System.out.println(">>> System: Na-save na si " + hardware.getBrand());
>>>>>>> c7f38be730078c511ab208579294e9faf48d4bf8

        } catch (SQLException e) {
            System.out.println(">>> SQL Error (Add): " + e.getMessage());
        }
    }

    public ArrayList<Hardware> getAllHardware() {
        ArrayList<Hardware> list = new ArrayList<>();
<<<<<<< HEAD
        String sql = "SELECT * FROM hardware ORDER BY id ASC";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
=======
public class HardwareRepository {
    private String url = "jdbc:mysql://localhost:3306/hardware_db";
    private String user = "root";
    private String pass = "Gomer*1203";

    public List<Hardware> getAllHardware() {
        List<Hardware> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
>>>>>>> bbef75d (updated)
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM hardware")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                int spec = rs.getInt("spec");
                String type = rs.getString("type");

<<<<<<< HEAD
                if (type != null && type.equalsIgnoreCase("Laptop")) {
=======
        String sql = "SELECT * FROM hardware ORDER BY id ASC"; 

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            int sequenceCounter = 1;

            while (rs.next()) {
                Hardware.Builder builder = new Hardware.Builder()
                        .setId(id)
                        .setBrand(brand)
                        .setSpec(spec);

               if (type != null && type.equalsIgnoreCase("Laptop")) {
            
                        .setId(sequenceCounter++) 
                        
                    
                        
                        .setBrand(rs.getString("brand"))
                        .setSpec(rs.getInt("spec"))
                        .setType(rs.getString("type"));

                if (rs.getString("type").equalsIgnoreCase("Laptop")) {
>>>>>>> c7f38be730078c511ab208579294e9faf48d4bf8
                    list.add(new Laptop(builder));
                } else if (type != null && type.equalsIgnoreCase("Phone")) {
                    list.add(new Phone(builder));
                } else {
                    // fallback (optional)
                    list.add(new Phone(builder));
=======
                if ("Laptop".equalsIgnoreCase(type)) {
                    list.add(new Laptop(id, brand, spec));
                } else if ("Phone".equalsIgnoreCase(type)) {
                    list.add(new Phone(id, brand, spec));
>>>>>>> bbef75d (updated)
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
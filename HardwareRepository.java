import java.sql.*;
import java.util.ArrayList;

class HardwareRepository {

    private final String URL = "jdbc:mysql://localhost:3306/hardware_db";
    private final String USER = "root";
    private final String PASS = "kyhoon0808";

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
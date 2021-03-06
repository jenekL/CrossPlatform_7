package mdatabase;

import data.Klients;
import data.Prodaja;
import data.Zakupka;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MDataBase {
    private final String URL = "jdbc:mysql://localhost:3306/krosp_lab5?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //private final String URL = "jdbc:mysql://localhost:3306/krosp_lab5";
    private final String NAME = "root";
    private final String PASS = "123ALOALOPRIVATEnetrogayte123";
    private Statement stmt;
    private Statement stmt1;
    private Statement stmt2;
    private Connection connection;
    private ResultSet rs;
    private ArrayList<Prodaja> tableData = new ArrayList<Prodaja>();

    private static MDataBase instance;

    private MDataBase() {
        try {
            connection = DriverManager.getConnection(URL, NAME, PASS);
            stmt = connection.createStatement();
            stmt1 = connection.createStatement();
            stmt2 = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized MDataBase getInstance() {
        if(instance == null){
            instance = new MDataBase();
        }
        return instance;
    }

    public ArrayList<Prodaja> createEntity(){
        try {
            rs = stmt.executeQuery("SELECT * FROM тПродажа");
            ResultSetMetaData resultSetMetaData = rs.getMetaData();

            //System.out.println(resultSetMetaData.getColumnCount());
            while (rs.next()) {

                ResultSet resZakup = stmt1.executeQuery("SELECT * FROM тзакупка where Код_товара = " + rs.getString(4));
                ResultSet resKlient = stmt2.executeQuery("SELECT * FROM тклиенты where Код_клиента = " + rs.getString(5));

                while(resZakup.next() && resKlient.next()) {
                    tableData.add(new Prodaja(Integer.parseInt(rs.getString(1)), rs.getString(2), Integer.parseInt(rs.getString(3)),
                            new Klients(Integer.parseInt(resKlient.getString(1)), resKlient.getString(2), resKlient.getString(3), resKlient.getString(4), Integer.parseInt(resKlient.getString(5))),
                            new Zakupka(Integer.parseInt(resZakup.getString(1)), resZakup.getString(2), Float.parseFloat(resZakup.getString(3)), resZakup.getString(4))));
                    //System.out.println(Integer.parseInt(rs.getString(1)) + rs.getString(2) + Integer.parseInt(rs.getString(3)));
                    //System.out.println(tableData.get(1).toString());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tableData;
    }

    public List<Klients> createClientsEntity(){
        List<Klients> klientsArrayList = new ArrayList<>();
        try {
            rs = stmt.executeQuery("SELECT * FROM тклиенты");
            ResultSetMetaData resultSetMetaData = rs.getMetaData();


            //System.out.println(resultSetMetaData.getColumnCount());
            while (rs.next()) {

                klientsArrayList.add(new Klients(Integer.parseInt(rs.getString(1)), rs.getString(2),
                        rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return klientsArrayList;
    }

    public List<Zakupka> createZakupkaEntity(){
        List<Zakupka> zakupkaArrayList = new ArrayList<>();
        try {
            rs = stmt.executeQuery("SELECT * FROM тзакупка");

            while (rs.next()) {

                zakupkaArrayList.add(new Zakupka(Integer.parseInt(rs.getString(1)), rs.getString(2),
                        Float.parseFloat(rs.getString(3)),rs.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zakupkaArrayList;
    }

    public  ArrayList<String[]> showTable(String tableName) {
        ArrayList<String[]> data = new ArrayList<String[]>();
        String[] tmp;

        try {

            rs = stmt.executeQuery("SELECT * FROM " + tableName);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
           // System.out.println(resultSetMetaData.getColumnCount());
            while (rs.next()) {
                tmp = new String[resultSetMetaData.getColumnCount()];
                for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++ ) {
                    tmp[i - 1] = rs.getString(i);
                    //str += rs.getString(i)+ " ";
                }
                data.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void addRow(String tableName, String[] data) throws SQLException {

        rs = stmt.executeQuery("SELECT * FROM " + tableName + " LIMIT 0, 0");
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        StringBuilder name = new StringBuilder("INSERT INTO " + tableName + "(");
        for(int i = 2; i <= resultSetMetaData.getColumnCount(); i++) {
            if(i == resultSetMetaData.getColumnCount()){
                name.append(resultSetMetaData.getColumnName(i));
                break;
            }
            name.append(resultSetMetaData.getColumnName(i)).append(", ");
        }
        name.append(") VALUES (");
        for(int i = 2; i <= resultSetMetaData.getColumnCount(); i++) {
            if(i == resultSetMetaData.getColumnCount()){
                name.append("?");
                break;
            }
            name.append("?,");
        }
        name.append(")");

        System.out.println(name);

        PreparedStatement stmt = connection.prepareStatement(name.toString());

        for(int i = 1; i < resultSetMetaData.getColumnCount(); i++) {

            stmt.setString(i, data[i-1]);

        }
        stmt.executeUpdate();
    }

    public void deleteRow(String tableName, int num) throws SQLException {

        rs = stmt.executeQuery("SELECT * FROM " + tableName + " LIMIT 0, 0");
        ResultSetMetaData resultSetMetaData = rs.getMetaData();

        String sql = "delete from "+ tableName + " where " + tableName + "." + resultSetMetaData.getColumnName(1) + " = " + num;

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.executeUpdate();
    }

    public void close(){
        try {
            //rs.close();
            //stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("closed");
    }
}


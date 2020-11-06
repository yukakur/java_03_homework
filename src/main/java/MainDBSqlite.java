import java.io.*;
import java.sql.*;

public class MainDBSqlite {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement pStatement;

    public static void main(String[] args) {

    }

    public static void setConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * создание таблицы с готовой командой String sqlite
     * @param tableName название таблицы
     * @param sqliteCommand команда по созданию колонок
     */

    public void createTable(String tableName, String sqliteCommand) {
        try {
            statement.executeUpdate("CREATE TABLE " + tableName + " ( " + ") " );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * создание таблицы с консоли
     * @param tableName название таблицы
     * @param rows количество столбцов
     */
    public void createTable(String tableName, int rows) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            StringBuffer strB = new StringBuffer("CREATE TABLE " + tableName + " ( ");
            for (int i = 0; i < rows; i++) {
                try {
                    System.out.println("Please write " + (i + 1) + " row name");
                    strB.append(reader.readLine().trim());
                    System.out.println("Please write " + (i + 1) + " row unit and specific option");
                    strB.append(" " + reader.readLine().trim().toUpperCase() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            reader.close();
            statement.executeUpdate(strB + " );" );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * заполнение таблицы с переданного файла (3 графы ids, name, score)
     * @param tableName название таблицы
     * @param file переданный файл
     */
    public void addInfoToTableFromFile(String tableName, File file) {
        BufferedReader reader;
        StringBuffer strB = new StringBuffer("INSERT INTO " + tableName + " (ids, name, score) VALUES (");
        try {
            reader = new BufferedReader(new FileReader(file));
            while (reader.ready()) {
                String [] inputArray = reader.readLine().trim().split(" ");
                for (int i = 0; i < inputArray.length; i++) {
                    strB.append("'" + inputArray[i] + "', ");
                }
                strB.setLength(strB.length() - 1);
                strB.append("')");
                statement.executeUpdate(strB.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getInfoFromTable(String tableName) {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT * FROM " + tableName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ResultSetMetaData rsmd;
        try {
            rsmd = rs.getMetaData();
            for (int i = 1; i < rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnType(i));
            }
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void deleteById (String tableName, int id) {
        try {
            statement.executeUpdate("DELETE FROM " + tableName + " WHERE id = " + id + ";");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }





}

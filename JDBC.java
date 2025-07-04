//Step-01: Importing the sql package.
import java.sql.*;
public class JDBC{
    public static void main(String[] args)throws SQLException, ClassNotFoundException {
        //Step-02:Loading the driver.
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Step-03: Getting the connection.
        String url = "jdbc:mysql://localhost:3306/sumit";
        String name="root";
        String pass="sumit";
        Connection con = DriverManager.getConnection(url, name, pass);
        //Step-04: Creating the Statement.
        Statement stmnt = con.createStatement();
        //Step-05: Executing the Query.
        String query = "SELECT * FROM family";
        ResultSet rs = stmnt.executeQuery(query);
        int column = rs.getMetaData().getColumnCount();
        for(int i=1;i<=column;i++){
            System.out.print(rs.getMetaData().getColumnName(i)+"  ");
        }
        System.out.println();
        while(rs.next()){
            for(int i=1;i<=column;i++){
                System.out.print(rs.getString(i));
            }
            System.out.println();
        }
        stmnt.close();
        con.close();
    }
}
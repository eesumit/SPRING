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
        String query1 = "SELECT * FROM family";
        String query2 = "insert into family values(?,?,?)";
        PreparedStatement st = con.prepareStatement(query2);
        st.setString(1,"z");
        st.setInt(2,1);
        st.setString(3,"x&y");
        int count = st.executeUpdate();
        System.out.println(count+" rows affected.");
        ResultSet rs = stmnt.executeQuery(query1);
        int column = rs.getMetaData().getColumnCount();
        for(int i=1;i<=column;i++){
            System.out.print(rs.getMetaData().getColumnName(i)+"  ");
        }
        System.out.println();
        while(rs.next()){
            for(int i=1;i<=column;i++){
                System.out.print(rs.getString(i)+"\t");
            }
            System.out.println();
        }
        stmnt.close();
        con.close();
    }
}
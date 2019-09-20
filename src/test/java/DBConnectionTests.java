import org.junit.Test;
import pages.DBConnection;

public class DBConnectionTests {
    DBConnection dbConnection=new DBConnection();

    @Test
    public void getOwners(){
        dbConnection.getConnection("jdbc:mysql://bhdtest.endava.com:3306/petclinic","root","root","SELECT * FROM owners");
    }

    @Test
    public void deleteOwner(){
        dbConnection.getConnection("jdbc:mysql://bhdtest.endava.com:3306/petclinic","root","root","DELETE * FROM owners WHERE first_name=\"George\" and last_name=\"Franklin\"");
    }
}

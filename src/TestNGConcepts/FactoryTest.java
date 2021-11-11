package TestNGConcepts;
//import com.google.common.annotations.VisibleForTesting;
import org.testng.annotations.Test;
public class FactoryTest {
    String Username;
    String Password;
    public FactoryTest(String Username, String Password){
        this.Username=Username;
        this.Password=Password;
    }
    @Test
    public void method1(){
        System.out.println("Username: "+Username+" Password:"+Password);
    }
}

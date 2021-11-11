package TestNGConcepts;


import org.testng.annotations.Factory;

public class FactoryClass {
   @Factory
    public Object[] getinstances() {
        Object obj = new Object[]{
                new FactoryTest("User1", "Password1"),
                new FactoryTest("User2", "Password2"),
                new FactoryTest("User3", "Password3"),
        };
        return (Object[]) obj;
    }

}

package Integration;

import org.testng.TestNG;
import org.testng.annotations.Test;

public class mainTest {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{mainTest.class});
        testng.run();
    }

    @Test
    public void helloJar() {
        System.out.println("Jar");
    }

}

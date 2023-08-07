import org.example.Person;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;

public class PersonTest {

    public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("Before Class");
        currentTime();
    }

    @AfterClass
    void afterClass() {
        System.out.println("After Class");
        currentTime();
    }

    @DataProvider(name = "isTeenager")
    Object[][] isTeenager() {
        return new Object[][]{
                {12, false},
                {17, true},
                {5, false},
                {13, true},
                {19, true},
                {20, false},
                {-14, false}
        };
    }

    @Test(dataProvider = "isTeenager")
    public void teenagerTest(int age, boolean isTeenager) {
        boolean result = Person.isTeenager(age);
        System.out.println(result);
        assertEquals(result, isTeenager);
    }
}

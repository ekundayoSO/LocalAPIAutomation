package APIRequests;

import org.testng.annotations.DataProvider;

public class DataForTest {

    @DataProvider(name = "DataForPost")
    public Object[][] postData() {
        return new Object[][] {
                {"Johnson", "Sterling", 1},
                {"Hammed", "Bella", 2}
        };
    }

    @DataProvider(name = "DeleteData")
    public Object[] dataForDelete() {
        return new Object[] {
                4, 5
        };
    }

}

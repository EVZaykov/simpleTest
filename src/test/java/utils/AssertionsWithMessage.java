package utils;

import io.qameta.allure.Allure;
import org.junit.Assert;

public class AssertionsWithMessage {

    public static void assertWithMessage(Object var1, Object var2) {
        Allure.step("Expected Result = " + var1);
        Allure.step("Actual Result = " + var2);
        Assert.assertEquals(var1,var2);
    }
}

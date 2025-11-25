package com.swagLaps.utilities;

import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

public class CustomSoftAssertion extends SoftAssert {
    public static CustomSoftAssertion SoftAssertion = new CustomSoftAssertion();

@Step("Performing Custom Soft Assert All")
    public static void CustomassertAll() {
//        SoftAssertion.assertAll();

        try {
            SoftAssertion.assertAll("Custom Soft Assertion");
        } catch (Exception e)   {
            System.out.println("Custom soft Assertion Failed");
        }
    }

}

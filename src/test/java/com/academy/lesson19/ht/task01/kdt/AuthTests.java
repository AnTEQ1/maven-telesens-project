package com.academy.lesson19.ht.task01.kdt;

import com.academy.ddt.core.BaseTest;
import com.academy.lesson19.ht.task01.kdt.engine.KeywordStep;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuthTests extends BaseTest {

    private BaseKDTTest baseKDT;
    ReadKDTFile readKDTFile = new ReadKDTFile();

    @BeforeClass
    public void setUp() {
        baseKDT = new BaseKDTTest(driver);
    }

    @Test(groups={"kdt"}, dataProvider = "kdtProvider")
    public void testIncorrectLogin(List<KeywordStep> steps) {
        baseKDT.kdtTest(steps);
    }

    @DataProvider(name="kdtProvider")
    public Object[][] loginTestProvider() {

        List<KeywordStep> steps = new ArrayList<>();
        List<String[]> data = readKDTFile.readData();
        for (int i = 0; i < data.size(); i++) {
            System.out.println(Arrays.deepToString(data.get(i)));
                steps.add(new KeywordStep()
                        .withPage(data.get(i)[0])
                        .withAction(data.get(i)[1])
                        .withObject(data.get(i)[2])
                        .withValue(data.get(i)[3]));
        }
        // TODO read from csv
        // Home,GOTOURL,,http://automationpractice.com/index.php
        // Home,CLICK,signInLink,
        /*steps.add(new KeywordStep()
                .withPage("Home")
                .withAction("GOTOURL")
                .withObject("")
                .withValue("http://automationpractice.com/index.php"));

        steps.add(new KeywordStep()
                .withPage("Home")
                .withAction("CLICK")
                .withObject("signInLink")
                .withValue(""));

        steps.add(new KeywordStep()
                .withPage("Login")
                .withAction("INPUT")
                .withObject("login")
                .withValue("test@gmail.com"));

        steps.add(new KeywordStep()
                .withPage("Login")
                .withAction("INPUT")
                .withObject("password")
                .withValue("123"));

        steps.add(new KeywordStep()
                .withPage("Login")
                .withAction("CLICK")
                .withObject("signInButton")
                .withValue(""));

        steps.add(new KeywordStep()
                .withPage("Login")
                .withAction("ASSERT")
                .withObject("msgErrText")
                .withValue("Invalid password.")); */

//        steps.add(new KeywordStep()
//                .withPage("account")
//                .withAction("CLICK")
//                .withObject("signOutButton")
//                .withValue(""));

        return new Object[][] {
                {steps},
        };
    }
}
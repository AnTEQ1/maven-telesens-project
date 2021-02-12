package com.academy.lesson17.ht.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DressesPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'right-block')]/div/span[contains(@itemprop,'price')]")
    private List<WebElement> pricesOnPage;
    @FindBy(id = "selectProductSort")
    private WebElement sortByList;
    @FindBy(xpath = "//h5[contains(@itemprop,'name')]/a[contains(@class, 'product-name')]")
    private List<WebElement> namesOfDresses;

    public DressesPage(WebDriver driver) {
        super(driver);
    }

    public List<Double> getAllPricesOnPage() {
        List<Double> pricesValues = new ArrayList<>();
        for (int i = 0; i < pricesOnPage.size(); i++) {
            pricesValues.add(Double.valueOf(pricesOnPage.get(i).getText().substring(1)));
        }
        return pricesValues;
    }

    public DressesPage sortDresses (String parameterToSort) {
        selectItem(sortByList,parameterToSort);
        return this;
    }

    public List<String> getAllNamesOfDressesOnPage() {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < namesOfDresses.size(); i++) {
            names.add(namesOfDresses.get(i).getText());
        }
        return names;
    }
}

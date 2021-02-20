package com.academy.selenide.page;

import com.academy.telesens.lesson6.Subscriber;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SubscribersPage {
    @FindBy(id = "add")
    private SelenideElement formLink;
    @FindBy(id = "contact-edit-id")
    private SelenideElement linkToEditForm;
    @FindBy(css = "a[name='contact-edit-id']")
    private List<SelenideElement> idS;

    @FindBy(css = "tr > td:nth-child(3)")
    private List<SelenideElement> fNames;

    private String fNameByIdXPathTempl = "/tr[td/a[text() = '%d']]/td[3]";

    public FormPage goToFormPage () {
        formLink.click();
        return page(FormPage.class);
    }

    //Может не сработать
    public EditFormPage editSubscriber (int id) {
        linkToEditForm.$(By.linkText(String.valueOf(id)));
        return page(EditFormPage.class);
    }
    public List<Subscriber> getAllSubscribers() {
        List<Subscriber> subscribers = new ArrayList<>();
        for (int i = 0; i < idS.size(); i++) {
            Subscriber subscriber = new Subscriber();
            subscriber.setId(Integer.parseInt(idS.get(i).getText().trim()));
            subscriber.setFirstName(fNames.get(i).text().trim());
        }

        return subscribers;
    }

    public Subscriber getSubscriberById(int id) {
        String fName = $(By.xpath(String.format(fNameByIdXPathTempl, id))).text();
        Subscriber subscriber = new Subscriber();
        subscriber.setFirstName(fName);
        return subscriber;
    }

}

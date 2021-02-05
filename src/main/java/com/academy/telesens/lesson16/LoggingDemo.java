package com.academy.telesens.lesson16;


import com.academy.telesens.lesson5.exc.Person;
import com.academy.telesens.util.PropertyProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggingDemo {
    private static Logger LOG = LoggerFactory.getLogger(LoggingDemo.class);

    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("Vitaly");
        person.setAge(28);
        LOG.info("Info message {}", "data");//ключевая информация
        LOG.error("Error msg");//ошибки
        LOG.debug("Debug msg. Person: {}, age{}",
                person.getFirstName(),person.getAge());//подробности

        PropertyProvider.get("db.url");
    }
}

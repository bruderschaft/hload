package ru.mail.go;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by max on 05.03.14.
 */
public class MainPage {
    private WebDriver webDriver;

    public MainPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void enterText(String query){
        webDriver.findElement(By.id("q")).sendKeys(query);
    }

    public List<String> suggest(String query){
        this.enterText(query);
        return Arrays.asList((webDriver
                .findElement(By.id("go-suggests"))
        .getText().split(" ")));
    }
}

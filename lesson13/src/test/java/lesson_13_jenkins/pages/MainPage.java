package lesson_13_jenkins.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;

public class MainPage {

    private static final SelenideElement searchInput = $(".header-search-input");

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage searchInputClick() {
        searchInput.click();
        return this;
    }

    public MainPage searchInputSetValue(String reponame) {
        searchInput.setValue(reponame);
        return this;
    }

    public MainPage searchInputSubmit() {
        searchInput.submit();
        return this;
    }
}
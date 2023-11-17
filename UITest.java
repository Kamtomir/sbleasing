package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class UITest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kamil\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testSberLeasingCarSelection() {
        driver.get("https://www.google.com");
        // Находим элемент поиска и вводим запрос "СберЛизинг"
        driver.findElement(By.id("input")).sendKeys("СберЛизинг");
        driver.findElement(By.name("btnK")).submit(); // Нажатие на кнопку поиска

        // Код для перехода на сайт СберЛизинг, выбора автомобиля, нажатия кнопки "Показать все предложения" и т.д.

        // Пример проверки выбранной марки автомобиля соответствует марке в общем списке
        // String selectedCarBrand = driver.findElement(By.xpath("xpath для выбранной марки автомобиля")).getText();
        // String carBrandInList = driver.findElement(By.xpath("xpath для списка марок автомобилей")).getText();
        // assertTrue(carBrandInList.contains(selectedCarBrand));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


package day01;

import org.junit.jupiter.api.*;

public class C02_TestNotation {

    @BeforeAll
    public static void setup() {
        System.out.println("Test Sureci baslatiliyor");
    }

    @AfterAll
    public static void teardown(){
        System.out.println("Test Sureci Tamamlandi");
    }

    @BeforeEach
    public void beforeTest(){
        System.out.println("Siradaki Test Calistiriliyor\n");
    }

    @AfterEach
    public void afterTest(){
        System.out.println("\nBir Test Scope'u Tamamlandi. Varsa Diger Scope Calisacak");
    }

    @Test
    public void zeynep(){
        System.out.println("Zeynep Hasret Kirbas\nQA Engineer\n\n");
    }

    @Test
    public void nazli(){
        System.out.println("Nazli Can Kirbas\nSoftware Developer\n\n");
    }

}

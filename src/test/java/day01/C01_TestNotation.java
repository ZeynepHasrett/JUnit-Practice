package day01;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class C01_TestNotation {

    @Test
    public void testC(){
        System.out.println("Test C calisti");
    }

    @Test
    public void testA(){
        System.out.println("Test A calisti");
    }

    @Test @Disabled
    public void testB(){
        System.out.println("Test B calisti");
    }

}

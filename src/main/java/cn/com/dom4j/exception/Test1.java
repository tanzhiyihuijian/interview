package cn.com.dom4j.exception;

import org.junit.Test;

public class Test1 {

    public static void main(String[] args) {

        try {
            try {
                throw new Sneeze();
            }
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        }
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }

    @Test
    public void f1() {




    }







}
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.robson.gomes.SolutionDateFormatter;

public class SolutionDateFormatterTest {
    
    @Test
    public void test1() {
        String retorno = SolutionDateFormatter.formatElegantly(1);
        assertEquals(retorno,"1 second");
    }

    @Test
    public void test2() {
        String retorno = SolutionDateFormatter.formatElegantly(620);
        assertEquals(retorno,"10 minutes and 20 seconds");
    }

    @Test
    public void test3() {
        String retorno = SolutionDateFormatter.formatElegantly(63072040);
        assertEquals(retorno,"2 years and 40 seconds");
    }

    @Test
    public void test4() {
        String retorno = SolutionDateFormatter.formatElegantly(99999);
        assertEquals(retorno,"1 day, 3 hours, 46 minutes and 39 seconds");
    }

    @Test
    public void test5() {
        String retorno = SolutionDateFormatter.formatElegantly(6000);
        assertEquals(retorno,"1 hour and 40 minutes");
    }

    @Test
    public void test6() {
        String retorno = SolutionDateFormatter.formatElegantly(2000);
        assertEquals(retorno,"33 minutes and 20 seconds");
    }

    @Test
    public void test7() {
        String retorno = SolutionDateFormatter.formatElegantly(900);
        assertEquals(retorno,"15 minutes");
    }

    @Test
    public void test8() {
        String retorno = SolutionDateFormatter.formatElegantly(31536000);
        assertEquals(retorno,"1 year");
    }

    
    @Test
    public void test9() {
        String retorno = SolutionDateFormatter.formatElegantly(189216001);
        assertEquals(retorno,"6 years and 1 second");
    }

    
    @Test
    public void test10() {
        String retorno = SolutionDateFormatter.formatElegantly(0);
        assertEquals(retorno,"now");
    }

}

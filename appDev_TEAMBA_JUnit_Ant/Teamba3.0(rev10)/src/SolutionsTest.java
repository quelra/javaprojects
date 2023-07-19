import org.junit.Test;
import static org.junit.Assert.*;


public class SolutionsTest {
    Solutions solutionsTest= new Solutions();

    @Test
    public void main() {

    }

    /**
      * This function test the passwordCheck method 
      * and validates if the given input is successful or not
      */
    @Test
    public void passwordCheck() {
        //Check if the condition is false
        assertFalse(solutionsTest.passwordCheck(new String("12345")));      //Pass
        assertFalse(solutionsTest.passwordCheck(new String("hiHi")));       //Pass
        assertFalse(solutionsTest.passwordCheck(new String("HELLO1")));     //Pass
        //Check if the condition is true
        assertTrue(solutionsTest.passwordCheck(new String("HELLOhi1")));    //Pass
        assertTrue(solutionsTest.passwordCheck(new String("HELLOhi1@")));   //Pass
    }

    /**
      * This function test the luckyTicket method 
      * and validates if the given input is successful or not
      */
    @Test
    public void luckyTicket() {
        //Check if the condition is false
        assertFalse(solutionsTest.luckyTicket(new int[]{2,47}));    //Pass
        assertFalse(solutionsTest.luckyTicket(new int[]{4,4737}));  //Pass
        assertFalse(solutionsTest.luckyTicket(new int[]{4,1347}));  //Pass
        //Check if the condition is true
        assertTrue(solutionsTest.luckyTicket(new int[]{4,4747}));   //Pass
        assertTrue(solutionsTest.luckyTicket(new int[]{4,4774}));   //Pass
    }   

    /**
      * This function test the spyDetected method 
      * and validates if the expected array value is equal 
      * to the actual result based on the provided array values.
      */
    @Test
    public void spyDetected() {
        assertArrayEquals(new int[]{2,1,5,3},solutionsTest.spyDetected(new String[]{"4","4","11 13 11 11","5","1 4 4 4 4","10","3 3 3 3 10 3 3 3 3 3","3","20 20 10"})); //Pass
        assertArrayEquals(new int[]{3,5},solutionsTest.spyDetected(new String[]{"2","4","13 13 11 13","5","6 6 6 6 4"}));   //Pass
        assertArrayEquals(new int[]{3,1},solutionsTest.spyDetected(new String[]{"2","3","8 8 13","4","7 6 6 6"}));  //Pass
        assertArrayEquals(new int[]{5,4,2},solutionsTest.spyDetected(new String[]{"3","7","2 2 2 2 5 2 2","4","6 6 6 8","3","6 9 6"})); //Pass
    }

    /**
      * This function test the boyOrGirl method 
      * and validates if the given input is successful or not
      */
    @Test
    public void boyOrGirl() {
        //Check if the condition is false
        assertFalse(solutionsTest.boyOrGirl(new String("xiaodao")));    //Pass
        //Check if the condition is true
        assertTrue(solutionsTest.boyOrGirl(new String("wjmzbmr")));     //Pass
        assertTrue(solutionsTest.boyOrGirl(new String("sevenkplus")));  //Pass
    }

    /**
      * This function test theSumOf2050 method 
      * and validates if the expected array value is equal 
      * to the actual result based on the provided array values.
      */
    @Test
    public void theSumOf2050() {
        assertArrayEquals((new long[]{-1,1,2,1,2,36}), (solutionsTest.theSumOf2050(new long[]{6,205,2050,4100,20500,22550,Long.parseLong("25308639900")})));    //Pass
        assertArrayEquals((new long[]{-1,-1}), (solutionsTest.theSumOf2050(new long[]{2,5,6})));    //Pass
        assertArrayEquals((new long[]{3}), (solutionsTest.theSumOf2050(new long[]{1,6150})));   //Pass

    }

    /**
      * This function test the splits method 
      * and validates if the expected integer value is equal 
      * to the actual result based on the provided integer value.
      */
    @Test
    public void splits() {
        assertEquals(4, solutionsTest.splits(7));   //Pass
        assertEquals(2, solutionsTest.splits(2));   //Pass
        assertEquals(5, solutionsTest.splits(8));   //Pass
        assertEquals(5, solutionsTest.splits(9));   //Pass
        assertEquals(79, solutionsTest.splits(156));  //Pass
        
    }

     /**
      * This function test the dislikeOfThrees method 
      * and validates if the expected integer value is equal 
      * to the actual result based on the provided integer value.
      */
    @Test
    public void dislikeOfThrees() {
        assertEquals(1, solutionsTest.dislikeOfThrees(1));          //Pass
        assertEquals(2, solutionsTest.dislikeOfThrees(2));          //Pass
        assertEquals(4, solutionsTest.dislikeOfThrees(3));          //Pass
        assertEquals(5, solutionsTest.dislikeOfThrees(4));          //Pass
        assertEquals(7, solutionsTest.dislikeOfThrees(5));          //Pass
        assertEquals(8, solutionsTest.dislikeOfThrees(6));          //Pass
        assertEquals(10, solutionsTest.dislikeOfThrees(7));         //Pass
        assertEquals(11, solutionsTest.dislikeOfThrees(8));         //Pass 
        assertEquals(14, solutionsTest.dislikeOfThrees(9));         //Pass
        assertEquals(1666, solutionsTest.dislikeOfThrees(1000));    //Pass
    }

    /**
      * This function test the watermelon method 
      * and validates if the expected string value is equal 
      * to the actual result based on the provided integer value.
      */
    @Test
    public void watermelon() {
        assertEquals("NO", solutionsTest.watermelon(2));    //Pass
        assertEquals("YES", solutionsTest.watermelon(4));   //Pass
        assertEquals("NO", solutionsTest.watermelon(5));    //Pass
        assertEquals("YES", solutionsTest.watermelon(8));   //Pass
        assertEquals("NO", solutionsTest.watermelon(11));   //Pass
        assertEquals("YES", solutionsTest.watermelon(12));  //Pass
        assertEquals("NO", solutionsTest.watermelon(15));   //Pass
    }

    /**
      * This function test aNewPassword method 
      * and validates if the expected integer value is equal 
      * to the actual result based on the provided integer value.
      */
    @Test
    public void aNewPassword() {
        assertEquals("abab",solutionsTest.aNewPassword(4,2));       //Pass
        assertEquals("abcde",solutionsTest.aNewPassword(5,5));      //Pass
        assertEquals("abcabc",solutionsTest.aNewPassword(6,3));     //Pass
        assertEquals("aa",solutionsTest.aNewPassword(2,1));         //Pass
        assertEquals("abcdabc",solutionsTest.aNewPassword(7,4));    //Pass
    }

    /**
      * This function test the helpFarAwayKingdom method 
      * and validates if the expected array value is equal 
      * to the actual  value provided.
      */
    @Test
    public void helpFarAwayKingdom() {
        assertEquals("0",solutionsTest.helpFarAwayKingdom(0.0));                        //Pass
        assertEquals("1",solutionsTest.helpFarAwayKingdom(1.49));                       //Pass
        assertEquals("3",solutionsTest.helpFarAwayKingdom(2.5));                        //Pass
        assertEquals("3",solutionsTest.helpFarAwayKingdom(2.7182818));                  //Pass
        assertEquals("12345678",solutionsTest.helpFarAwayKingdom(12345678.1));          //Pass
        assertEquals("GOTO Vasilisa.",solutionsTest.helpFarAwayKingdom(123456789.999)); //Pass
    }

    /**
      * This function test the theMiracleAndTheSleeper method 
      * and validates if the expected array value is equal 
      * to the actual array value provided.
      */
    @Test
    public void theMiracleAndTheSleeper() {
        assertArrayEquals(new int[]{0,1,12,499999999}, solutionsTest.theMiracleAndTheSleeper(new String[]{"4","1 1","999999999 1000000000","8 26","1 999999999"})); //Pass
        assertArrayEquals(new int[]{1,37737936,5}, solutionsTest.theMiracleAndTheSleeper(new String[]{"3","2 3","65789 75475874","8 13"}));                         //Pass
        assertArrayEquals(new int[]{3,43,12,499999999,44}, solutionsTest.theMiracleAndTheSleeper(new String[]{"5","6 9","7 88","8 26","4 999999999","7 89"}));      //Pass
        assertArrayEquals(new int[]{16,46}, solutionsTest.theMiracleAndTheSleeper(new String[]{"2","3 34","77 123"}));                                              //Pass
    }

    /**
      * This function test the elections method 
      * and validates if the expected array value is equal 
      * to the actual array value provided.
      */
    @Test
    public void elections() {
        assertArrayEquals(new int[]{1,1,1,66,0,61,5,5,0,0,1001,1001,1000000001,0,1000000001}, solutionsTest.elections(new String[]{"5","0 0 0","10 75 15","13 13 17","1000 0 0","0 1000000000 0"})); //Pass
        assertArrayEquals(new int[]{0,23,40,34,0,50,655,633,0,11,5,0}, solutionsTest.elections(new String[]{"4","45 23 6","23 56 7","1 23 655","2 8 12"}));                                          //Pass
        assertArrayEquals(new int[]{33,0,30,57,52,0,12,0,21}, solutionsTest.elections(new String[]{"3","2 34 5","0 5 56","12 23 3"}));                                                               //Pass
    }
}
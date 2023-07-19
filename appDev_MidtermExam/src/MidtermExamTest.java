import org.junit.Test;
import static org.junit.Assert.*;
public class MidtermExamTest {

    MidtermExam midtermExamTest = new MidtermExam();

    @Test //proper inputs
    public void sortArray(){
      assertArrayEquals(new int[]{5,6,9}, midtermExamTest.sortArray(new int[]{9,6,5}));
      assertArrayEquals(new int[]{2,1,3}, midtermExamTest.sortArray(new int[]{2,3,1}));
    }

    @Test //failure
    public void sortArray2(){
      try {
        midtermExamTest.sortArray(new int[]{});
        fail("Should have thrown an exception");
    } catch (final Exception e) {
        assertTrue(true);
    }
    }

    @Test //empty
    public void sortArray3(){
      assertArrayEquals(new int[]{},midtermExamTest.sortArray(new int[]{}));
    }
}
package com.mycompany.app;
import static org.junit.Assert.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    public void testSortSetting() {

        //int[]res = new int[]{1,1,2,3,3,4,5,5,7,9};
        ArrayList<Integer> arl1 = new ArrayList<Integer>(Arrays.asList(1,3,5,7,9));
        ArrayList<Integer> arl2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,1,2,3,3,4,5,5,7,9));
        ArrayList<Integer> actual = App.mixture(arl1,arl2,'a','c','n','n',0);
        assertTrue(expected.equals(actual));

    }

    public void testDuplicateSetting() {
        ArrayList<Integer> arl1 = new ArrayList<Integer>(Arrays.asList(1,3,5,7,9));
        ArrayList<Integer> arl2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,7,9));
        ArrayList<Integer> actual = App.mixture(arl1,arl2,'a','d','n','n',0);
        assertTrue(expected.equals(actual));
    }

    public void testErrorSetting() {
        ArrayList<Integer> arl1 = null;
        ArrayList<Integer> arl2 = null;
        ArrayList<Integer> expected = null;
        ArrayList<Integer> actual = App.mixture(arl1,arl2,'a','c','n','n',0);
        assertTrue(expected.equals(actual));

        arl1 = null;
        arl2 = null;
        expected = new ArrayList<Integer>();
        actual = App.mixture(arl1,arl2,'a','c','s','n',0);
        assertTrue(expected.equals(actual));
    }

    public void testTransformSetting() {
        ArrayList<Integer> arl1 = new ArrayList<Integer>(Arrays.asList(-1,-3,-5,-7,-9));
        ArrayList<Integer> arl2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,1,2,3,3,4,5,5,7,9));
        ArrayList<Integer> actual = App.mixture(arl1,arl2,'a','c','n','p',0);
        assertTrue(expected.equals(actual));

        arl1 = new ArrayList<Integer>(Arrays.asList(100,300,500,700,900));
        arl2 = new ArrayList<Integer>(Arrays.asList(100,200,300,400,500));
        expected = new ArrayList<Integer>(Arrays.asList(1,1,2,3,3,4,5,5,7,9));
        actual = App.mixture(arl1,arl2,'a','c','n','s',100);
        assertTrue(expected.equals(actual));
    }


}

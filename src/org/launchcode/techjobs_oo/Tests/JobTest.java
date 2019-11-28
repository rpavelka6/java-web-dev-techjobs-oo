package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JobTest {

    Job test_job1;
    Job test_job2;
    Job test_job3;
    Job test_job4;
    Job test_job5;
    Job test_job6;

    @Before
    public void createJobObject() {
        test_job1 = new Job();
        test_job2 = new Job();
        test_job3 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job4 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job5 = new Job("", new Employer("ACME"), new Location("City"), new PositionType("Developer"), new CoreCompetency("Persistence"));
        test_job6 = new Job("", new Employer("ACME"), new Location("City"), new PositionType("Developer"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertEquals(test_job1.getId(), test_job2.getId(), 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue( test_job3 instanceof Job );
//        assertTrue( "Product Tester", test_job3.getName());
        assertTrue( test_job3.getEmployer() instanceof Employer );
        assertTrue( test_job3.getLocation() instanceof Location );
        assertTrue( test_job3.getPositionType() instanceof PositionType );
        assertTrue( test_job3.getCoreCompetency() instanceof CoreCompetency );

        assertEquals( "Product Tester", test_job3.getName());
        assertEquals( "ACME", test_job3.getEmployer().getValue());
        assertEquals( "Desert", test_job3.getLocation().getValue());
        assertEquals( "Quality control", test_job3.getPositionType().getValue());
        assertEquals( "Persistence", test_job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        int firstId = test_job3.getId();
        int secondId = test_job4.getId();
        assertFalse( firstId == secondId );
    }

    @Test
    public void testToString() {

        // Check for String accuracy - both labels and field values
        assertEquals( "\n" +
                "ID: " + test_job3.getId() + "\n" +
                "Name: " + "Product Tester" + "\n" +
                "Employer: " + "ACME" + "\n" +
                "Location: " + "Desert" + "\n" +
                "Position Type: " + "Quality control" + "\n" +
                "Core Competency: " + "Persistence" +
                "\n", test_job3.toString() );

        System.out.println("test_job6: " + test_job6);

        assertEquals( "\n" +
                "ID: " + test_job6.getId() + "\n" +
                "Name: " + "Data not available" + "\n" +
                "Employer: " + "ACME" + "\n" +
                "Location: " + "City" + "\n" +
                "Position Type: " + "Developer" + "\n" +
                "Core Competency: " + "Persistence" +
                "\n", test_job6.toString() );
    }
}


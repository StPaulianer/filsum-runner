package com.filsum.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by katrin on 08.06.17.
 */
public class ParticipationTest {

    @Test
    public void testAgeGroup()  {
        Participation part = new Participation();
        Runner runner = new Runner();

        runner.setGender("m");
        runner.setBirthyear(2009);

        Run run = new Run();
        run.setName("Schülerlauf");
        part.setRunner(runner);
        part.setRun(run);

        String group = part.getCalculateAgeGroup();
        Assert.assertNotNull(group);
    }
}

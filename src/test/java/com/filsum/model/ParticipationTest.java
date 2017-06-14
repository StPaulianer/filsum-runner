package com.filsum.model;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.TemporalAmount;

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
        run.setStartDate(LocalDate.now().minusYears(2));
        part.setRunner(runner);
        part.setRun(run);

        String group = part.getCalculateAgeGroup();
        Assert.assertNotNull(group);
    }
}

package de.cpg.oss.blz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class)
public class BlzValidatorIT {

    @Autowired
    private BlzValidator blzValidator;

    @Test
    public void testValidateBlz() {
        assertTrue(blzValidator.validateBlz("70010080"));
    }

    @Test
    public void testValidateAccountNr() {
        assertFalse(blzValidator.validateAccountNr("70010080", "23923412"));
    }
}

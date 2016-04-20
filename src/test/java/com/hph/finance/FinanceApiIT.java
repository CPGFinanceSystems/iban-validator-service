package com.hph.finance;

import com.hph.finance.data.Importer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FinanceApi.class)
public class FinanceApiIT {

    @Autowired
    private Importer importer;

    @Test
    public void testLoad() {
        importer.load();
    }
}

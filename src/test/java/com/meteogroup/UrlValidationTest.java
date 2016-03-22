package com.meteogroup;

import com.meteogroup.urlAnalyzer.analyzer.UrlAnalyzer;
import com.meteogroup.urlAnalyzer.analyzer.UrlAnalyzerFactory;
import com.meteogroup.urlAnalyzer.model.UrlAnalyzerResponse;
import org.junit.Assert;
import org.junit.Test;

public class UrlValidationTest {

    private final UrlAnalyzer analyzer = UrlAnalyzerFactory.get();

    @Test
    public void testURLValidation() {

        String url = "http://www.google.com/";

        UrlAnalyzerResponse response = analyzer.analyze(url);

        Assert.assertTrue("Validation should succeed", response.isSuccess());

    }

    @Test
    public void testEmptyURLValidation() {

        String url = "";

        UrlAnalyzerResponse response = analyzer.analyze(url);

        Assert.assertFalse("Validation should fail", response.isSuccess());
        System.out.println("Testing emptyURL Validation result:" + response.getErrorMessage());

    }

    @Test
    public void testBadURLValidation() {

        String url = "www.goo.zo";

        UrlAnalyzerResponse response = analyzer.analyze(url);

        Assert.assertFalse("Validation should fail", response.isSuccess());
        System.out.println("Testing BadURl Validation result:" + response.getErrorMessage());
    }
}

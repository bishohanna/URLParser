package com.meteogroup;

import com.meteogroup.urlAnalyzer.analyzer.UrlAnalyzer;
import com.meteogroup.urlAnalyzer.analyzer.UrlAnalyzerFactory;
import com.meteogroup.urlAnalyzer.model.UrlAnalyzerResponse;
import org.junit.Assert;
import org.junit.Test;

public class UrlDomainReaderTest {


    private final UrlAnalyzer analyzer = UrlAnalyzerFactory.get();

    @Test
    public void testDomainReader() {

        String url = "http://www.google.com/";

        UrlAnalyzerResponse response = analyzer.analyze(url);

        Assert.assertEquals("www.google.com", response.getDomain());

    }

    @Test
    public void testWrongDomainReader() {

        String url = "http://";

        UrlAnalyzerResponse response = analyzer.analyze(url);

        Assert.assertFalse("Domain must be found", response.isSuccess());

    }

    @Test
    public void testLongUrlDomainReader() {

        String url = "http://www.google.com/findMe?hidden=true";

        UrlAnalyzerResponse response = analyzer.analyze(url);

        Assert.assertEquals("www.google.com", response.getDomain());

    }
}

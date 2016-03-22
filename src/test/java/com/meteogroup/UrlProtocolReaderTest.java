package com.meteogroup;

import com.meteogroup.urlAnalyzer.analyzer.UrlAnalyzer;
import com.meteogroup.urlAnalyzer.analyzer.UrlAnalyzerFactory;
import com.meteogroup.urlAnalyzer.model.UrlAnalyzerResponse;
import org.junit.Assert;
import org.junit.Test;

public class UrlProtocolReaderTest {


    private final UrlAnalyzer analyzer = UrlAnalyzerFactory.get();

    @Test
    public void testProtocolReader() {

        String url = "http://www.google.com/";

        UrlAnalyzerResponse response = analyzer.analyze(url);

        Assert.assertEquals("http", response.getProtocol());

    }

    @Test
    public void testDefaultProtocolReader() {

        String url = "www.google.com/";

        UrlAnalyzerResponse response = analyzer.analyze(url);

        Assert.assertEquals("http", response.getProtocol());

    }

    @Test
    public void testWrongProtocolReader() {

        String url = "ttps://www.google.com/";

        UrlAnalyzerResponse response = analyzer.analyze(url);

        Assert.assertFalse("Operation should fail", response.isSuccess());

    }
}

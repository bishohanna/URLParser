package com.meteogroup;

import com.meteogroup.urlAnalyzer.analyzer.UrlAnalyzer;
import com.meteogroup.urlAnalyzer.analyzer.UrlAnalyzerFactory;
import com.meteogroup.urlAnalyzer.model.UrlAnalyzerResponse;
import org.junit.Assert;
import org.junit.Test;

public class UrlPathReaderTest {

    private final UrlAnalyzer analyzer = UrlAnalyzerFactory.get();

    @Test
    public void testURLPathReader() {

        String url = "http://www.google.com/abc-r/jip.k/hu/";

        UrlAnalyzerResponse response = analyzer.analyze(url);

        Assert.assertEquals("abc-r/jip.k/hu", response.getPath());

    }

    @Test
    public void testURLPathWithParams() {

        String url = "http://www.google.com/abc-r/jip.k/hu?ki=123&hik=0";

        UrlAnalyzerResponse response = analyzer.analyze(url);

        Assert.assertEquals("abc-r/jip.k/hu", response.getPath());

    }
}

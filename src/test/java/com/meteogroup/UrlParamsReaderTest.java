package com.meteogroup;

import com.meteogroup.urlAnalyzer.analyzer.UrlAnalyzer;
import com.meteogroup.urlAnalyzer.analyzer.UrlAnalyzerFactory;
import com.meteogroup.urlAnalyzer.model.UrlAnalyzerResponse;
import org.junit.Assert;
import org.junit.Test;

public class UrlParamsReaderTest {


    private final UrlAnalyzer analyzer = UrlAnalyzerFactory.get();

    @Test
    public void testURLParamsReader() {

        String url = "http://www.google.com/hitme?high=1&low=false&zik=";

        UrlAnalyzerResponse response = analyzer.analyze(url);

        Assert.assertTrue("Params should be parsed", response.getUrlParameters().entrySet().size() == 2);

    }
}

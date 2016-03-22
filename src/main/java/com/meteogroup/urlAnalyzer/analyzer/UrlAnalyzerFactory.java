package com.meteogroup.urlAnalyzer.analyzer;


public final class UrlAnalyzerFactory {

    private final static UrlAnalyzer ANALYZER = new UrlAnalyzerContext();

    private UrlAnalyzerFactory() {
        //construction not allowed
    }


    public static UrlAnalyzer get() {
        return ANALYZER;
    }
}

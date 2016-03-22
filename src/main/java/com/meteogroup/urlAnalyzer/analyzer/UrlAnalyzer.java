package com.meteogroup.urlAnalyzer.analyzer;


import com.meteogroup.urlAnalyzer.model.UrlAnalyzerResponse;

/**
 * Analyse URL to its components
 */
public interface UrlAnalyzer {


    /**
     * Analyse URL to its components
     *
     * @param url url to analyze
     * @return analysis response, containing protocol,host,path .. etc
     */
    UrlAnalyzerResponse analyze(String url);

}

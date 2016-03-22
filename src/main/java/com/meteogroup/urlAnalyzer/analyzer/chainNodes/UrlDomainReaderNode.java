package com.meteogroup.urlAnalyzer.analyzer.chainNodes;

import com.meteogroup.urlAnalyzer.analyzer.UrlAnalyzerChainNode;
import com.meteogroup.urlAnalyzer.model.UrlAnalyzerResponse;

public class UrlDomainReaderNode extends UrlAnalyzerChainNode {

    @Override
    protected void process(String url, UrlAnalyzerResponse response) {

        String urlWithoutParams =
                response.getModifiedUrl()
                        .substring(0, response.getModifiedUrl().indexOf("?") < 0 ?
                                response.getModifiedUrl().length() : response.getModifiedUrl().indexOf("?"));

        String normalizeUrl = urlWithoutParams.replace("//", "/");//replace double slash with one

        String[] parts = normalizeUrl.split("/");

        String domainName = parts[1].toLowerCase();
        response.setDomain(domainName);

    }
}

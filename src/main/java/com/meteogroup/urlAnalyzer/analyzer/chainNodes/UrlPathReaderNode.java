package com.meteogroup.urlAnalyzer.analyzer.chainNodes;

import com.meteogroup.urlAnalyzer.analyzer.UrlAnalyzerChainNode;
import com.meteogroup.urlAnalyzer.model.UrlAnalyzerResponse;

public class UrlPathReaderNode extends UrlAnalyzerChainNode {

    @Override
    protected void process(String url, UrlAnalyzerResponse response) {

        String urlWithoutParams =
                response.getModifiedUrl()
                        .substring(0, response.getModifiedUrl().indexOf("?") < 0 ?
                                response.getModifiedUrl().length() : response.getModifiedUrl().indexOf("?"));

        String[] parts = urlWithoutParams
                .replace("//", "/")
                .split("/");

        if (parts.length > 2) { //has path

            StringBuilder pathBuilder = new StringBuilder();

            for (int i = 2; i < parts.length; i++) {
                pathBuilder.append(parts[i])
                        .append((i != parts.length - 1) ? "/" : "");
            }

            response.setPath(pathBuilder.toString());
        }


    }
}

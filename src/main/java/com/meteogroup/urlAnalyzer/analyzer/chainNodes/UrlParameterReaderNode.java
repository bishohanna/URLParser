package com.meteogroup.urlAnalyzer.analyzer.chainNodes;

import com.meteogroup.urlAnalyzer.analyzer.UrlAnalyzerChainNode;
import com.meteogroup.urlAnalyzer.model.UrlAnalyzerResponse;

public class UrlParameterReaderNode extends UrlAnalyzerChainNode {


    @Override
    protected void process(String url, UrlAnalyzerResponse response) {

        String[] parts = url.split("\\?");

        if (parts.length == 2) {//has parameters

            String paramsString = parts[1];
            String[] paramsSeparated = paramsString.split("&");

            for (String parameter : paramsSeparated) {

                String[] parameterSplit = parameter.split("=");

                if (parameterSplit.length == 2) {
                    response.addParameter(parameterSplit[0], parameterSplit[1]);
                }
            }
        }

    }
}

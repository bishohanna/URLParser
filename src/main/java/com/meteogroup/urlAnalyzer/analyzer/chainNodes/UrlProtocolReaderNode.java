package com.meteogroup.urlAnalyzer.analyzer.chainNodes;

import com.meteogroup.urlAnalyzer.analyzer.UrlAnalyzerChainNode;
import com.meteogroup.urlAnalyzer.model.UrlAnalyzerResponse;

public class UrlProtocolReaderNode extends UrlAnalyzerChainNode {

    private final String DEFAULT_PROTOCOL = "http";

    @Override
    protected void process(String url, UrlAnalyzerResponse response) {

        String[] parts = url.split("://");

        if (parts.length == 1) {//protocol not found
            response.setProtocol(DEFAULT_PROTOCOL)
                    .setModifiedUrl(DEFAULT_PROTOCOL.concat("://").concat(response.getModifiedUrl()));
        } else {
            String protocol = parts[0].toLowerCase();
            response.setProtocol(protocol);
        }
    }
}

package com.meteogroup.urlAnalyzer.analyzer;


import com.meteogroup.urlAnalyzer.analyzer.chainNodes.*;
import com.meteogroup.urlAnalyzer.model.UrlAnalyzerResponse;

final class UrlAnalyzerContext implements UrlAnalyzer {

    private final UrlAnalyzerChainNode initialNode;


    UrlAnalyzerContext() {

        //init context
        initialNode = initialize();

    }


    @Override
    public UrlAnalyzerResponse analyze(String url) {

        //1 - create response object
        UrlAnalyzerResponse response = new UrlAnalyzerResponse(url);

        //2- initialize processing
        if (initialNode != null) {
            initialNode.handle(url, response);
        }

        return response;
    }


    /**
     * initializes the sequence of nodes of context
     *
     * @return the initial node
     */
    private UrlAnalyzerChainNode initialize() {

        UrlAnalyzerChainNode initialNode = new UrlValidatorNode();

        initialNode
                .setNextNode(new UrlProtocolReaderNode())
                .setNextNode(new UrlDomainReaderNode())
                .setNextNode(new UrlPathReaderNode())
                .setNextNode(new UrlPathReaderNode())
                .setNextNode(new UrlParameterReaderNode());


        return initialNode;
    }
}

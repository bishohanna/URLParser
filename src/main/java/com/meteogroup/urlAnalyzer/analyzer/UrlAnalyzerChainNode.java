package com.meteogroup.urlAnalyzer.analyzer;

import com.meteogroup.urlAnalyzer.model.UrlAnalyzerResponse;

public abstract class UrlAnalyzerChainNode {

    private UrlAnalyzerChainNode nextChainNode;

    /**
     * Handles the node logic
     *
     * @param url      url to get info. from
     * @param response response to modify
     */
    public void handle(String url, UrlAnalyzerResponse response) {

        //1 - Process
        process(url, response);

        //2 - validate response , break if this step fails
        if (!response.isSuccess()) {
            return;
        }

        //3 - pass to next node
        if (nextChainNode != null) {
            nextChainNode.handle(url, response);
        }
    }


    /**
     * Do the main processing logic of the chain node
     *
     * @param url      url to get info. from
     * @param response response to modify
     */
    protected abstract void process(String url, UrlAnalyzerResponse response);


    /**
     * Sets the next node on the chain to be called after finishing this node's execution
     *
     * @param nextChainNode next node
     * @return the next node if not null, or this node if the next is null
     */
    public <T extends UrlAnalyzerChainNode> T setNextNode(T nextChainNode) {

        if (nextChainNode != null) {
            this.nextChainNode = nextChainNode;

            return nextChainNode;
        }

        return (T) this;
    }
}

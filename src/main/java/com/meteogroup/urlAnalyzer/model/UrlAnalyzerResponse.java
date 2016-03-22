package com.meteogroup.urlAnalyzer.model;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UrlAnalyzerResponse implements Serializable {


    private boolean success;
    private String errorMessage;

    private String modifiedUrl;//basically main url with correct format if necessary
    private String protocol;
    private String domain;
    private String path;
    private Map<String, String> urlParameters;


    public UrlAnalyzerResponse(String modifiedUrl) {
        this.success = true;//initially the response succeeds
        this.modifiedUrl = modifiedUrl;
        this.urlParameters = new HashMap<>();
    }

    public boolean isSuccess() {
        return success;
    }

    public UrlAnalyzerResponse setSuccess(boolean success) {
        this.success = success;

        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public UrlAnalyzerResponse setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;

        return this;
    }

    public String getProtocol() {
        return protocol;
    }

    public UrlAnalyzerResponse setProtocol(String protocol) {
        this.protocol = protocol;

        return this;
    }

    public String getDomain() {
        return domain;
    }

    public UrlAnalyzerResponse setDomain(String domain) {
        this.domain = domain;

        return this;
    }

    public String getPath() {
        return path;
    }

    public UrlAnalyzerResponse setPath(String path) {
        this.path = path;

        return this;
    }

    public String getModifiedUrl() {
        return modifiedUrl;
    }

    public UrlAnalyzerResponse setModifiedUrl(String modifiedUrl) {
        this.modifiedUrl = modifiedUrl;

        return this;
    }

    public Map<String, String> getUrlParameters() {
        return urlParameters;
    }

    public UrlAnalyzerResponse addParameter(String key, String value) {
        if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
            urlParameters.put(key, value);
        }

        return this;
    }
}

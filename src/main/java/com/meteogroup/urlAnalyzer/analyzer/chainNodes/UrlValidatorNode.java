package com.meteogroup.urlAnalyzer.analyzer.chainNodes;

import com.meteogroup.urlAnalyzer.analyzer.UrlAnalyzerChainNode;
import com.meteogroup.urlAnalyzer.model.UrlAnalyzerResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlValidatorNode extends UrlAnalyzerChainNode {

    private final String URL_REGEX = "((https?|ftp|gopher|telnet|file):((//)|(\\\\\\\\))+[\\\\w\\\\d:#@%/;$()~_?\\\\+-=\\\\\\\\\\\\.&]*)";
    private final Pattern URL_PATTERN;

    public UrlValidatorNode() {

        URL_PATTERN = Pattern.compile(URL_REGEX, Pattern.CASE_INSENSITIVE);
    }

    @Override
    protected void process(String url, UrlAnalyzerResponse response) {

        //validate null
        if (StringUtils.isBlank(url)) {
            response.setSuccess(false).setErrorMessage("URL should not be empty");
            return;
        }

        //validate form
        Matcher matcher = URL_PATTERN.matcher(url);
        boolean urlValid = matcher.find();
        if (!urlValid) {
            response.setSuccess(false).setErrorMessage("URL has an invalid format");
            return;
        }

    }
}

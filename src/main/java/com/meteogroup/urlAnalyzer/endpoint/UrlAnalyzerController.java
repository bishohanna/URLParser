package com.meteogroup.urlAnalyzer.endpoint;


import com.meteogroup.urlAnalyzer.analyzer.UrlAnalyzer;
import com.meteogroup.urlAnalyzer.analyzer.UrlAnalyzerFactory;
import com.meteogroup.urlAnalyzer.model.UrlAnalyzerResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlAnalyzerController {


    private final UrlAnalyzer analyzer;

    public UrlAnalyzerController() {

        //get analyzer
        analyzer = UrlAnalyzerFactory.get();
    }

    @RequestMapping("/url/analyze")
    public UrlAnalyzerResponse analyzeURL(@RequestParam("url") String url) {
        return analyzer.analyze(url);
    }

}

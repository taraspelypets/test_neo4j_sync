package org.example.n10s;

import java.util.Map;

public interface NeosemanticsProcedures {

    Map<String, Object> importFetch(String url, String format, Map<String, Object> optionalParams);

    Map<String, Object> importInline(String inlineRDF, String format, Map<String, Object> optionalParams);

    Map<String, Object> deleteFetch(String url, String format, Map<String, Object> optionalParams);

    Map<String, Object> deleteInline(String inlineRDF, String format, Map<String, Object> optionalParams);
}

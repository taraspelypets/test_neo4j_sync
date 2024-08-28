package org.example.n10s.client;

import lombok.RequiredArgsConstructor;
import org.example.n10s.NeosemanticsProcedures;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NeosemanticsProceduresClient implements NeosemanticsProcedures {

    private final Neo4jClient client;

    private static final String IMPORT_FETCH_QUERY= """
        CALL n10s.rdf.import.fetch($url,$format,$params);
        """;
    @Override
    public Map<String, Object> importFetch(String url, String format, Map<String, Object> optionalParams){
        return client.query(IMPORT_FETCH_QUERY).bindAll(Map.of(
                        "url", url,
                        "format", format,
                        "params", Optional.ofNullable(optionalParams).orElse(Map.of())))
                .fetch().first()
                .orElseThrow();
    }

    private static final String IMPORT_INLINE_QUERY= """
        CALL n10s.rdf.import.inline($inlineRDF,$format,$params);
        """;
    @Override
    public Map<String, Object> importInline(String inlineRDF, String format, Map<String, Object> optionalParams){
        return client.query(IMPORT_INLINE_QUERY)
                .bindAll(Map.of(
                        "inlineRDF", inlineRDF,
                        "format", format,
                        "params", Optional.ofNullable(optionalParams).orElse(Map.of())))
                .fetch().first()
                .orElseThrow();
    }

    private static final String DELETE_FETCH_QUERY= """
        CALL n10s.rdf.delete.fetch($url,$format,$params);
        """;
    @Override
    public Map<String, Object> deleteFetch(String url, String format, Map<String, Object> optionalParams){
        return client.query(DELETE_FETCH_QUERY)
                .bindAll(Map.of(
                        "url", url,
                        "format", format,
                        "params", Optional.ofNullable(optionalParams).orElse(Map.of())))
                .fetch().first()
                .orElseThrow();
    }

    private static final String DELETE_INLINE_QUERY= """
        CALL n10s.rdf.delete.inline($inlineRDF,$format,$params);
        """;
    @Override
    public Map<String, Object> deleteInline(String inlineRDF, String format, Map<String, Object> optionalParams){
        return client.query(DELETE_INLINE_QUERY)
                .bindAll(Map.of(
                        "inlineRDF", inlineRDF,
                        "format", format,
                        "params", Optional.ofNullable(optionalParams).orElse(Map.of())))
                .fetch().first()
                .orElseThrow();
    }
}

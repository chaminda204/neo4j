package com.chaminda.neo4j.example.rest;

import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;



public abstract class AbstractRestClient<T> {

    //@Autowired
    private RestTemplate restTemplate = new RestTemplate();

    protected String getJSON(final String apiEndPoint, final String requestMappingUrl, final MultiValueMap<String, String> vars) {
        String response = null;
        try {
            final UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(apiEndPoint).queryParams(vars).build();
            final String url = uriComponents.toString();

            response = restTemplate.getForEntity(url, String.class).getBody();

        } catch (final Exception ex) {

        }
        return response;
    }


}

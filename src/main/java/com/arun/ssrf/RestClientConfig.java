package com.arun.ssrf;

import org.springframework.boot.http.client.ClientHttpRequestFactoryBuilder;
import org.springframework.boot.http.client.HttpClientSettings;
import org.springframework.boot.http.client.InetAddressFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient restClient() {
        return RestClient.builder().build();
    }

    @Bean
    public RestClient protectedRestClient() {

        InetAddressFilter filter =
                InetAddressFilter.externalAddresses();

        HttpClientSettings settings =
                HttpClientSettings.defaults()
                        .withInetAddressFilter(filter);

        ClientHttpRequestFactory requestFactory =
                ClientHttpRequestFactoryBuilder.jdk()
                        .build(settings);

        return RestClient.builder()
                .requestFactory(requestFactory)
                .build();
    }


}

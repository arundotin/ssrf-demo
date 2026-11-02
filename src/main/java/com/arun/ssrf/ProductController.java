package com.arun.ssrf;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@RestController
@RequestMapping("/api/{version}/products")
public class ProductController {

    private final RestClient restClient;
    private final RestClient protectedRestClient ;

    public ProductController(RestClient restClient, RestClient protectedRestClient) {
        this.restClient = restClient ;
        this.protectedRestClient = protectedRestClient ;
    }

    @PostMapping(version = "v1")
    public ProductResponse createProductV1(@RequestBody ProductRequest request) {

        // fetches the caller-supplied URL

        // V1 trusts the supplied URL and start to fetch the caller-supplied URL

        restClient.get()
                .uri(request.imageUrl())
                .retrieve()
                .toBodilessEntity() ;

        return new ProductResponse(
                UUID.randomUUID(),
                request.name(),
                request.price(),
                request.imageUrl()
        );
    }

    @PostMapping(version = "v2")
    public ProductResponse createProductV2(@RequestBody ProductRequest request) {



        // fetches the caller-supplied URL

        // V2 calls the supplied URL through protected Rest Client

        protectedRestClient.get()
                .uri(request.imageUrl())
                .retrieve()
                .toBodilessEntity() ;

        return new ProductResponse(
                UUID.randomUUID(),
                request.name(),
                request.price(),
                request.imageUrl()
        );
    }

}

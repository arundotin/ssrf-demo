package com.arun.ssrf;

import java.math.BigDecimal;

public record ProductRequest(String name, BigDecimal price, String imageUrl) {
}

package com.arun.ssrf;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponse(UUID id, String name, BigDecimal price, String imageUrl) {
}

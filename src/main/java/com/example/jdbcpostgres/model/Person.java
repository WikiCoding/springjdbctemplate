package com.example.jdbcpostgres.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Person(Integer id, @JsonProperty("name") String name) {
}

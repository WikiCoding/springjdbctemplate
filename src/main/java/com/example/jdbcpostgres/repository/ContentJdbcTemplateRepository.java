package com.example.jdbcpostgres.repository;

import com.example.jdbcpostgres.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ContentJdbcTemplateRepository {
    private final JdbcTemplate jdbcTemplate;

    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Person(rs.getInt("id"), rs.getString("name"));
    }

    public List<Person> getAllPeople() {
        String query = "SELECT * FROM public.\"Person\"";
        List<Person> people = jdbcTemplate.query(query, ContentJdbcTemplateRepository::mapRow);
        return people;
    }

    public void insertPerson(String name) {
        String query = "INSERT INTO public.\"Person\" (name) VALUES (?)";
        jdbcTemplate.update(query, name);
    }
}

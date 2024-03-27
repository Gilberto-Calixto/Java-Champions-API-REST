package com.dev.santander.adapters;

import com.dev.santander.domain.model.Champions;
import com.dev.santander.domain.ports.ChampionsRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//camada de persistência de dados

@Repository
public class ChampionsjdbcRepository implements ChampionsRepository {

    private final JdbcTemplate JdbcTemplate;
    private final RowMapper<Champions> rowMapper;

    //busca efetivba no banco de dados
    public ChampionsjdbcRepository(JdbcTemplate jdbcTemplate) {
        this.JdbcTemplate = jdbcTemplate;
        this.rowMapper = (rs, rowNum) -> new Champions(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getString("lore"),
                rs.getString("imgUrl")
        );

    }

    @Override
    public List<Champions> findAll() {
        return JdbcTemplate.query("SELECT * FROM CHAMPIONS", rowMapper);
    }

    @Override
    public Optional<Champions> findById(long id) {
        //passar comando sql
        String sql = "SELECT * FROM CHAMPIONS WHERE ID = ?";
        Champions champion = JdbcTemplate.queryForObject(sql, rowMapper,id);
        return Optional.ofNullable(champion);
    }
}

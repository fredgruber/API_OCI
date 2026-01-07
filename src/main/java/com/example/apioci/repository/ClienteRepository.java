package com.example.apioci.repository;

import com.example.apioci.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class ClienteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cliente> consultarClientes() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_CLIENTES")
                .withProcedureName("PRC_CONSULTAR_CLIENTES")
                .returningResultSet("P_CURSOR", new ClienteRowMapper());

        Map<String, Object> out = simpleJdbcCall.execute();

        @SuppressWarnings("unchecked")
        List<Cliente> clientes = (List<Cliente>) out.get("P_CURSOR");

        return clientes != null ? clientes : Collections.emptyList();
    }

    public void bloquearCliente(String cpf) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_CLIENTES")
                .withProcedureName("PRC_BLOQUEAR_CLIENTE");

        simpleJdbcCall.execute(Map.of("P_CPF", cpf));
    }

    public void desbloquearCliente(String cpf) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_CLIENTES")
                .withProcedureName("PRC_DESBLOQUEAR_CLIENTE");

        simpleJdbcCall.execute(Map.of("P_CPF", cpf));
    }

    private static class ClienteRowMapper implements RowMapper<Cliente> {
        @Override
        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
            Cliente cliente = new Cliente();
            cliente.setCpf(rs.getString("CPF"));
            cliente.setNome(rs.getString("NOME"));
            cliente.setInvestimento(rs.getString("INVESTIMENTO"));
            cliente.setValor(rs.getBigDecimal("VALOR"));
            cliente.setStatus(rs.getString("STATUS"));
            return cliente;
        }
    }
}

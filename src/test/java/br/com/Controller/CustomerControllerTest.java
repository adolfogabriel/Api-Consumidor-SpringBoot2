package br.com.Controller;

import br.com.model.CustumerRequest;
import br.com.model.Retorno;
import br.com.processors.CustomerProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerProcessor service;


    @Test
    void CriarConsumidor() throws Exception {

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1984-08-12");
        java.sql.Date d = new java.sql.Date(date.getTime());
        CustumerRequest post = new CustumerRequest();
        post.setCidade("brasilia");
        post.setEndereco("SQS 410 BL N");
        post.setGenero("m");
        post.setNome("adolfo gabriel");
        post.setSobreNome("capparelli");
        post.setNumCpf("72117567188");
        post.setUf("df");
        post.setDthNascimento(d);
        String json = objectMapper.writeValueAsString(post);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/v2/consumidor/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    void listarTodos() throws Exception {
        Retorno ret = new Retorno();
        mockMvc.perform(get("/v2/consumidor/")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(ret)))
                .andExpect(status().isOk());
    }

    @Test
    void ObterPorId() throws Exception {
        Retorno ret = new Retorno();
        mockMvc.perform(get("/v2/consumidor/").param("id", "")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(ret)))
                .andExpect(status().isOk());
    }

    @Test
    void ObterPorcpf() throws Exception {
        Retorno ret = new Retorno();
        mockMvc.perform(get("/v2/consumidor/").param("cpf", "")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(ret)))
                .andExpect(status().isOk());
    }

    @Test
    void Alterar() throws Exception {
        Retorno ret = new Retorno();
        mockMvc.perform(put("/v2/consumidor/").param("id", "87")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(ret)))
                .andExpect(status().isOk());
    }

    @Test
    void Remover() throws Exception {
        Retorno ret = new Retorno();
        mockMvc.perform(delete("/v2/consumidor/" + 87)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(ret)))
                .andExpect(status().isOk());
    }

}
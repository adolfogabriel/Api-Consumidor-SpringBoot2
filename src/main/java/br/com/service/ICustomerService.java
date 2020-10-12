package br.com.service;

import br.com.entity.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    ResponseEntity<Customer> findbyId(long id);

    ResponseEntity<Customer> findCpf(String Cpf);

    Long Save(Customer customer);

    ResponseEntity<Customer> Alterar(Customer customer);

    ResponseEntity<Object> Deletar(Long Id);
}

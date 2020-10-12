package br.com.repositorio;


import br.com.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepositorio extends JpaRepository<Customer, Long> {

    Optional<Customer> findByNumCpf(String cpf);
}

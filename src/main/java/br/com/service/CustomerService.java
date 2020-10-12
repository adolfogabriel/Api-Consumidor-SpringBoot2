package br.com.service;


import br.com.entity.Customer;
import br.com.repositorio.CustomerRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepositorio repositorio;

    @Override
    public List<Customer> findAll() {
        List<Customer> retorno = repositorio.findAll();
        return retorno;
    }

    @Override
    public ResponseEntity<Customer> findbyId(long id) {
        return repositorio.findById(id)
                .map(x -> ResponseEntity.ok().body(x))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Customer> findCpf(String Cpf) {
        return repositorio.findByNumCpf(Cpf)
                .map(x -> ResponseEntity.ok().body(x))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public Long Save(Customer customer) {
        return repositorio.save(customer).getId();
    }

    @Override
    public ResponseEntity<Customer> Alterar(Customer customer) {
        return repositorio.findById(customer.getId())
                .map(x -> {
                    x.setCidade(customer.getCidade());
                    x.setEndereco(customer.getEndereco());
                    x.setSobreNome(customer.getSobreNome());
                    x.setGenero(customer.getGenero());
                    x.setNome(customer.getNome());
                    x.setNumCpf(customer.getNumCpf());
                    x.setDthNascimento(customer.getDthNascimento());
                    Customer retorno = repositorio.save(x);
                    return ResponseEntity.ok().body(x);
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Object> Deletar(Long id) {
        return repositorio.findById(id)
                .map(x -> {
                    repositorio.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}

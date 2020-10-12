package br.com.processors;

import br.com.entity.Customer;
import br.com.model.CustomerDTO;
import br.com.model.CustumerRequest;
import br.com.model.Retorno;
import br.com.service.ICustomerService;
import com.google.common.base.Strings;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class CustomerProcessor {

    @Autowired
    private ICustomerService customerservice;

    public Retorno ListarTodos() {
        ModelMapper modelMapper = new ModelMapper();
        Retorno retorno = new Retorno();

        try {
            retorno.setSuccess(true);
            retorno.setData(Arrays.asList(modelMapper.map(customerservice.findAll(), CustomerDTO[].class)));

        } catch (Exception e) {
            retorno.setSuccess(false);
            retorno.setData("Erro ao listar consumidor");
        }
        return retorno;
    }

    public Retorno ObterPorId(long id) {
        Retorno retorno = new Retorno();
        try {
            ResponseEntity<Customer> res = customerservice.findbyId(id);
            if (res.getStatusCodeValue() == 200) {
                retorno.setSuccess(true);
                retorno.setData(res.getBody());
            } else {
                retorno.setSuccess(false);
                retorno.setData("Consumidor não encontrado");
            }
        } catch (Exception e) {
            retorno.setSuccess(false);
            retorno.setData("Erro ao obter Consumidor");
        }
        return retorno;
    }

    public Retorno ObterPorCpf(String cpf) {
        Retorno retorno = new Retorno();
        try {
            ResponseEntity<Customer> res = customerservice.findCpf(cpf);
            if (res.getStatusCodeValue() == 200) {
                retorno.setSuccess(true);
                retorno.setData(res.getBody());
            } else {
                retorno.setSuccess(false);
                retorno.setData("Consumidor não encontrado");
            }
        } catch (Exception e) {
            retorno.setSuccess(false);
            retorno.setData("Erro ao obter Consumidor");
        }
        return retorno;
    }

    public Retorno CriarConsumidor(CustumerRequest customer) {
        ModelMapper modelMapper = new ModelMapper();
        Retorno retorno = new Retorno();
        try {
            if (VerificarCpf(customer.getNumCpf())) {
                Customer dados = modelMapper.map(customer, Customer.class);
                dados.setCidade(dados.getCidade().toUpperCase());
                dados.setEndereco(dados.getEndereco().toUpperCase());
                dados.setGenero(dados.getGenero().toUpperCase());
                dados.setSobreNome(dados.getSobreNome().toUpperCase());
                dados.setUf(dados.getUf().toUpperCase());
                dados.setNome(dados.getNome().toUpperCase());
                dados.setNumCpf(dados.getNumCpf().toUpperCase());
                retorno.setData(customerservice.Save(dados));
                retorno.setSuccess(true);
            } else {
                retorno.setSuccess(false);
                retorno.setData("Cpf já existente ou nulo");
            }
        } catch (Exception e) {
            retorno.setSuccess(false);
            retorno.setData("Erro ao cadastrar consumidor");
        }
        return retorno;
    }

    public Retorno AlterarConsumidor(CustomerDTO customer) {
        ModelMapper modelMapper = new ModelMapper();
        Retorno retorno = new Retorno();
        try {
            Customer dados = modelMapper.map(customer, Customer.class);
            ResponseEntity<Customer> res = customerservice.Alterar(dados);
            if (res.getStatusCodeValue() == 200) {
                retorno.setSuccess(true);
                retorno.setData(res.getBody());
            } else {
                retorno.setSuccess(false);
                retorno.setData("Consumidor não encontrado");
            }
        } catch (Exception e) {
            retorno.setSuccess(false);
            retorno.setData("Erro ao alterar Consumidor");
        }
        return retorno;
    }

    public Retorno DeletarConsumidor(Long id) {
        Retorno retorno = new Retorno();
        try {
            ResponseEntity<Object> res = customerservice.Deletar(id);
            if (res.getStatusCodeValue() == 200) {
                retorno.setSuccess(true);
                retorno.setData(id);
            } else {
                retorno.setSuccess(false);
                retorno.setData("Consumidor não encontrado");
            }
        } catch (Exception e) {
            retorno.setSuccess(false);
            retorno.setData("Erro ao remover Consumidor");
        }
        return retorno;
    }

    private Boolean VerificarCpf(String cpf) {
        Boolean retorno = false;
        try {
            retorno = customerservice.findCpf(cpf).getStatusCodeValue() == 404;
        } catch (Exception e) {

        }
        return retorno;
    }

}

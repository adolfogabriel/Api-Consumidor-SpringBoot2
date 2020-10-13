package br.com.Controller;


import br.com.model.CustomerDTO;
import br.com.model.CustumerRequest;
import br.com.model.Retorno;
import br.com.processors.CustomerProcessor;
import br.com.service.ICustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v2/consumidor/")
public class CustomerController {

    @Autowired
    private ICustomerService customerservice;

    @Autowired
    private CustomerProcessor customerprocessor;

    @GetMapping(produces = "application/json")
    @ApiOperation("Listar todos consumidores")
    public Retorno ListarTodos() {
        return customerprocessor.ListarTodos();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("Obter consumidor por Id")
    public Retorno ObterPorId(@PathVariable("id") long id) {
        return customerprocessor.ObterPorId(id);
    }

    @RequestMapping(value = "/cpf/{cpf}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("Obter consumidor por cpf")
    public Retorno Obtercpf(@PathVariable("cpf") String cpf) {
        return customerprocessor.ObterPorCpf(cpf);
    }

    @PostMapping(produces = "application/json")
    @ApiOperation("Criar Consumidor")
    public Retorno CriarConsumidor(@RequestBody CustumerRequest customer) {
        return customerprocessor.CriarConsumidor(customer);
    }

    @PutMapping(produces = "application/json")
    @ApiOperation("Alterar Consumidor")
    public Retorno Alterar(@RequestBody CustomerDTO customer) {
        return customerprocessor.AlterarConsumidor(customer);
    }

    @DeleteMapping(path = {"/{id}"}, produces = "application/json")
    @ApiOperation("Remover Consumidor por Id")
    public Retorno Remover(@PathVariable("id") long id) {
        return customerprocessor.DeletarConsumidor(id);
    }
}

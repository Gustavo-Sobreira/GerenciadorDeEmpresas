package br.sobreira.Empresa.Controller;

/*   IMPORTS   */
import br.sobreira.Empresa.Model.Funcionario;
import br.sobreira.Empresa.Service.FuncionarioService;

import javax.validation.Valid;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
/*   -------   */

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping(value = "/cadastro")
    public String cadastrarFuncionaio(@RequestBody @Valid Funcionario funcionarioEmCadastro){
        return funcionarioService.setCadastrarFuncionario(funcionarioEmCadastro);
    }
    @GetMapping(value = "/busca")
    public ArrayList<Funcionario> listarFuncionarios(){
        return FuncionarioService.getListarTodosFuncionarios();
    }
    @GetMapping(value = "/busca/{registro}")
    public Funcionario buscarFuncionario(@PathVariable(name = "registro") String registro){
        return FuncionarioService.getBuscarFuncionarioPorRegistro(registro);
    }

    @GetMapping(value = "extrato/{tipo}")
    public double gerarExtato(@PathVariable(name = "tipo") String tipoExtrato){
        return FuncionarioService.getGerarFolhaDePagamento(tipoExtrato);
    }

    /*
    Como não sabia se o senhor queria o salario bruto ou líquido eu fiz um método que retorna os dois,
    sei que esse retorno está errado, mas empolguei, e achei tão legal no Postman que fiquei com pena de tirar,
    por favor desconsidere na nota.
     */
    @GetMapping(value = "/extrato")
    public String somarFolhaSalarial(){
        return FuncionarioService.getSomarFolhaSalarial();
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String erro(Exception e){
        String erro = e.getMessage();
        return erro.substring(erro.lastIndexOf("default message") + 17,
                erro.length()-3);
    }
}

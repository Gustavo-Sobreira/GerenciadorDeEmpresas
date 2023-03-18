package br.sobreira.Empresa.Service;

/*   IMPORTS   */
import br.sobreira.Empresa.Model.Funcionario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static br.sobreira.Empresa.Service.FalsoBanco.*;
/*   -------   */

@Service
public class FuncionarioService {

    @Autowired
    PessoaService pessoaService;

    public String setCadastrarFuncionario(Funcionario funcionarioEmCadastro) {
        String validacao = validarFuncionario(funcionarioEmCadastro);

        if (!validacao.equals("Valido")){
            return validacao;
        }

        todosFuncionarios.add(funcionarioEmCadastro);
        return "Funcionário cadastrado.";
    }
    private boolean getVerificarFuncionarioExiste(Funcionario funcionarioParaBusca){
        for (Funcionario todosFuncionario : todosFuncionarios) {
            if (Objects.equals(funcionarioParaBusca.numeroDeRegistro,
                    todosFuncionario.numeroDeRegistro)) {
                return true;
            }
        }
        return false;
    }
    private String validarFuncionario(Funcionario funcionarioEmVerificacao){
        boolean pessoaExiste = pessoaService.getVerificarPessoaExiste(funcionarioEmVerificacao.informacoesPessoais);
        if (!pessoaExiste){
            return "ERRO: Pessoa não encontrada, cadastre uma pessoa antes de contrata-lá.";
        }

        boolean funcionarioExiste = getVerificarFuncionarioExiste(funcionarioEmVerificacao);
        if (funcionarioExiste){
            return "ERRO: Número de registro existente.";
        }
        return "Valido";
    }

    public static Funcionario getBuscarFuncionarioPorRegistro(String registro) {
        for (Funcionario todosFuncionario : todosFuncionarios) {
            if (Objects.equals(registro, todosFuncionario.numeroDeRegistro)) {
                return todosFuncionario;
            }
        }
        return null;
    }
    public static ArrayList<Funcionario> getListarTodosFuncionarios() {
        return todosFuncionarios;
    }

    public static double getGerarFolhaDePagamento(String tipo){
        double folha = 0;
        if (Objects.equals(tipo, "liquido")){
            for (Funcionario todosFuncionario : todosFuncionarios) {
                folha += todosFuncionario.salarioLiquido();
            }
        }else if (Objects.equals(tipo,"bruto")){
            for (Funcionario todosFuncionario : todosFuncionarios){
                folha += todosFuncionario.salarioBruto;
            }
        }
        return folha;
    }
    public static String getSomarFolhaSalarial() {
        return "==================================\n" +
                "=         FOLHA SALARIAL         =\n" +
                "=           " + LocalDate.now() + "           =\n" +
                "=                                =\n" +
                "= [ 1 ] - RECEITA BRUTA = " + Math.round(getGerarFolhaDePagamento("bruto")) + "   =\n" +
                "= [ 2 ] - RECEITA LÍQUIDA = "+ Math.round(getGerarFolhaDePagamento("liquido")) + " =\n" +
                "=                                =\n" +
                "==================================";
    }
}
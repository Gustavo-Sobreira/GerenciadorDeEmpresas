package br.sobreira.Empresa.Service;

/*   IMPORTS   */
import br.sobreira.Empresa.Model.Funcionario;
import br.sobreira.Empresa.Model.Pessoa;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
/*   -------  */


@Service
public class FalsoBanco {
    //TODO []Relacionar atbelas no H2 para tirar essa implementação
    static ArrayList<Pessoa> todasPessoas = new ArrayList<>();
    static {
        todasPessoas.add(new Pessoa("12345678901","Gustavo",21,99999999,0));
        todasPessoas.add(new Pessoa("12345655901","Gabriela",22,94999999,0));
        todasPessoas.add(new Pessoa("02345678901","Mariana",13,55599999,0));
        todasPessoas.add(new Pessoa("12345543901","Wenderson",49,99339999,2));
    }
    static ArrayList<Funcionario> todosFuncionarios =  new ArrayList<>();
    static {
        todosFuncionarios.add(new Funcionario(todasPessoas.get(0), "231", "Tecnologia",
                222, true, true));

        todosFuncionarios.add(new Funcionario(todasPessoas.get(3), "2310", "Vendas",
                3222, true, true));
    }
}

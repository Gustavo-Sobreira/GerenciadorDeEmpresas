package br.sobreira.Empresa.Service;

/*   IMPORTS   */
import br.sobreira.Empresa.Model.Pessoa;
import java.util.Objects;
import org.springframework.stereotype.Service;
/*   -------   */

@Service
public class PessoaService {
    public boolean getVerificarPessoaExiste(Pessoa pessoaEmVerificacao){
        for (int i = 0; FalsoBanco.todasPessoas.size() > i; i++){
            if (Objects.equals(pessoaEmVerificacao, FalsoBanco.todasPessoas.get(i))){
                return true;
            }
        }
        return false;
    }
}
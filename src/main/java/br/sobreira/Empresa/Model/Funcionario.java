package br.sobreira.Empresa.Model;

/*   IMPORTS   */
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
/*   -------   */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {
    private final int salarioMinimo = (int)1302.00;

    @NotNull(message = "O funcionário deve esta ligado ser uma pessoa já cadastrada.")
    public Pessoa informacoesPessoais;

    @NotNull(message = "Todo funcionário deve ter um número de registro.")
    @NotBlank(message = "Todo funcionário deve ter um número de registro.")
    public String numeroDeRegistro;


    @Length(max = 32, message = "O setor deve ter no máximo 32 caracteres. ")
    public String setorDeTrabalho;


    @Min(value = salarioMinimo, message = "De acordo com as leis atuais do Brasil," +
            " o salário mínimo é de R$ " + salarioMinimo)
    public double salarioBruto;

    public boolean recebeValeTransporte;
    public boolean trabalhadorNoturno;

    public int bonusPorFilho(){
        return informacoesPessoais.getNumeroDeFilhos() >= 3 ? 150 : informacoesPessoais.getNumeroDeFilhos() * 50;
    }
    public double descontarInss(){
        return salarioBruto * 0.13;
    }
    public double bonusPorTurno(){
        return trabalhadorNoturno ? salarioBruto * 0.06 : 0;
    }
    public double descontoValeTransporte(){
        return recebeValeTransporte? salarioBruto * 0.06 : 0;
    }
    public double salarioLiquido(){
        return  salarioBruto - descontarInss() - descontoValeTransporte() + bonusPorTurno() + bonusPorFilho();
    }
}

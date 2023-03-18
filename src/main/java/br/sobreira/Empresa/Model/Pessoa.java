package br.sobreira.Empresa.Model;

/*   IMPORTS   */
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
public class Pessoa {
    @NotNull(message = "O CPF não pode ser nulo.")
    @NotBlank(message = "O CPF não pode ser nulo.")
    @Length(min = 11, max = 11)
    public String cpf;

    @NotNull(message = "O nome não pode ser nulo.")
    @NotBlank(message = "O nome não pode ser nulo.")
    @Length(max = 100)
    public String nome;

    @NotNull(message = "A idade não pode ser nula.")
    @NotBlank(message = "A idade não pode ser nula.")
    @Length(max = 3)
    public int idade;

    @Length(max = 20)
    public int telefone;

    @NotNull(message = "O número de filhos não pode ser nulo.")
    @NotBlank(message = "O número de filhos não pode ser nulo.")
    @Length(max = 2)
    public int numeroDeFilhos;
}

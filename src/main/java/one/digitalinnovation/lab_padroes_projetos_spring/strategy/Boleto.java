package one.digitalinnovation.lab_padroes_projetos_spring.strategy;

import org.springframework.stereotype.Component;

@Component
public class Boleto implements Pagamento {

    @Override
    public String pagar(double valor) {
        return "Boleto no valor de R$:" + valor + " gerado com sucesso!";
    }
}

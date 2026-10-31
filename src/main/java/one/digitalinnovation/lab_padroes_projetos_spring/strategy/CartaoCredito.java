package one.digitalinnovation.lab_padroes_projetos_spring.strategy;

import org.springframework.stereotype.Component;

@Component("cartao")
public class CartaoCredito implements Pagamento{

    @Override
    public String pagar(double valor) {
        return "Compra efetuada no seu cartao no valor de R$:" + valor + " com sucesso!";
    }
}

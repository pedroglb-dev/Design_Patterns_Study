package one.digitalinnovation.lab_padroes_projetos_spring.strategy;

import org.springframework.stereotype.Component;

@Component
public class Pix implements Pagamento{

    @Override
    public String pagar(double valor) {
        return "Pix de R$:" + valor + " realizado com sucesso.";
    }
}

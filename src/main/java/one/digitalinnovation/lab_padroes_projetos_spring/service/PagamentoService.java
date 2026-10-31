package one.digitalinnovation.lab_padroes_projetos_spring.service;

import one.digitalinnovation.lab_padroes_projetos_spring.strategy.Pagamento;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Map;

@Service
public class PagamentoService {

    private final Map<String, Pagamento> estrategia;

    public PagamentoService(Map<String, Pagamento> estrategia){
        this.estrategia = estrategia;
    }

    public String processar(String tipo, double valor){
        Pagamento pagamento = estrategia.get(tipo.toLowerCase());
        if(pagamento == null){
            throw new IllegalArgumentException("VOCE PRECISA DIGITAR UM TIPO VALIDO PARA REALIZAR A OPERACAO" + tipo);
        }
        return pagamento.pagar(valor);
    }
}

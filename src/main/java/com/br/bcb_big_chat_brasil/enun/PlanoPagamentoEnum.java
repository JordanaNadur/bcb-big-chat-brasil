package com.br.bcb_big_chat_brasil.enun;

import com.br.bcb_big_chat_brasil.entity.Cliente;

public enum PlanoPagamentoEnum {
    PRE_PAGO,
    POS_PAGO;

    public enum PlanoPagamento {
        PRE_PAGO {
            @Override
            public void processarMensagem(Cliente cliente, double custoMensagem) {
                // lógica para PRE_PAGO
            }
        },
        POS_PAGO {
            @Override
            public void processarMensagem(Cliente cliente, double custoMensagem) {
                // lógica para POS_PAGO
            }
        };

        public abstract void processarMensagem(Cliente cliente, double custoMensagem);
    }
}

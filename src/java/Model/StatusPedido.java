package Model;

public enum StatusPedido {

    N("Novo"),
    A("Aguardando pagamento"),
    E("Enviado"),
    R("Recebido"),
    C("Cancelado");

    private final String label;

    public String getLabel() {
        return label;
    }

    private StatusPedido(String descricao) {
        this.label = descricao;
    }
}

package Model;



public enum StatusProduto {

    D("Disponivel"),
    I("Indisponivel");

    private final String label;

    public String getLabel() {
        return label;
    }

    private StatusProduto(String descricao) {
        this.label = descricao;
    }

}

package Model;

public enum SexoCliente {

    M("Masculino"),
    F("Feminino");

    private final String label;

    public String getLabel() {
        return label;
    }

    private SexoCliente(String descricao) {
        this.label = descricao;
    }
}

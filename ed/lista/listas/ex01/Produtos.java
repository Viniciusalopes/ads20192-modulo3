package listas.ex01;

public class Produtos {

    private int cod;
    private String desc;
    private float preco;

    public Produtos() {

    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "cod=" + cod + ", desc=" + desc + ", preco=" + preco + "\n";
    }

}

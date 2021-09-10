import java.util.Date;

public class Item {

    // #region Variáveis
    private int codigo;
    private Date dataEntrada = new Date();
    private String localCompra;
    private String tipo;
    private String marca;
    private String caracteristicas;
    private String tamanho;
    private String cor;
    // tamanho enumerador type-safe
    // cor enumerador type-safe
    private double valorEtiquetaCompra;
    private double valorPagoCompra;
    private double valorMargem;
    private double precoSugerido;
    // #endregion

    // Código do item
    public void setCodigo(int valor) {
        if (valor <= 0) {
            System.out.println("Codigo invalido.");
            return;
        } else {
            codigo = valor;
        }
    }

    public int getCodigo() {
        return codigo;
    }

    // Data de entrada do item no estoque
    public void setDataEntrada(Date valor) {
        dataEntrada = valor;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    // Local da compra
    public void setLocalCompra(String valor) {
        if (valor == null || valor == "") {
            System.out.println("Local da compra invalido.");
            return;
        } else {
            localCompra = valor;
        }
    }

    public String getLocalCompra() {
        return localCompra;
    }

    // Tipo de roupa
    public void setTipo(String valor) {
        if (valor == null || valor == "") {
            System.out.println("Tipo de item invalido.");
            return;
        } else {
            tipo = valor;
        }
    }

    public String getTipo() {
        return tipo;
    }

    // Marca de roupa
    public void setMarca(String valor) {
        if (valor == null || valor == "") {
            System.out.println("Marca de roupa invalida.");
            return;
        } else {
            marca = valor;
        }
    }

    public String getMarca() {
        return marca;
    }

    // Características do item
    public void setCaracteristicas(String valor) {

        caracteristicas = valor;
    }

    public String getCaracteristcas() {
        return caracteristicas;
    }

    // Tamanho do item
    public void setTamanho(String valor){
        if (valor == null || valor == "") {
            System.out.println("Tamanho de roupa invalido.");
            return;
        } else {
            tamanho = valor;
        }
    }

    public String getTamanho(){
        return tamanho;
    }

    // Cor do item
    public void setCor(String valor){
        if (valor == null || valor == "") {
            System.out.println("Cor de roupa invalida.");
            return;
        } else {
            cor = valor;
        }
    }

    public String getCor(){
        return cor;
    }

    // Valor da etiqueta
    public void setValorEtiquetaCompra(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de etiqueta invalido.");
            return;
        } else {
            valorEtiquetaCompra = valor;
        }
    }

    public double getValorDeEtiquetaCompra() {
        return valorEtiquetaCompra;
    }

    // Valor pago na compra
    public void setValorPagoCompra(double valor) {
        if (valor <= 0) {
            System.out.println("Valor pago da compra invalido.");
            return;
        } else {
            valorPagoCompra = valor;
        }
    }

    public double getValorPagoCompra() {
        return valorPagoCompra;
    }

    // Margem
    public void setValorMargem(double valor) {
        if (valor <= 0) {
            System.out.println("Valor com margem invalido.");
            return;
        } else {
            valorMargem = valor;
        }
    }

    public double getValorMargem() {
        return valorMargem;
    }

    // Preço sugerido
    public void setPrecoSugerido(double valor){
        if (valor <= 0){
            System.out.println("Preco invalido.");
            return;
        }
        else{
            precoSugerido = valor;
        }
    }

    public double getPrecoSugerido(){
        return precoSugerido;
    }

}


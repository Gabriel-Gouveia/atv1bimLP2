public enum Cor{
    AZUL("azul"),
    BRANCO("branco"),
    PRETO("preto"),
    ROSA("rosa"),
    ROXO("roxo"),
    VERMELHO("vermelho"),
    VERDE("verde"),
    AMARELO("amarelo"),
    LARANJA("laranja"),
    LILÁS("lilas"),
    BEGE("bege"),
    MARROM("marrom"),
    CINZA("cinza");

    private String nomeCor;

    Cor(String nomeCor){
        this.nomeCor = nomeCor;
    }

    public String getNomeCor(){
        return this.nomeCor;
    }
}

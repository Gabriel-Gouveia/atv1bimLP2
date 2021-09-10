public enum Tamanho{
    P("Tamanho P"),
    M("Tamanho M"),
    G("Tamanho G"),
    GG("Tamanho GG"),
    XG("Tamanho XG");

    private String nomeTamanho;

    Tamanho(String nomeTamanho){
        this.nomeTamanho = nomeTamanho;
    }

    public String getNomeTamanho(){
        return this.nomeTamanho;
    }
}



public class PessoaJuridica extends Cliente {

    String cnpj;

    public PessoaJuridica(String cnpj, String nome){
        super(nome);
        this.cnpj=cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public String toString() {
        return "{Nome: "+this.getNome()+
                ", CNPJ: "+ this.getCnpj()+"}";
    }
}

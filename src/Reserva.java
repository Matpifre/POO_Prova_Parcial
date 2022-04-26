public class Reserva implements Pagamento {

    private Cliente cliente;
    private boolean PagamentoAVista;

    public Reserva(Cliente cliente, boolean PagamentoAVista){
        this.cliente = cliente;
        this.PagamentoAVista = PagamentoAVista;
    }
    
    @Override
    public String toString() {
        
        String aux = "";
        
        if(cliente instanceof PessoaFisica){
            aux += " -> Pessoa Física";
        } else{
            aux += " -> Pessoa Jurídica"; 
        }

        aux += "\nCliente: " + cliente.getNome(); 

        if(getpagamentoAVista() == true){
            aux += "\n-> Pagamento: À vista";
        } else{
            aux += "\n-> Pagamento: Parcelado";
        }

        return aux;
    }

    @Override
    public double calcularPagamento(){
        
        double valor = 3200.00;

        if(pagamentoAVista == true){
            return valor * 0.9;
        } else{
            return valor;
        }
    }

    public boolean getPagamentoAVista() {
        return this.PagamentoAVista;
    }

    public void setPagamentoAVista(boolean PagamentoAVista) {
        this.PagamentoAVista = PagamentoAVista;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
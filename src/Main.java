
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int escolha;

        do{
            escolha = Integer.parseInt(JOptionPane.showInputDialog(Menu()));
            if(escolha < 1 || escolha>6)
            {
                JOptionPane.showMessageDialog(null, "Escolha inválida");
            }else
            {
                switch(escolha)
                {
                    case 1 :
                    Processo.ReservarMesa();
                    break;

                    case 2 :
                    Processo.PesquisarReserva();
                    break;
                    
                    case 3 :
                    Processo.ImprimirReservas();
                    break;

                    case 4 :
                    Processo.ImprimirListaDeEspera();
                    break;

                    case 5 :
                    Processo.CancelarReserva();
                    break;

                    case 6 :
                    Processo.Finalizar();
                    break;


                }
            }
        } while(escolha!=6);
    }

    private static String Menu() {
        
        String aux = "Restaurante SABOR SOFISTICADO";
               aux += "\n1.Reservar Mesa"; 
               aux += "\n2.Pesquisar Reserva"; 
               aux += "\n3.Imprimir Reservas"; 
               aux += "\n4.Imprimir Lista De Espera"; 
               aux += "\n5.Cancelar Reserva"; 
               aux += "\n6.Finalizar"; 
        return aux;
    }
    
}

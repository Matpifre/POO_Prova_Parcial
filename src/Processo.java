import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Processo {

    private static ArrayList<Reserva> reservas = new ArrayList<Reserva>();


    public static void ReservarMesa() {

            boolean tipo;
            String aux = "";
            TipoPessoa tipoPessoa = inputTipoCliente(); 
    
            String nome = JOptionPane.showInputDialog("Nome: ");
    
            Cliente c = null;
            switch(tipoPessoa)
            {
                case Fisica:
                    String cpf = JOptionPane.showInputDialog("CPF: ");    
                    PessoaFisica pf = new PessoaFisica(nome, cpf);
                    c = pf;
                    break;
                case Juridica:
                    String cnpj = JOptionPane.showInputDialog("CNPJ: ");
                    PessoaJuridica pj = new PessoaJuridica(nome, cnpj);
                    c = pj;
                    break;
            }
    
    
            while(!aux.equals("s") && !aux.equals("n"))
            {
                aux = JOptionPane.showInputDialog("A forma de pagamento é avista? [S/N]: ").toLowerCase();
                if(!aux.equals("s") && !aux.equals("n"))
                {
                    JOptionPane.showMessageDialog
                    (null, "Opção inválida, \n informe 'S' para pagamento a vista ou  'N' para parcelado");
                }
            }
                
            if("s".equals(aux))
            {
                tipo = true;
            } else {
                tipo = false;        
            }
        
            Reserva reserva = new Reserva(c, tipo);
            reserva.setPagamentoAVista(tipo);
        
            reservas.add(reserva);
                
            if(reservas.size() > 6)
            {
                JOptionPane.showMessageDialog
                (null, "Numero de reservas esgotados \n Você foi colocado na lista de espera");
            } else{
                JOptionPane.showMessageDialog
                (null, "Reserva Marcada :) ");
            }
        } 

    private static TipoPessoa inputTipoCliente() {
        String tipo="";

        while(!tipo.equals("f") && !tipo.equals("j"))
        {
            tipo = JOptionPane.showInputDialog("Tipo de cliente[F/J]: ").toLowerCase();
            if(!tipo.equals("f") && !tipo.equals("j"))
            {
                JOptionPane.showMessageDialog(null, "Opção inválida, \n informe 'f' para pessoa física ou  'j' para pessoa juridica");
            }
        }

        return tipo.equals("f") ? TipoPessoa.Fisica : TipoPessoa.Juridica;
    }

    public static void PesquisarReserva() {
        if(reservas.size() > 0)
        {
            String aux = JOptionPane.showInputDialog(null, "Informe CPF/CNPJ que deseja achar: ");
            int achou = verificar(aux);

            if(achou >= 0)
            {
                JOptionPane.showMessageDialog(null, "Você possui uma reserva"); 
            }else{
                JOptionPane.showMessageDialog(null, "Você não possui uma reserva");     
            }
        } else{
            JOptionPane.showMessageDialog(null, "Nenhuma reserva cadastrada no momento");     
        } 
    }

    public static void ImprimirReservas() {
        if(reservas.size() > 0)
        {
            for(int i = 0; i < reservas.size(); i++) 
            {
                if(i < 6)
                {
                    JOptionPane.showMessageDialog(null, reservas.get(i));
                } else{
                    return;
                }  
            }
        } else{
            JOptionPane.showMessageDialog(null, "Nunhuma reserva cadastrada");    
        }
         
    }

    public static void ImprimirListaDeEspera() {
        if(reservas.size() > 6)
        {
            for(int i = 0; i < reservas.size(); i++) 
            {
                if(i >= 6)
                {
                    JOptionPane.showMessageDialog
                    (null, "Sua posição na lista de espera: " + (i-5) + "\n" + reservas.get(i));
                }
            }
        } else{
            JOptionPane.showMessageDialog(null, "ERRO!! Ainda restam revervas disponíveis!");     
        }
    }

    public static void CancelarReserva() {
        if(reservas.size() > 0)
        {
            String aux = JOptionPane.showInputDialog(null, "Informe CPF/CNPJ: ");
            int achou = verificar(aux);

            if(achou >= 0)
            {
                reservas.remove(achou);
                JOptionPane.showMessageDialog(null, "Reserva removida!"); 
            } else{
                JOptionPane.showMessageDialog(null, "CPF/CNPJ não foi encontrado");     
            }
        } else{
            JOptionPane.showMessageDialog(null, "Nunhuma reserva cadastrada");     
        }
       
    }
  
    private static int verificar(String aux) {
      return 0;
      if(reservas.size() > 0){

        for(int i = 0; i < reservas.size(); i++) 
        {  
            if(reservas.get(i).getCliente() instanceof PessoaFisica)
            {
                Cliente c = reservas.get(i).getCliente();
                PessoaFisica pf = (PessoaFisica) (c);
                if(pf.getCpf().equals(aux))
                {
                    return i;
                }
            }
            if(reservas.get(i).getCliente() instanceof PessoaJuridica)
            {
                Cliente c = reservas.get(i).getCliente();
                PessoaJuridica pj = (PessoaJuridica) (c);
                if(pj.getCnpj().equals(aux))
                {
                    return i;
                }
            }
        }

    } 

    return -1;
    }
    
    
    public static void Finalizar() {
    }
    
}

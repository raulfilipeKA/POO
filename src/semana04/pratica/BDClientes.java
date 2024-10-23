package semana04.pratica;

import java.util.ArrayList;

public class BDClientes {
    private ArrayList<Cliente> clientes;
    private ArrayList<Cliente> vipList; //faço clienteVIP ou cliente?

    public BDClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    public BDClientes(Cliente cliente) {
        clientes = new ArrayList<>();
        clientes.add(cliente);
    }

    public void removeCliente(int id) {
        for(int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                clientes.remove(i);
                break;
            }
        }
    }

      //porque é que tenho que declarar o objeto de retorno como clientevip e nao cliente apenas?

    public ArrayList<Cliente> listaVIPs(ArrayList<Cliente> clientes) {
        ArrayList<Cliente> vipList = new ArrayList<>();
        ArrayList<Cliente> clientesToRemove = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.valorMedioCompras > ClienteVIP.VALOR_ALVO) {
                vipList.add(new ClienteVIP(cliente.getNome(), cliente.getId(), cliente.getValorMedioCompras(), 10));
                clientesToRemove.add(cliente);
            }
        }
        for(Cliente c : clientesToRemove){
            clientes.remove(c);
        }
        return vipList;
    }


    public static void main(String[] args){
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("João", 1, 1000));
        clientes.add(new Cliente("Maria", 2, 2000));
        clientes.add(new Cliente("Jose", 3, 3000));
        clientes.add(new Cliente("Manuel", 4, 4000));
        clientes.add(new Cliente("Ana", 5, 5000));

        for(Cliente cliente : clientes) {
            System.out.println(cliente.getNome() + " " + cliente.valorMedioCompras);
        }

        System.out.println("------------Clientes VIPs:----------");

        BDClientes bd = new BDClientes(clientes);
        ArrayList<Cliente> vipList = bd.listaVIPs(clientes);

        for(Cliente vip : vipList) {
            System.out.println(vip.getNome() + " " + vip.valorMedioCompras);
        }
        System.out.println("------------Clientes restantes:----------");
        for(Cliente cliente : clientes) {
            System.out.println(cliente.getNome() + " " + cliente.valorMedioCompras);
        }
    }

}

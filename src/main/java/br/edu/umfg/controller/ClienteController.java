package br.edu.umfg.controller;

import br.edu.umfg.model.Cliente;
import br.edu.umfg.service.ClienteService;
import java.sql.SQLException;
import java.util.List;

public class ClienteController {

    private ClienteService service = new ClienteService();

    public Cliente cadastrar(Cliente cliente) {
        try {
            Cliente salvo = service.cadastrar(cliente);
            System.out.println("[SUCESSO] Ficha do proprietário criada no sistema: " + salvo);
            return salvo;
        } catch (IllegalArgumentException e) {
            System.out.println("[RESTRIÇÃO] " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
            return null;
        }
    }

    public Cliente buscarPorId(int id) {
        try {
            Cliente c = service.buscarPorId(id);
            if (c != null) System.out.println("[CONCLUÍDO] Registro localizado: " + c);
            else           System.out.println("[ALERTA] Nenhuma ficha encontrada para o ID de cliente: " + id);
            return c;
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
            return null;
        }
    }

    public List<Cliente> listarTodos() {
        try {
            List<Cliente> lista = service.listarTodos();
            System.out.println("------ [ RELATÓRIO: CLIENTES CADASTRADOS ] ------");
            lista.forEach(System.out::println);
            return lista;
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
            return null;
        }
    }

    public void atualizar(Cliente cliente) {
        try {
            service.atualizar(cliente);
            System.out.println("[SUCESSO] Informações do cliente modificadas com êxito.");
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
        }
    }

    public void deletar(int id) {
        try {
            service.deletar(id);
            System.out.println("[SUCESSO] Ficha cadastral do cliente excluída da base.");
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
        }
    }
}
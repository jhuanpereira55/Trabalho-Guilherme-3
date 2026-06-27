package br.edu.umfg.controller;

import br.edu.umfg.model.Veiculo;
import br.edu.umfg.service.VeiculoService;
import java.sql.SQLException;
import java.util.List;

public class VeiculoController {

    private VeiculoService service = new VeiculoService();

    public Veiculo cadastrar(Veiculo veiculo) {
        try {
            Veiculo salvo = service.cadastrar(veiculo);
            System.out.println("[SUCESSO] Veículo registrado na oficina: " + salvo);
            return salvo;
        } catch (IllegalArgumentException e) {
            System.out.println("[RESTRIÇÃO] " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
            return null;
        }
    }

    public Veiculo buscarPorId(int id) {
        try {
            Veiculo v = service.buscarPorId(id);
            if (v != null) System.out.println("[CONCLUÍDO] Entrada de veículo identificada: " + v);
            else           System.out.println("[ALERTA] Nenhum veículo com o código " + id + " foi localizado.");
            return v;
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
            return null;
        }
    }

    public List<Veiculo> listarTodos() {
        try {
            List<Veiculo> lista = service.listarTodos();
            System.out.println("------ [ RELATÓRIO: FROTA GERAL CADASTRADA ] ------");
            lista.forEach(System.out::println);
            return lista;
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
            return null;
        }
    }

    public List<Veiculo> listarPorCliente(int idCliente) {
        try {
            List<Veiculo> lista = service.listarPorCliente(idCliente);
            System.out.println("------ [ RELATÓRIO: VEÍCULOS VINCULADOS AO CLIENTE ID " + idCliente + " ] ------");
            lista.forEach(System.out::println);
            return lista;
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
            return null;
        }
    }

    public void atualizar(Veiculo veiculo) {
        try {
            service.atualizar(veiculo);
            System.out.println("[SUCESSO] Informações técnicas do veículo atualizadas.");
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
        }
    }

    public void deletar(int id) {
        try {
            service.deletar(id);
            System.out.println("[SUCESSO] Registro do veículo removido dos arquivos.");
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
        }
    }
}
package br.edu.umfg.controller;

import br.edu.umfg.model.OrdemServico;
import br.edu.umfg.service.OrdemServicoService;
import java.sql.SQLException;
import java.util.List;

public class OrdemServicoController {

    private OrdemServicoService service = new OrdemServicoService();

    public OrdemServico abrir(OrdemServico os) {
        try {
            OrdemServico salva = service.abrir(os);
            System.out.println("[SUCESSO] Nova ordem de serviço gerada no sistema: " + salva);
            return salva;
        } catch (IllegalArgumentException e) {
            System.out.println("[RESTRIÇÃO] " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
            return null;
        }
    }

    public OrdemServico buscarPorId(int id) {
        try {
            OrdemServico os = service.buscarPorId(id);
            if (os != null) System.out.println("[CONCLUÍDO] Ficha da OS localizada: " + os);
            else            System.out.println("[ALERTA] Protocolo de OS nº " + id + " não foi localizado.");
            return os;
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
            return null;
        }
    }

    public List<OrdemServico> listarPorVeiculo(int idVeiculo) {
        try {
            List<OrdemServico> lista = service.listarPorVeiculo(idVeiculo);
            System.out.println("------ [ HISTÓRICO CLÍNICO DO VEÍCULO ID: " + idVeiculo + " ] ------");
            lista.forEach(System.out::println);
            return lista;
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
            return null;
        }
    }

    public List<OrdemServico> listarTodos() {
        try {
            List<OrdemServico> lista = service.listarTodos();
            System.out.println("------ [ MAPA GERAL: ORDENS DE SERVIÇO ATIVAS ] ------");
            lista.forEach(System.out::println);
            return lista;
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
            return null;
        }
    }

    public void concluir(int id) {
        try {
            service.concluir(id);
        } catch (IllegalArgumentException e) {
            System.out.println("[RESTRIÇÃO] " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
        }
    }

    public void atualizar(OrdemServico os) {
        try {
            service.atualizar(os);
            System.out.println("[SUCESSO] Dados internos da ordem de serviço modificados.");
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
        }
    }

    public void deletar(int id) {
        try {
            service.deletar(id);
            System.out.println("[SUCESSO] Registro da OS removido definitivamente do banco.");
        } catch (SQLException e) {
            System.out.println("[FALHA BANCO] " + e.getMessage());
        }
    }
}
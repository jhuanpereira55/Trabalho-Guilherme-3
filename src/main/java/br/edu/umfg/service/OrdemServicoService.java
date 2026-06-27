package br.edu.umfg.service;

import br.edu.umfg.model.OrdemServico;
import br.edu.umfg.repository.OrdemServicoRepository;
import br.edu.umfg.repository.VeiculoRepository;
import java.sql.SQLException;
import java.util.List;

public class OrdemServicoService {

    private OrdemServicoRepository osRepository      = new OrdemServicoRepository();
    private VeiculoRepository      veiculoRepository = new VeiculoRepository();

    public OrdemServico abrir(OrdemServico os) throws SQLException {
        // Regra 1: não permitir OS para veículo não cadastrado (valida no banco de verdade)
        if (veiculoRepository.buscarPorId(os.getIdVeiculo()) == null) {
            throw new IllegalArgumentException(
                    "[REQUISITO] Código identificador do veículo (" + os.getIdVeiculo() + ") não consta na base de dados."
            );
        }
        // Regra 2: valor não pode ser negativo
        if (os.getValor() < 0) {
            throw new IllegalArgumentException("[REQUISITO] O orçamento financeiro do serviço não admite valores negativos.");
        }
        if (os.getDescricao() == null || os.getDescricao().trim().isEmpty()) {
            throw new IllegalArgumentException("[REQUISITO] O relatório descritivo das falhas/problemas do veículo é obrigatório.");
        }
        return osRepository.inserir(os);
    }

    public OrdemServico buscarPorId(int id) throws SQLException {
        return osRepository.buscarPorId(id);
    }

    public List<OrdemServico> listarTodos() throws SQLException {
        return osRepository.listarTodos();
    }

    // Requisito explícito: histórico de manutenções de um veículo
    public List<OrdemServico> listarPorVeiculo(int idVeiculo) throws SQLException {
        return osRepository.listarPorVeiculo(idVeiculo);
    }

    // Funcionalidade de concluir uma OS (altera o status)
    public void concluir(int id) throws SQLException {
        OrdemServico os = osRepository.buscarPorId(id);
        if (os == null) {
            throw new IllegalArgumentException("[REQUISITO] Protocolo de ordem de serviço não localizado para encerramento.");
        }
        os.setStatus("CONCLUIDA");
        osRepository.atualizar(os);
        System.out.println("[SUCESSO] Ordem de serviço nº " + id + " finalizada e arquivada.");
    }

    public void atualizar(OrdemServico os) throws SQLException {
        osRepository.atualizar(os);
    }

    public void deletar(int id) throws SQLException {
        osRepository.deletar(id);
    }
}
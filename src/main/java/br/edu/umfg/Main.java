package br.edu.umfg;

import br.edu.umfg.controller.ClienteController;
import br.edu.umfg.controller.OrdemServicoController;
import br.edu.umfg.controller.VeiculoController;
import br.edu.umfg.model.Cliente;
import br.edu.umfg.model.OrdemServico;
import br.edu.umfg.model.Veiculo;

public class Main {

    public static void main(String[] args) {

        ClienteController clienteController = new ClienteController();
        VeiculoController veiculoController = new VeiculoController();
        OrdemServicoController osController      = new OrdemServicoController();

        System.out.println("====== [ FLUXO DE COMPORTAMENTO: GESTÃO DE OFICINA AUTOMOTIVA ] ======\n");

        System.out.println(">>> [FASE 1] Inserção de Novo Cliente");
        Cliente cliente = new Cliente("Carlos Pereira", "44988776655");
        cliente = clienteController.cadastrar(cliente);

        System.out.println("\n>>> [FASE 2] Registro de Veículos Associados");
        Veiculo veiculo = new Veiculo("ayd-1470", "Honda Civic", 2020, cliente.getId());
        veiculo = veiculoController.cadastrar(veiculo);

        Veiculo veiculo2 = new Veiculo("Xyz-5226", "Toyota Corolla", 2018, cliente.getId());
        veiculo2 = veiculoController.cadastrar(veiculo2);

        System.out.println("\n>>> [FASE 3] Inicialização de Ordens de Serviço (OS)");
        OrdemServico os1 = new OrdemServico(veiculo.getId(), "Troca de óleo e filtro", 250.00);
        os1 = osController.abrir(os1);

        OrdemServico os2 = new OrdemServico(veiculo.getId(), "Alinhamento e balanceamento", 180.00);
        os2 = osController.abrir(os2);

        System.out.println("\n>>> [FASE 4] Atualização de Status de OS para Concluído");
        osController.concluir(os1.getId());

        System.out.println("\n>>> [FASE 5] Consulta: Histórico de Intervenções por Veículo");
        osController.listarPorVeiculo(veiculo.getId());

        System.out.println("\n>>> [FASE 6] Consulta: Frota Pertencente ao Cliente");
        veiculoController.listarPorCliente(cliente.getId());

        System.out.println("\n>>> [FASE 7] Homologação de Regra: Orçamento com Valor Negativo");
        OrdemServico invalida1 = new OrdemServico(veiculo.getId(), "Revisão", -100.00);
        osController.abrir(invalida1);

        System.out.println("\n>>> [FASE 8] Homologação de Regra: Vínculo com Veículo Inexistente");
        OrdemServico invalida2 = new OrdemServico(9999, "Revisão", 200.00);
        osController.abrir(invalida2);

        System.out.println("\n====== [ FINALIZAÇÃO DA ROTINA DE DIAGNÓSTICO ] ======");
    }
}
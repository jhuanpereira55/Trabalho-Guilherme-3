package br.edu.umfg.controller;

import br.edu.umfg.model.Consulta;
import br.edu.umfg.service.ConsultaService;
import java.util.List;

public class ConsultaController {

    private ConsultaService consultaService = new ConsultaService();

    public void cadastrar(Consulta consulta) {
        consultaService.cadastrar(consulta);
        System.out.println("[REGISTRO] Atendimento médico agendado com sucesso: " + consulta);
    }

    public List<Consulta> listarTodos() {
        return consultaService.listarTodos();
    }

    public Consulta buscarPorId(int id) {
        return consultaService.buscarPorId(id);
    }

    public List<Consulta> listarPorAnimal(int idAnimal) {
        return consultaService.listarPorAnimal(idAnimal);
    }

    public void atualizar(Consulta consulta) {
        consultaService.atualizar(consulta);
        System.out.println("[REGISTRO] Dados do histórico da consulta foram modificados: " + consulta);
    }

    public void deletar(int id) {
        consultaService.deletar(id);
        System.out.println("[REGISTRO] Histórico de consulta removido do banco. ID correspondente: " + id);
    }
}
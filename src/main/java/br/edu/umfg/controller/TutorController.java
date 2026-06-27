package br.edu.umfg.controller;

import br.edu.umfg.model.Tutor;
import br.edu.umfg.service.TutorService;
import java.util.List;

public class TutorController {

    private TutorService tutorService = new TutorService();

    public void cadastrar(Tutor tutor) {
        tutorService.cadastrar(tutor);
        System.out.println("[REGISTRO] Tutor/Responsável inserido com sucesso: " + tutor);
    }

    public List<Tutor> listarTodos() {
        return tutorService.listarTodos();
    }

    public Tutor buscarPorId(int id) {
        return tutorService.buscarPorId(id);
    }

    public void atualizar(Tutor tutor) {
        tutorService.atualizar(tutor);
        System.out.println("[REGISTRO] Informações cadastrais do tutor modificadas: " + tutor);
    }

    public void deletar(int id) {
        tutorService.deletar(id);
        System.out.println("[REGISTRO] Ficha do tutor removida do sistema. Identificador correspondente: " + id);
    }
}
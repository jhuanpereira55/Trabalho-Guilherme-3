package br.edu.umfg.service;

import br.edu.umfg.model.Tutor;
import br.edu.umfg.repository.TutorRepository;
import java.util.List;

public class TutorService {

    private TutorRepository tutorRepository = new TutorRepository();

    public void cadastrar(Tutor tutor) {
        if (tutor.getNome() == null || tutor.getNome().isBlank()) {
            throw new RuntimeException("[VALIDAÇÃO] A especificação do nome do tutor é obrigatória para o registro.");
        }
        if (tutor.getTelefone() == null || tutor.getTelefone().isBlank()) {
            throw new RuntimeException("[VALIDAÇÃO] O número de telefone do tutor precisa ser informado.");
        }
        tutorRepository.salvar(tutor);
    }

    public List<Tutor> listarTodos() {
        return tutorRepository.listarTodos();
    }

    public Tutor buscarPorId(int id) {
        Tutor tutor = tutorRepository.buscarPorId(id);
        if (tutor == null) {
            throw new RuntimeException("[VALIDAÇÃO] Nenhum cadastro de tutor foi localizado com o ID informado.");
        }
        return tutor;
    }

    public void atualizar(Tutor tutor) {
        if (tutor.getNome() == null || tutor.getNome().isBlank()) {
            throw new RuntimeException("[VALIDAÇÃO] A especificação do nome do tutor é obrigatória para o registro.");
        }
        tutorRepository.atualizar(tutor);
    }

    public void deletar(int id) {
        tutorRepository.deletar(id);
    }
}
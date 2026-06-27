package br.edu.umfg.service;

import br.edu.umfg.model.Animal;
import br.edu.umfg.repository.AnimalRepository;
import br.edu.umfg.repository.TutorRepository;
import java.util.List;

public class AnimalService {

    private AnimalRepository animalRepository = new AnimalRepository();
    private TutorRepository tutorRepository = new TutorRepository();

    public void cadastrar(Animal animal) {
        if (animal.getNome() == null || animal.getNome().isBlank()) {
            throw new RuntimeException("[VALIDAÇÃO] O nome definido para o animal não pode estar em branco.");
        }
        if (animal.getEspecie() == null || animal.getEspecie().isBlank()) {
            throw new RuntimeException("[VALIDAÇÃO] A especificação da espécie do animal é obrigatória.");
        }
        if (tutorRepository.buscarPorId(animal.getIdTutor()) == null) {
            throw new RuntimeException("[VALIDAÇÃO] Não foi localizado nenhum tutor com o identificador informado.");
        }
        animalRepository.salvar(animal);
    }

    public List<Animal> listarTodos() {
        return animalRepository.listarTodos();
    }

    public Animal buscarPorId(int id) {
        Animal animal = animalRepository.buscarPorId(id);
        if (animal == null) {
            throw new RuntimeException("[VALIDAÇÃO] Nenhum registro de animal foi encontrado para este ID.");
        }
        return animal;
    }

    public List<Animal> listarPorTutor(int idTutor) {
        return animalRepository.listarPorTutor(idTutor);
    }

    public void atualizar(Animal animal) {
        if (animal.getNome() == null || animal.getNome().isBlank()) {
            throw new RuntimeException("[VALIDAÇÃO] O nome definido para o animal não pode estar em branco.");
        }
        animalRepository.atualizar(animal);
    }

    public void deletar(int id) {
        animalRepository.deletar(id);
    }
}
package config;

import lombok.Data;

import java.util.*;

@Data
public class AnimalsDatabase {
    public Map<String, List<String>> animals;

    public List<String> animalTraitsList;

    public AnimalsDatabase() {
        animals = new HashMap<>();
        animalTraitsList = new ArrayList<>();

        List<String> animalTraits = new ArrayList<>();

        animalTraits.add("vive no mar");
        animalTraits.add("é carnivoro");
        animalTraits.add("tem barbatanas");

        animals.put("Tubarão", animalTraits);
        animalTraitsList.addAll(animalTraits);

        animalTraits = new ArrayList<>();

        animalTraits.add("come banana");
        animalTraits.add("tem pelos");
        animalTraits.add("anda em duas patas");
        animalTraits.add("sobe em árvores");

        animals.put("Macaco", animalTraits);
        animalTraitsList.addAll(animalTraits);
    }

    public void salvar(String nomeAnimal, List<String> traits) {
        animals.put(nomeAnimal, traits);
    }
}

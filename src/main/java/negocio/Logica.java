package negocio;

import config.AnimalsDatabase;
import visao.Mensagem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Logica {
    Map<String, List<String>> listaPalpitesAnimais = new HashMap<>();
    List<String> listaPalpitesTrait = new ArrayList<>();

    AnimalsDatabase animalsDatabase = new AnimalsDatabase();
    Mensagem mensagem = new Mensagem();

    public void inicia() {
        listaPalpitesAnimais.putAll(animalsDatabase.animals);

        listaPalpitesTrait.addAll(animalsDatabase.animalTraitsList);

        if ((mensagem.mostraMensagemInicial()) != 0) {
            System.exit(0);
        }

        List<String> newTraitsList = new ArrayList<>();

        fazPerguntas(newTraitsList);
        respostaCorreta(newTraitsList);
    }

    private void fazPerguntas(List<String> newTraitsList) {
        for (String animalName : listaPalpitesAnimais.keySet()) {
            List<String> currentAnimalTraits = listaPalpitesAnimais.get(animalName);

            for (String animalTrait : currentAnimalTraits) {
                int tracoPergunta = mensagem.perguntaTraco(animalTrait);
                if (tracoPergunta == 0) {
                    newTraitsList.add(animalTrait);

                    int animalPergunta = mensagem.perguntaAnimal(animalName);
                    if (animalPergunta == 0) {
                        if (mensagem.perguntaNovoJogo("eu venci") == 0) {
                            inicia();
                        } else {
                            System.exit(0);
                        }
                    } else {
                        listaPalpitesAnimais.remove(animalName);
                        if (!listaPalpitesAnimais.isEmpty())
                        {
                            fazPerguntas(newTraitsList);
                        } else {
                            respostaCorreta(newTraitsList);
                        }
                    }
                } else {
                    listaPalpitesAnimais.remove(animalName);
                    listaPalpitesTrait.remove(animalTrait);
                }

                if (!listaPalpitesTrait.isEmpty())
                {
                    fazPerguntas(newTraitsList);
                } else {
                    respostaCorreta(newTraitsList);
                }
            }
        }
        respostaCorreta(newTraitsList);
    }

    private void respostaCorreta(List<String> newTraitsList) {
        String animalCerto;
        if ((animalCerto = mensagem.entrada("Então, qual animal que você pensou?")) != null) {
            animalsDatabase.salvar(animalCerto, newTraitsList);

            if (mensagem.perguntaNovoJogo("você venceu!") == 0) {
                inicia();
            } else {
                System.exit(0);
            }
        }
        System.exit(0);
    }
}
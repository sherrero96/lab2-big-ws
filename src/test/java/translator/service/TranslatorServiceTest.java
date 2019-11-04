package translator.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import translator.Application;
import translator.domain.TranslatedText;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TranslatorServiceTest {

  @Autowired
  TranslatorService translatorService;

  @Test
  public void translateTest() {
    TranslatedText translatedText = translatorService.translate("en", "es", "This is a test of translation service");
    assertEquals("Esto es una prueba de servicio de traducción", translatedText.getTranslation());
  }

  @Test
  public void translateTestEspToGal(){
    TranslatedText translatedText = translatorService.translate("es", "gl", "El pulpo está muy rico");
    assertEquals("O polbo est%C3%A1 moi rico", translatedText.getTranslation());
  }

  @Test
  public void translateTestEspToFin(){
    TranslatedText translatedText = translatorService.translate("es", "fi", "Espero que lo entienda un finlandés");
    assertEquals("Toivon, että ymmärrät suomi%C3%A9s", translatedText.getTranslation());
  }
}

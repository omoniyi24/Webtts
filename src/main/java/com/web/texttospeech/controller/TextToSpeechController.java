package com.web.texttospeech.controller;

import com.web.texttospeech.modal.TextToSpeechModal;
import com.web.texttospeech.service.TextToSpeechService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TextToSpeechController {

    @RequestMapping(value = { "/home" }, method = RequestMethod.GET)
    public ModelAndView display(@ModelAttribute("textToSpeechModal") TextToSpeechModal textToSpeechModal,
                                Model model ) {
        ModelAndView modelAndView = new ModelAndView();

        TextToSpeechService tts = new TextToSpeechService();

        tts.speak(textToSpeechModal.getWord(), 2.0f, false, true);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}

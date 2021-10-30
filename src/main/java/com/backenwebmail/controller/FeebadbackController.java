package com.backenwebmail.controller;

import com.backenwebmail.modelo.Feedback;
import com.backenwebmail.service.CorreosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/contact")
public class FeebadbackController {

    @Autowired(required = true)
    private CorreosServices correosServices;


    @PostMapping("/mail")
    public Boolean contactForEmail(@RequestBody Feedback feedback, BindingResult bindingResult) {

            if (bindingResult.hasErrors()) {
                throw new ValidationException("Feedback in not valid");
            }
           return correosServices.sendFeeback(feedback);
        }



    @PostMapping("/mails")
    public boolean sendEmails(@RequestBody List<Feedback> feedbacks, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Feedback in not valid");
        }
        return correosServices.sendMailsFeeback(feedbacks);
    }



}

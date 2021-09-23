package com.backenwebmail.service;

import com.backenwebmail.entity.ListaDeCorreos;
import com.backenwebmail.modelo.Feedback;

import java.util.List;

public interface CorreosServices {
    public Boolean sendFeeback(Feedback feedback);
    public Boolean sendMailsFeeback(List<Feedback> feedbacks);
}

package com.wealthswaysoft.agencybankingapp.service.impl;

import com.wealthswaysoft.agencybankingapp.dto.EmailDetails;

public interface EmailService {
    void sendEmailAlert(EmailDetails emailDetails);
    void sendEmailWithAttachment(EmailDetails emailDetails);
}

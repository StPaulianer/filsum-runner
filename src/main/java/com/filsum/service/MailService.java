package com.filsum.service;

import com.filsum.controller.ParticipationController;
import com.filsum.model.Participation;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    private static final Logger LOG = LoggerFactory.getLogger(ParticipationController.class.getName());

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;


    @Value(value = "${mail.sending.enabled}")
    private Boolean sendingEnabled;

    @Autowired
    private Environment env;


    public void sendParticpation(Participation participation, List<Participation> bambinis)
            throws Exception {

        Map<String, Object> params = new HashMap<>();
        params.put("run", participation.getRun());
        params.put("runner", participation.getRunner());
        params.put("bambinis", bambinis);
        sendMail(new String[] {participation.getRunner().getEmail()}, "Teilnahme an Filsum Loeppt 2016", "mail/participation.ftl",
                params);
    }

    private void sendMail(final String[] to, final String subject, final String template, final Map<String, ?> params) {
        if (!sendingEnabled) {
            LOG.debug("sending of mails disabled");
            return;
        }
        else {
            LOG.debug("sending of mail enabled via server");
        }

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {
                LOG.trace("preparing mail...");

                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                message.setTo(to);
                message.setBcc("Holger.wollenberg@web.de");
                message.setFrom(getFrom());
                message.setSubject(subject);

                try {
                    Template freemarkerTemplate = freeMarkerConfigurer.getConfiguration().getTemplate(template);
                    String body = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerTemplate, params);
                    message.setText(body, true);
                } catch (TemplateException | IOException e) {
                    LOG.error(e.getMessage());
                }

            }
        };

        LOG.trace("sending mail...");
        try {
            mailSender.send(preparator);
        } catch (Exception ex) {
            LOG.error("Error Mail: " + ex.getMessage());
            ex.printStackTrace();
        }
        LOG.trace( "sent mail.");
    }

    private InternetAddress getFrom() throws UnsupportedEncodingException {
        String fromMail = env.getProperty("mail.from.address");
        String fromName = env.getProperty("mail.from.name");
        return new InternetAddress(fromMail, fromName, "UTF-8");
    }



}

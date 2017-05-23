package mx.ipn.escom.cdt.mail.business;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import mx.ipn.escom.cdt.util.Constantes;

public class MailSender {

	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;
	/**
	 * mapa para agregar recursos al email como imagenes, audio, video
	 */
	private Map<String, Resource> inlineFiles;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public void setInlineFiles(Map<String, Resource> inlineFiles) {
		this.inlineFiles = inlineFiles;
	}

	/**
	 * 
	 * @param entityParams
	 * @param template
	 * @param to
	 * @param subject
	 * @param attachments
	 */
	public void sendEmail(final Map<String, Object> entityParams,
			final String template, final List<String> to, final String subject,
			final Map<String, File> attachments) throws MessagingException {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				putArguments(mimeMessage, entityParams, template, to, subject,
						attachments);
			}
		};
		this.mailSender.send(preparator);
	}

	private void putArguments(MimeMessage mimeMessage,
			Map<String, Object> entityParams, String template, List<String> to,
			String subject, Map<String, File> attachments)
			throws MessagingException {
		MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true,
				Constantes.CHARSET);
		message.setTo(Arrays.copyOf(to.toArray(), to.toArray().length,
				String[].class));
		message.setSubject(subject);
		message.setText(
				VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/"
						+ template, Constantes.CHARSET, entityParams), true);
		if (inlineFiles != null) {
			Iterator<String> itImage = inlineFiles.keySet().iterator();
			while (itImage.hasNext()) {
				String key = itImage.next();
				message.addInline(key, inlineFiles.get(key));
			}
		}

		if (attachments != null) {
			Iterator<String> it = attachments.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				message.addAttachment(key, attachments.get(key));
			}
		}
	}
}

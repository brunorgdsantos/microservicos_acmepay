package br.com.acmepay.application.ports.in;

import br.com.acmepay.adapters.input.api.request.NotificationsRequest;
import br.com.acmepay.adapters.request.DocumentRequest;

public interface INotificationsListener {

    public void receiveMessage(DocumentRequest documentRequestListener);

    public void receiveMessageKafka(DocumentRequest documentRequestListener);
}

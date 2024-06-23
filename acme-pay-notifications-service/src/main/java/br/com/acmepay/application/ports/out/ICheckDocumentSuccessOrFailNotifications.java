package br.com.acmepay.application.ports.out;

public interface ICheckDocumentSuccessOrFailNotifications {
    void executeSuccess(String request);

    void executeFail(String request);
}

package br.com.acmepay.adapters.input.api;

import br.com.acmepay.adapters.input.api.request.NotificationsRequest;
import br.com.acmepay.adapters.input.api.response.NotificationsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/api/v1/notifications")
public interface INotificationsResourceAPI {
        @ResponseStatus(HttpStatus.CREATED)
        @PostMapping
        NotificationsResponse create(@RequestBody NotificationsRequest request);
}

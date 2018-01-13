package ro.uvt.mrbs.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ro.uvt.mrbs.exeptions.RoomBookedException;

/**
 *
 * @author Zbiera Alexandru-Robertî
 */
@ControllerAdvice
public class RoomBookedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = RoomBookedException.class)
    protected ResponseEntity<Object> roomBookedExceptionHandler(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "The room is booked at that time ... " + ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}

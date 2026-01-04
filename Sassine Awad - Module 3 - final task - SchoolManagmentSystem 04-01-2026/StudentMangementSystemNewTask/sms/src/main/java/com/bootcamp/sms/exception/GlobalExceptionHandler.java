package com.bootcamp.sms.exception;

import io.netty.util.LeakPresenceDetector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.csrf.CsrfException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger Log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(CsrfException.class)
    public String csrfExceptionHandler(CsrfException ex, RedirectAttributes redirectAttributes){

        Log.warn("CSRF validation failed", ex.getMessage());
        redirectAttributes.addFlashAttribute("message","Session expired, please log in again.");
return "redirect:/login";

}
@ExceptionHandler(Exception.class)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public String genericExceptionHandler(Exception ex){
       Log.error("Somthing Went Wrong", ex);
        return "500";
}
}
    // Handle specific custom exceptions (Student & Course Not Found)
   // @ExceptionHandler({StudentNotFoundException.class, CourseNotFoundException.class})
    //public ResponseEntity<ErrorResponse> handleResourceNotFound(RuntimeException ex) {
       // ErrorResponse error = new ErrorResponse(
            //    HttpStatus.NOT_FOUND.value(),
              //  ex.getMessage(),
               // LocalDateTime.now()
      //  );
       // return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
   // }

    // Catch-all for any other unexpected exceptions
   // @ExceptionHandler(Exception.class)
   // public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
      //  ErrorResponse error = new ErrorResponse(
          //      HttpStatus.INTERNAL_SERVER_ERROR.value(),
            //    "An unexpected error occurred: " + ex.getMessage(),
             //   LocalDateTime.now()
       // );
       // return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
   // }

    // Simple inner class to format the JSON error response
  //  public static class ErrorResponse {
    //    private int status;
     //   private String message;
     //   private LocalDateTime timestamp;

      //  public ErrorResponse(int status, String message, LocalDateTime timestamp) {
        //    this.status = status;
        //    this.message = message;
         //   this.timestamp = timestamp;
      //  }

        // Getters
      //  public int getStatus() { return status; }
       // public String getMessage() { return message; }
       // public LocalDateTime getTimestamp() { return timestamp; }
   // }
//}
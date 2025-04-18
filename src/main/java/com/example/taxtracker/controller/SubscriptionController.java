import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {
    @Autowired private StripeService stripeService;

    @GetMapping("/checkout")
    public ResponseEntity<Map<String, String>> checkout() throws StripeException {
        String successUrl = "http://localhost:8080/subscription-success.html";
        String cancelUrl = "http://localhost:8080/subscription-cancel.html";
        Session session = stripeService.createCheckoutSession(successUrl, cancelUrl);
        Map<String, String> response = new HashMap<>();
        response.put("id", session.getId());
        response.put("url", session.getUrl());
        return ResponseEntity.ok(response);
    }
}

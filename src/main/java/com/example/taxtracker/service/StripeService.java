import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class StripeService {
    static {
        Stripe.apiKey = "sk_test_YourSecretKeyHere";
    }

    public Session createCheckoutSession(String successUrl, String cancelUrl) throws StripeException {
        SessionCreateParams params = SessionCreateParams.builder()
            .setMode(SessionCreateParams.Mode.SUBSCRIPTION)
            .setSuccessUrl(successUrl)
            .setCancelUrl(cancelUrl)
            .addLineItem(
                SessionCreateParams.LineItem.builder()
                    .setQuantity(1L)
                    .setPrice("price_YourStripePriceID")
                    .build())
            .build();
        return Session.create(params);
    }
}

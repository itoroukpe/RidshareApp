package com.example.taxtracker.service;

import org.springframework.stereotype.Service;
import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.exception.StripeException;



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

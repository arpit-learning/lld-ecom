package dev.arpit.ecom.dtos;

public class Endpoints {
  public static final String v1GiftCards = "/v1/gift-cards";
  public static final String v1GiftCardsById = "/v1/gift-cards/{giftCardId}";
  public static final String v1GiftCardsByIdRedeem = "/v1/gift-cards/{giftCardId}/redeem";
  public static final String v1OrdersByIdCancelOrder = "/v1/orders/{orderId}/cancel-order";
  public static final String v1Signup = "v1/signup";
  public static final String v1Login = "v1/login";
  public static final String v1usersById = "v1/users/{userId}";
  public static final String v1Products = "v1/products";
  public static final String v1Inventory = "v1/inventory";
}

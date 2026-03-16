package dev.arpit.ecom.mappers;

import dev.arpit.ecom.dtos.CreateGiftCardResponseDto;
import dev.arpit.ecom.dtos.FetchGiftCardResponseDto;
import dev.arpit.ecom.dtos.GiftCardResponseDto;
import dev.arpit.ecom.dtos.RedeemGiftCardResponseDto;
import dev.arpit.ecom.models.GiftCard;

public class GiftCardDTOs {
  public static CreateGiftCardResponseDto getCreateGiftCardResponseDto(GiftCard giftCard) {
    return new CreateGiftCardResponseDto(
      GiftCardDTOs.getGiftCardResponseDto(giftCard)
    );
  }

  public static GiftCardResponseDto getGiftCardResponseDto(GiftCard giftCard) {
    return new GiftCardResponseDto(
        giftCard.getId(),
        giftCard.getCode(),
        giftCard.getAmount(),
        giftCard.getCreatedAt(),
        giftCard.getExpiresAt(),
        giftCard.getLedgers().stream().map(GiftCardLedgerDTOs::getGiftCardLedgerResponseDto).toList()
    );
  }

  public static RedeemGiftCardResponseDto getRedeemGiftCardResponseDto(GiftCard giftCard) {
    return new RedeemGiftCardResponseDto(
        GiftCardDTOs.getGiftCardResponseDto(giftCard)
    );
  }

  public static FetchGiftCardResponseDto getFetchGiftCardResponseDto(GiftCard giftCard) {
    return new FetchGiftCardResponseDto(
        GiftCardDTOs.getGiftCardResponseDto(giftCard)
    );
  }
}

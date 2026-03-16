package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.*;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

public interface IGiftCardController {
  ResponseEntity<@NonNull ResponseDto<CreateGiftCardResponseDto>> createGiftCard(CreateGiftCardRequestDto requestDto);
  ResponseEntity<@NonNull ResponseDto<RedeemGiftCardResponseDto>> redeemGiftCard(Long giftCardId, RedeemGiftCardRequestDto requestDto);
  ResponseEntity<@NonNull ResponseDto<FetchGiftCardResponseDto>> fetchGiftCard(Long giftCardId);
}

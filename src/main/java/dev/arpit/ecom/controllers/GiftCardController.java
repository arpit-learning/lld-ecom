package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.*;
import dev.arpit.ecom.exceptions.BaseException;
import dev.arpit.ecom.exceptions.InvalidCreateGiftCardRequestDtoException;
import dev.arpit.ecom.exceptions.InvalidGiftCardIdException;
import dev.arpit.ecom.exceptions.InvalidRedeemGiftCardRequestDtoException;
import dev.arpit.ecom.mappers.GiftCardDTOs;
import dev.arpit.ecom.models.GiftCard;
import dev.arpit.ecom.services.IGiftCardService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GiftCardController implements IGiftCardController {

  @Autowired
  private IGiftCardService iGiftCardService;

  @Override
  @PostMapping(Endpoints.v1GiftCards)
  public ResponseEntity<@NonNull ResponseDto<CreateGiftCardResponseDto>> createGiftCard(@RequestBody CreateGiftCardRequestDto requestDto) {
        ResponseDto<CreateGiftCardResponseDto> responseDto = new ResponseDto<>();

        try {
          doValidationsForCreateGiftCard(requestDto);
          GiftCard giftCard = iGiftCardService.createGiftCard(requestDto.getAmount());
          responseDto.setData(GiftCardDTOs.getCreateGiftCardResponseDto(giftCard));
          responseDto.setMeta(new MetaDataDto(
              ResponseCode.ECOM_SUCCESS_200,
              "gift card created successfully with id " + giftCard.getId(),
              "Gift card create successfully",
              null,
              null
          ));
          return ResponseEntity.ok(responseDto);
        } catch (BaseException e) {
          responseDto.setMeta(
              new MetaDataDto(
                  e.getCode(),
                  e.getMessage(),
                  e.getDisplayMessage(),
                  null,
                  null
              )
          );
          ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.badRequest();
          return bodyBuilder.body(responseDto);
        }
    }

  @Override
  @PostMapping(Endpoints.v1GiftCardsByIdRedeem)
  public ResponseEntity<@NonNull ResponseDto<RedeemGiftCardResponseDto>> redeemGiftCard(@PathVariable Long giftCardId, @RequestBody RedeemGiftCardRequestDto requestDto) {
        ResponseDto<RedeemGiftCardResponseDto> responseDto = new ResponseDto<>();

        try {
          doValidationsForRedeemGiftCard(giftCardId, requestDto);
          double amountToRedeem = requestDto.getAmountToRedeem();
          GiftCard giftCard = iGiftCardService.redeemGiftCard(giftCardId, amountToRedeem);
          responseDto.setData(GiftCardDTOs.getRedeemGiftCardResponseDto(giftCard));
          responseDto.setMeta(new MetaDataDto(
              ResponseCode.ECOM_SUCCESS_200,
              "amount " + amountToRedeem + " from the giftCard with id " + giftCardId + " redeemed",
              "Gift Card redeemed successfully",
              null,
              null
          ));

          return ResponseEntity.ok(responseDto);
        } catch (BaseException e) {
          responseDto.setMeta(new MetaDataDto(
              e.getCode(),
              e.getMessage(),
              e.getDisplayMessage(),
              null,
              null
          ));

          ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.badRequest();
          return bodyBuilder.body(responseDto);
        }
    }

  @Override
  @GetMapping(Endpoints.v1GiftCardsById)
  public ResponseEntity<@NonNull ResponseDto<FetchGiftCardResponseDto>> fetchGiftCard (@PathVariable Long giftCardId) {
    ResponseDto<FetchGiftCardResponseDto> responseDto = new ResponseDto<>();

    try {
      doValidationsForFetchGiftCard(giftCardId);
      responseDto.setData(GiftCardDTOs.getFetchGiftCardResponseDto(iGiftCardService.fetchGiftCard(giftCardId)));
      responseDto.setMeta(
          new MetaDataDto(
              ResponseCode.ECOM_SUCCESS_200,
              "gift card with id " + giftCardId + " fetched successfully",
              "Gift card fetched successfully",
              null,
              null
          )
      );

      return ResponseEntity.ok(responseDto);
    } catch (BaseException e) {
      responseDto.setMeta(new MetaDataDto(
          e.getCode(),
          e.getMessage(),
          e.getDisplayMessage(),
          null,
          null
      ));

      ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.badRequest();
      return bodyBuilder.body(responseDto);
    }
  }

  private void doValidationsForCreateGiftCard(CreateGiftCardRequestDto requestDto) throws InvalidCreateGiftCardRequestDtoException {
    if(requestDto == null) {
      throw new InvalidCreateGiftCardRequestDtoException(
          ResponseCode.ECOM_FAILURE_400,
          "Request body can't be null",
          "Request body should be valid"
      );
    }
    if(requestDto.getAmount() == null || requestDto.getAmount() == 0) {
      throw new InvalidCreateGiftCardRequestDtoException(
          ResponseCode.ECOM_FAILURE_400,
          "amount can't be null or 0",
          "amount should be valid"
      );
    }
  }

  private void doValidationsForRedeemGiftCard(Long giftCardId, RedeemGiftCardRequestDto requestDto) throws InvalidGiftCardIdException, InvalidRedeemGiftCardRequestDtoException {
    if(giftCardId == null || giftCardId == 0L) {
      throw new InvalidGiftCardIdException(
          ResponseCode.ECOM_FAILURE_400,
          "Request body can't be null",
          "Request body should be valid"
      );
    }
    if(requestDto == null) {
      throw new InvalidRedeemGiftCardRequestDtoException(
          ResponseCode.ECOM_FAILURE_400,
          "Request body can't be null",
          "Request body should be valid"
      );
    }
    if(requestDto.getAmountToRedeem() == null || requestDto.getAmountToRedeem() == 0) {
      throw new InvalidRedeemGiftCardRequestDtoException(
          ResponseCode.ECOM_FAILURE_400,
          "amount can't be null or 0",
          "amount should be valid"
      );
    }
  }

  private void doValidationsForFetchGiftCard(Long giftCardId) throws InvalidGiftCardIdException {
    if(giftCardId == null || giftCardId == 0L) {
      throw new InvalidGiftCardIdException(
          ResponseCode.ECOM_FAILURE_400,
          "gift card id can't be null",
          "Gift card id should be valid"
      );
    }
  }
}

package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.*;
import dev.arpit.ecom.exceptions.BaseException;
import dev.arpit.ecom.exceptions.InvalidMatchDeliveryPartnerTaskRequestDtoException;
import dev.arpit.ecom.mappers.DeliveryPartnerTaskMappingDTOs;
import dev.arpit.ecom.models.DeliveryPartnerTaskMapping;
import dev.arpit.ecom.services.IDeliveryPartnerTaskMappingService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchPartnerTaskController {
    @Autowired
    private IDeliveryPartnerTaskMappingService iDeliveryPartnerTaskMappingService;

    @PostMapping(Endpoints.v1MatchPartnersNTasks)
    public ResponseEntity<@NonNull ResponseDto<MatchDeliveryPartnerTaskResponseDto>> matchPartnersAndTasks(MatchDeliveryPartnerTaskRequestDto requestDto) {
        ResponseDto<MatchDeliveryPartnerTaskResponseDto> responseDto = new ResponseDto<>();

        try {
          doValidationsForMatchPartnersAndTasks(requestDto);
          List<Long> partnerIds = requestDto.getPartnerIds();
          List<Long> taskIds = requestDto.getTaskIds();
          List<DeliveryPartnerTaskMapping> mappings = iDeliveryPartnerTaskMappingService.matchPartnersAndTasks(partnerIds, taskIds);
          responseDto.setData(DeliveryPartnerTaskMappingDTOs.getMatchDeliveryPartnerTaskResponseDto(mappings));
          responseDto.setMeta(
              new MetaDataDto(
                  ResponseCode.ECOM_SUCCESS_200,
                  "Delivery Partner and tasks mapping done successfully",
                  "Delivery Partner and tasks mapping done successfully",
                  null,
                  null
              )
          );

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

    private void doValidationsForMatchPartnersAndTasks(MatchDeliveryPartnerTaskRequestDto requestDto) throws InvalidMatchDeliveryPartnerTaskRequestDtoException {
      if(requestDto == null) {
        throw new InvalidMatchDeliveryPartnerTaskRequestDtoException(
            ResponseCode.ECOM_FAILURE_400,
            "Empty request body",
            "Empty request body"
        );
      }
      if(requestDto.getPartnerIds() == null || requestDto.getPartnerIds().isEmpty()) {
        throw new InvalidMatchDeliveryPartnerTaskRequestDtoException(
            ResponseCode.ECOM_FAILURE_400,
            "invalid partner ids",
            "invalid partner ids"
        );
      }
      if(requestDto.getTaskIds() == null || requestDto.getTaskIds().isEmpty()) {
        throw new InvalidMatchDeliveryPartnerTaskRequestDtoException(
            ResponseCode.ECOM_FAILURE_400,
            "invalid task ids",
            "invalid task ids"
        );
      }
    }
}

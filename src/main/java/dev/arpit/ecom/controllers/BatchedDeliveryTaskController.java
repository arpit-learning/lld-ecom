package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.*;
import dev.arpit.ecom.exceptions.BaseException;
import dev.arpit.ecom.mappers.BatchedDeliveryTaskDTOs;
import dev.arpit.ecom.models.Location;
import dev.arpit.ecom.services.IBatchedDeliveryTaskService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BatchedDeliveryTaskController implements IBatchedDeliveryTaskController {
    @Autowired
    private IBatchedDeliveryTaskService iBatchedDeliveryTaskService;

    @Override
    @PostMapping(Endpoints.v1BuildBatchedTaskRoute)
    public ResponseEntity<@NonNull ResponseDto<BuildBatchedTaskRouteResponseDto>> buildRoute(@RequestBody BuildBatchedTaskRouteRequestDto requestDto) {
        ResponseDto<BuildBatchedTaskRouteResponseDto> responseDto = new ResponseDto<>();

        try {
            long batchedTaskId = requestDto.getBatchedTaskId();
            List<Location> route = iBatchedDeliveryTaskService.buildRoute(batchedTaskId);
            responseDto.setData(BatchedDeliveryTaskDTOs.getBuildBatchedTaskRouteResponseDto(route));
            responseDto.setMeta(
                new MetaDataDto(
                    ResponseCode.ECOM_SUCCESS_200,
                    "Route build successfully",
                    "route build successfully",
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
}

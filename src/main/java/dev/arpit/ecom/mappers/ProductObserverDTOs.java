package dev.arpit.ecom.mappers;

import dev.arpit.ecom.dtos.DeregisterUserForNotificationResponseDto;
import dev.arpit.ecom.dtos.ProductObserverResponseDto;
import dev.arpit.ecom.dtos.RegisterUserForNotificationResponseDto;
import dev.arpit.ecom.models.ProductObserver;

public class ProductObserverDTOs {
  public static ProductObserverResponseDto getProductObserverResponseDto(ProductObserver productObserver) {
    return new ProductObserverResponseDto(
        ProductDTOs.getProductResponseDto(productObserver.getProduct()),
        UserDTOs.getUserResponseDto(productObserver.getUser())
    );
  }

  public static RegisterUserForNotificationResponseDto getRegisterUserForNotificationResponseDto(ProductObserver productObserver) {
    return new RegisterUserForNotificationResponseDto(
        ProductObserverDTOs.getProductObserverResponseDto(productObserver)
    );
  }

  public static DeregisterUserForNotificationResponseDto getDeregisterUserForNotificationResponseDto(ProductObserver productObserver) {
    return new DeregisterUserForNotificationResponseDto(
        ProductObserverDTOs.getProductObserverResponseDto(productObserver)
    );
  }
}

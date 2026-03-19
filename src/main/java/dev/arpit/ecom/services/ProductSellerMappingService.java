package dev.arpit.ecom.services;

import dev.arpit.ecom.adapters.MapsAdapter;
import dev.arpit.ecom.dtos.ResponseCode;
import dev.arpit.ecom.exceptions.InvalidProductSellerMappingIdException;
import dev.arpit.ecom.exceptions.InvalidUserAddressMappingIdException;
import dev.arpit.ecom.models.Address;
import dev.arpit.ecom.models.ProductSellerMapping;
import dev.arpit.ecom.models.UserAddressMapping;
import dev.arpit.ecom.repositories.ProductSellerMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class ProductSellerMappingService implements IProductSellerMappingService  {
  @Autowired
  private MapsAdapter mapsAdapter;
  @Autowired
  private ProductSellerMappingRepository productSellerMappingRepository;

  @Override
  public LocalDateTime estimateDeliveryDate(long productSellerMappingId, UserAddressMapping userAddressMapping) throws InvalidProductSellerMappingIdException {
    ProductSellerMapping productSellerMapping = productSellerMappingRepository.findById(productSellerMappingId).orElseThrow(() -> new InvalidProductSellerMappingIdException(
        ResponseCode.ECOM_FAILURE_400,
        "Product Seller mapping not found",
        "Product Seller mapping not found"
    ));
    Address pickupAddress = productSellerMapping.getSeller().getAddress();
    Address dropAddress = userAddressMapping.getAddress();

    int estimate = mapsAdapter.calEstimate(
        dropAddress.getLocation(),
        pickupAddress.getLocation()
    );

    return LocalDateTime.now().plus(Duration.ofMillis(estimate));
  }
}

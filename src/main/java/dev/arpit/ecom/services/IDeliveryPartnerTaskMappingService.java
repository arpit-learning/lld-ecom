package dev.arpit.ecom.services;

import dev.arpit.ecom.models.DeliveryPartnerTaskMapping;

import java.util.List;

public interface IDeliveryPartnerTaskMappingService {
  List<DeliveryPartnerTaskMapping> matchPartnersAndTasks(List<Long> partnerIds, List<Long> taskIds);
}

package dev.arpit.ecom.services;

import dev.arpit.ecom.models.*;
import dev.arpit.ecom.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService implements INotificationService {
  @Autowired
  private NotificationRepository notificationRepository;
  @Autowired
  private IProductObserverService iProductObserverService;

  @Override
  public List<Notification> sendNotifications (Product product) {
    List<ProductObserver> productObservers = iProductObserverService.findAllByProduct(product);
    List<Notification> notifications = productObservers.stream().map(productObserver ->
        new Notification(
            productObserver.getProduct().getName() + " is back into stock. Please order ASAP to get it.",
            productObserver.getProduct(),
            productObserver.getUser(),
            NotificationStatus.CREATED
        )
    ).toList();

    return notificationRepository.saveAll(notifications);
  }
}

package dev.arpit.ecom.adapters;

import dev.arpit.ecom.libraries.gmaps.GLocation;
import dev.arpit.ecom.libraries.gmaps.GMaps;
import dev.arpit.ecom.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GmapsAdapter implements MapsAdapter {
  private GMaps gmaps;

  public GmapsAdapter () {
    GMaps gmaps = new GMaps();
  }

  @Override
  public List<Location> buildRoute(List<Location> locations) {
      List<GLocation> gLocations = generateGLocations(locations);
      List<GLocation> optimizedLocations = gmaps.getOptimizedRoute(gLocations);
      return generateLocations(optimizedLocations);
  }

  @Override
  public int calEstimate (Location dropAddress, Location pickupAddress) {
    GLocation dropGLocation = generateGLocation(dropAddress);
    GLocation pickupGLocation = generateGLocation(pickupAddress);

    return gmaps.estimate(dropGLocation, pickupGLocation);
  }

  private GLocation generateGLocation(Location location) {
    GLocation gLocation = new GLocation();
    gLocation.setLat(location.getLatitude());
    gLocation.setLng(location.getLongitude());
    return gLocation;
  }

  private List<GLocation> generateGLocations(List<Location> locations) {
    return locations.stream().map(location -> {
      GLocation gLocation = new GLocation();
      gLocation.setLat(location.getLatitude());
      gLocation.setLng(location.getLongitude());
      return gLocation;
    }).toList();
  }

  private Location generateLocation(GLocation gLocation) {
    return new Location(
        gLocation.getLat(),
        gLocation.getLng()
    );
  }

  private List<Location> generateLocations(List<GLocation> gLocations) {
    return gLocations.stream().map(gLocation -> new Location(
        gLocation.getLat(),
        gLocation.getLng()
    )).toList();
  }
}

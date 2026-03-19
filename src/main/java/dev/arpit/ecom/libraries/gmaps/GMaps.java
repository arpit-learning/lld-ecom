package dev.arpit.ecom.libraries.gmaps;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GMaps {
  public List<GLocation> getOptimizedRoute(List<GLocation> locations) {
    // API call to Google Maps API
    Collections.shuffle(locations);
    return locations;
  }

  public int estimate(GLocation src, GLocation dest) {
    // Call Google Maps service to get the number of seconds required to travel from src to dest
    Random random = new Random();
    return random.nextInt(100000000) + 1;
  }
}

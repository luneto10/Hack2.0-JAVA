/**
 * Name: Luciano Carvalho (lguedesdecarvalhon2@huskers.unl.edu)
 * 
 * Date: 2023 - 08 - 29
 * 
 * Ask the user to write the Latitude and Longitute from two places
 * and output their distance.
*/

package unl.soc;

import java.util.Scanner;
import java.lang.Math.*;

public class AirDistance {
    public static void main(String[] args) {

        int EARTH_RADIUS = 6371;

        double latitudeOrigin, latitudeDestination, longitudeOrigin, longitudeDestination, distance;
        int invalidValue = 1, end = 0;
        Scanner scanner = new Scanner(System.in);

        while (end == 0) {
            while (invalidValue == 1) {
                System.out.println("Latitude from the origin: ");
                latitudeOrigin = scanner.nextDouble();

                System.out.println("Longitude from the origin: ");
                longitudeOrigin = scanner.nextDouble();

                System.out.println("\nLatitude from the destination: ");
                latitudeDestination = scanner.nextDouble();

                System.out.println("Longitude from the destination: ");
                longitudeDestination = scanner.nextDouble();

                // Valitading the user input
                if (latitudeDestination > 90 || latitudeDestination < -90 || latitudeOrigin > 90
                        || latitudeDestination < -90) {

                    System.out.println("\nPLEASE, ENTER A LATITUDE VALUE IN THE RANGE OF [-90,90]!\n\n");
                }

                if (longitudeOrigin < -180 || longitudeOrigin > 180 || longitudeDestination < -180
                        || longitudeDestination > 180) {

                    System.out.println("\nPLEASE, ENTER A LONGITUDE VALUE IN THE RANGE OF [-180,180]!\n\n");
                } else {

                    distance = Math
                            .acos(Math.sin((latitudeOrigin * Math.PI / 180.0))
                                    * Math.sin((latitudeDestination * Math.PI / 180.0))
                                    + Math.cos((latitudeOrigin * Math.PI / 180.0)) *
                                            Math.cos((latitudeDestination * Math.PI / 180.0))
                                            * Math.cos((longitudeDestination * Math.PI / 180.0)
                                                    - (longitudeOrigin * Math.PI / 180.0)))
                            * EARTH_RADIUS;

                    System.out.printf("\nLocation Distance\n========================\n");
                    System.out.printf("Origin: (%.6f,%.6f)\n", latitudeOrigin, longitudeOrigin);
                    System.out.printf("Destination : (%.6f,%.6f)\n", latitudeDestination, longitudeDestination);
                    System.out.printf("Air distance is %.6f kms\n", distance);
                    invalidValue = 0;
                    scanner.close();

                    // last validation
                    end = 1;
                }

            }

        }
    }
}

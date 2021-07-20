/** Function prototypes for calculating retrievable welfare
 *
 * @author Alex Miera
 */

#ifndef TRIAGED_PATIENT_H
#define TRIAGED_PATIENT_H

#include <stdio.h>
#include "linkedlist.h"
#include <vector>
#include <iostream>

class TriagedPatient {
    public:
        static double extractionTime;
        static double burnPercent;
        static double respirationRate;
        static double tidalVolume;
        static double pulse;
        static double systolicPressure;
        static double diastolicPressure;
        static double temperature;
        static double bloodOxygen;

        static LLIST* factors;

        TriagedPatient() {
            extractionTime = getExtractionTime();
            burnPercent = getBurnPercent();
            respirationRate = getRespirationRate();
            tidalVolume = getTidalVolume();
            pulse = getPulse();
            systolicPressure = getSystolicPressure();
            diastolicPressure = getDiastolicPressure();
            temperature = getTemperature();
            bloodOxygen = getBloodOxygen();
        }

        double getExtractionTime();
        double getBurnPercent();
        double getRespirationRate();
        double getTidalVolume();
        double getPulse();
        double getSystolicPressure();
        double getDiastolicPressure();
        double getTemperature();
        double getBloodOxygen();
};

static double calculateRetrievableWelfare(std::vector<double> weights, struct TriagedPatient *triagedPatient);

#endif

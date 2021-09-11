/** Function prototypes for calculating retrievable welfare
 *
 * @author Alex Miera
 */

#ifndef TRIAGED_PATIENT_H
#define TRIAGED_PATIENT_H

#include <stdio.h>
#include <vector>
#include <iostream>
#include "../common/linkedlist.hpp"

class TriagedPatient
{

public:
    double *mExtractionTime;
    double *mBurnPercent;
    double *mRespirationRate;
    double *mTidalVolume;
    double *mPulse;
    double *mSystolicPressure;
    double *mDiastolicPressure;
    double *mTemperature;
    double *mBloodOxygen;

    LinkedList::LLIST *factors;

    TriagedPatient()
    {
        mExtractionTime = (double *)malloc(sizeof(double));
        *mExtractionTime = getExtractionTime();

        mBurnPercent = (double *)malloc(sizeof(double));
        *mBurnPercent = getBurnPercent();

        mRespirationRate = (double *)malloc(sizeof(double));
        *mRespirationRate = getRespirationRate();

        mTidalVolume = (double *)malloc(sizeof(double));
        *mTidalVolume = getTidalVolume();

        mPulse = (double *)malloc(sizeof(double));
        *mPulse = getPulse();

        mSystolicPressure = (double *)malloc(sizeof(double));
        *mSystolicPressure = getSystolicPressure();

        mDiastolicPressure = (double *)malloc(sizeof(double));
        *mDiastolicPressure = getDiastolicPressure();

        mTemperature = (double *)malloc(sizeof(double));
        *mTemperature = getTemperature();

        mBloodOxygen = (double *)malloc(sizeof(double));
        *mBloodOxygen = getBloodOxygen();
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

    double calculateRetrievableWelfare(std::vector<double> weights,
                                       LinkedList *llist);

    int createFactors(LinkedList *llist);
    int deleteTriagedPatient(LinkedList *llist);
};

#endif

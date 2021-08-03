/** Main file for triaged patient
 *
 * @author Alex Miera
 *
 */

#include <vector>
#include <iostream>
#include <stdio.h>
#include "../common/linkedlist.hpp"
#include "triagedPatient.hpp"

/** Function that calculates the patients likelyhood of survival, i.e. 
 *  retrievable welfare
 * 
 * @note number of factors is specified at runtime
 * 
 * @param weights importance of each vital
 * @param ppatient pointer to a patient class
 * @return weightedSum
*/
double calculateRetrievableWelfare(std::vector<double> weights, 
                                   LinkedList* llist,
                                   struct TriagedPatient *ppatient) {
    double weightedSum = 0;

    /* generates a weighted sum using the product of the patient factors and 
       the given weights */
    LinkedList::LLNODE *pnode = llist->get_first_node(ppatient->factors);
    for (int i = 0; i < weights.size(); i++ ) {

        /* only consideres non-zero weights */
        if (weights.at(i) != 0.0) {

            /* only considers patient data if there is not an error */
            if (*pnode->data != -1.0) 
            {
                weightedSum += weights.at(i) * (*(pnode->data));
            }

            pnode = llist->get_next_node(pnode);
        }
    }
    return weightedSum;
}



/** Function that gets the time it takes to transfer the patient from the
 *  ground to the field hospital starting at the time a distress signal
 *  was sent to EMS (t_r) and ending at the time of arrival at a field 
 *  hospital (s_rh)
 * 
 * @param void
 * @return extractionTime
 * @note extractionTime is in minutes
*/
double TriagedPatient::getExtractionTime() {
    double extractionTime;
    extractionTime = 70;

    if (extractionTime < 0) {
        DEBUG("Error: extraction time cannot go below 0 minutes \n");
        return -1.0;
    }

    return extractionTime;
}

/** Function that gets patient's body burn percentage
 * 
 * @param void
 * @return patient's body burn percentage
*/
double TriagedPatient::getBurnPercent() {
    double burnPercent;
    burnPercent = 90.9;

    if (burnPercent < 0) {
        DEBUG("Error: burn percent cannot go below 0%% \n");
        return -1.0;
    }

    if (burnPercent > 100) {
        DEBUG("Error: burn percent cannot go above 100%% \n");
        return -1.0;
    }

    return burnPercent;
}

/** Function that gets patient's respiration rate
 * 
 * @param void
 * @return patient's respiration rate in breaths per minute
*/
double TriagedPatient::getRespirationRate() {
    double respirationRate;
    respirationRate = 20;

    if (respirationRate < 0) {
        DEBUG("Error: respiration rate cannot go below 0 breathes per minute \n");
        return -1.0;
    }

    return respirationRate;
}

/** Function that gets patient's tidal volume
 * 
 * @param void
 * @return patient's tidal volume in mL per kg
*/
double TriagedPatient::getTidalVolume() {
    double tidalVolume;
    tidalVolume = 8;

    if (tidalVolume < 0) {
        DEBUG("Error: tidal volume cannot go below 0 mL per kg \n");
        return -1.0;
    }

    return tidalVolume;
}

/** Function that gets patient's pulse
 * 
 * @param void
 * @return patient's pulse in beats per min
*/
double TriagedPatient::getPulse() {
    double pulse;
    pulse = 70;

    if (pulse < 0) {
        DEBUG("Error: pulse cannot go below 0 beats per min \n");
        return -1.0;
    }

    return pulse;
}

/** Function that gets patient's systolic pressure
 * 
 * @param void
 * @return patient's systolic pressure in mm Hg
*/
double TriagedPatient::getSystolicPressure() {
    double systolicPressure;
    systolicPressure = 115;

    if (systolicPressure < 0) {
        DEBUG("Error: systolic pressure cannot go below 0 mm Hg \n");
        return -1.0;
    }

    return systolicPressure;
}

/** Function that gets patient's diastolic pressure
 * 
 * @param void
 * @return patient's diastolic pressure in mm Hg
*/
double TriagedPatient::getDiastolicPressure() {
    double diastolicPressure;
    diastolicPressure = 70;

    if (diastolicPressure < 0) {
        DEBUG("Error: systolic pressure cannot go below 0 mm Hg \n");
        return -1.0;
    }

    return diastolicPressure;
}

/** Function that gets patient's body temperature
 * 
 * @param void
 * @return patient's body temperature in celcius
*/
double TriagedPatient::getTemperature() {
    double temperature;
    temperature = 99.5;

    return temperature;
}


/** Function that gets patient's blood oxygen
 * 
 * @param void
 * @return patient's blood oxygen percentage
*/
double TriagedPatient::getBloodOxygen() {
    double bloodOxygen;
    bloodOxygen = 99;

    if (bloodOxygen < 0) {
        DEBUG("Error: blood oxygen cannot go below 0%% \n");
        return -1.0;
    }

    if (bloodOxygen > 100) {
        DEBUG("Error: blood oxygen cannot go above 100%% \n");
        return -1.0;
    }

    return bloodOxygen;
}

/** Function that creates a linked list of the patients vitals
 * 
 * @param llist pointer to a linked list
 * @param ppatient pointer to a patient class
 * @return success (0) failure (1)
*/
int TriagedPatient::createFactors(LinkedList* llist, TriagedPatient* ppatient) {
    ppatient->factors = llist->create();

    /* indicates there was an error creating the linked list */
    if (ppatient->factors == NULL) {
        return 1; /* indicates failure */
    }
    
    /* creates a linked list of patient vitals */
    llist->addtail(ppatient->factors, ppatient->mExtractionTime);
    llist->addtail(ppatient->factors, ppatient->mBurnPercent);
    llist->addtail(ppatient->factors, ppatient->mRespirationRate);
    llist->addtail(ppatient->factors, ppatient->mTidalVolume);
    llist->addtail(ppatient->factors, ppatient->mPulse);
    llist->addtail(ppatient->factors, ppatient->mSystolicPressure);
    llist->addtail(ppatient->factors, ppatient->mDiastolicPressure);
    llist->addtail(ppatient->factors, ppatient->mTemperature);
    llist->addtail(ppatient->factors, ppatient->mBloodOxygen);

    return 0; /* indicates success */
}

/** Function that frees the memory allocated to patient class
 * 
 * @param llist pointer to a linked list
 * @param ppatient pointer to a patient class
 * @return success (0) failure (1)
*/
int TriagedPatient::deleteTriagedPatient(LinkedList* llist, TriagedPatient* ppatient) {
    LinkedList::LLNODE *pnode = NULL;

    /* destroys each node of vitals data */
    llist->get_first_node(ppatient->factors);
    while (pnode != NULL) {
        free(pnode->data); /* frees the vitals data */
        llist->deletenode(ppatient->factors, pnode); /* frees memory allocated to
        the linked list node */
        pnode = llist->get_first_node(ppatient->factors); /* finds the next node */
    }
    free(ppatient); /* frees patient class */
    return 0; /* indicates success */
}

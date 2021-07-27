/** Main file for triaged patient
 *
 * @author Alex Miera
 *
 */

#include <vector>
#include <iostream>
#include <stdio.h>
#include "linkedlist.hpp"
#include "triagedPatient.hpp"



/** Function that calculates the patients likelyhood of survival, i.e. 
 *  retrievable welfare
 * 
 * @note number of factors is specified at runtime
 * 
 * @param weights
 * @param triagedPatient
 * @return weightedSum
 * @note low triage weight = green to yellow tag
 *       high triage weight = red to black tag
*/
double calculateRetrievableWelfare(std::vector<double> weights, 
                                   LinkedList* llist,
                                   struct TriagedPatient *triagedPatient) {
    double weightedSum = 0;
    LinkedList::LLNODE *pnode = llist->get_first_node(triagedPatient->factors);

    for( int i = 0; i < weights.size(); i++ ){
        if( weights.at(i) != 0.0){
            weightedSum += weights.at(i) * (*(pnode->data));
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
    return 70;
}

double TriagedPatient::getBurnPercent() {
    return 90.9;
}

double TriagedPatient::getRespirationRate() {
    return 20;
}

double TriagedPatient::getTidalVolume() {
    return 8;
}

double TriagedPatient::getPulse() {
    return 70;
}

double TriagedPatient::getSystolicPressure() {
    return 115;
}

double TriagedPatient::getDiastolicPressure() {
    return 70;
}

double TriagedPatient::getTemperature() {
    return 99.5;
}

double TriagedPatient::getBloodOxygen() {
    return 99;
}

void TriagedPatient::createFactorsLL(LinkedList* llist, TriagedPatient* patient) {
    patient->factors = llist->create();
    
    llist->addtail(patient->factors, patient->extractionTime);
    llist->addtail(patient->factors, patient->burnPercent);
    llist->addtail(patient->factors, patient->respirationRate);
    llist->addtail(patient->factors, patient->tidalVolume);
    llist->addtail(patient->factors, patient->pulse);
    llist->addtail(patient->factors, patient->systolicPressure);
    llist->addtail(patient->factors, patient->diastolicPressure);
    llist->addtail(patient->factors, patient->temperature);
    llist->addtail(patient->factors, patient->bloodOxygen);
}

void TriagedPatient::deleteTriagedPatient(LinkedList* llist, TriagedPatient* patient) {
    LinkedList::LLNODE *pnode = NULL;

    llist->get_first_node(patient->factors);
    while (pnode != NULL) {
        free(pnode->data);
        llist->deletenode(patient->factors, pnode);
        pnode = llist->get_first_node(patient->factors);
    }
    free(patient->factors);
    /* destroy function is not working */
    free(patient);
}

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
     * the given weights 
     */
    LinkedList::LLNODE *pnode = llist->get_first_node(ppatient->factors);
    for (int i = 0; i < weights.size(); i++ ){
        if (weights.at(i) != 0.0){
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
    llist->addtail(ppatient->factors, ppatient->extractionTime);
    llist->addtail(ppatient->factors, ppatient->burnPercent);
    llist->addtail(ppatient->factors, ppatient->respirationRate);
    llist->addtail(ppatient->factors, ppatient->tidalVolume);
    llist->addtail(ppatient->factors, ppatient->pulse);
    llist->addtail(ppatient->factors, ppatient->systolicPressure);
    llist->addtail(ppatient->factors, ppatient->diastolicPressure);
    llist->addtail(ppatient->factors, ppatient->temperature);
    llist->addtail(ppatient->factors, ppatient->bloodOxygen);

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

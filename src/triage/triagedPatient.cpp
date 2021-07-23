/** Main file for triaged patient
 *
 * @author Alex Miera
 *
 */

#include <vector>
#include <iostream>
#include <stdio.h>
#include "linkedlist.h"
#include "triagedPatient.h"



int main(int argc, char *argv[]) {
    printf("1\n");
    TriagedPatient* patient1 = new TriagedPatient();
    LinkedList* llist = new LinkedList();

    patient1->factors = llist->create();
    printf("Extraction time: %f\n", *(patient1->extractionTime));
    
    llist->addtail(patient1->factors, patient1->extractionTime);
    llist->addtail(patient1->factors, patient1->burnPercent);
    llist->addtail(patient1->factors, patient1->respirationRate);
    llist->addtail(patient1->factors, patient1->tidalVolume);
    llist->addtail(patient1->factors, patient1->pulse);
    llist->addtail(patient1->factors, patient1->systolicPressure);
    llist->addtail(patient1->factors, patient1->diastolicPressure);
    llist->addtail(patient1->factors, patient1->temperature);
    llist->addtail(patient1->factors, patient1->bloodOxygen);

    std::vector<double> weights;
    weights.push_back(0.1);
    weights.push_back(0.2);
    weights.push_back(0.3);
    weights.push_back(0.4);
    weights.push_back(0.5);
    weights.push_back(0.6);
    weights.push_back(0.7);
    weights.push_back(0.8);
    weights.push_back(0.9);

    double retrievableWelfare = calculateRetrievableWelfare(weights, llist, patient1);
    printf("Retrievable welfare: %f\n", retrievableWelfare);
}



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
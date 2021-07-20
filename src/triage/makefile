all: triagedPatient

triagedPatient: triagedPatient.o linkedlist.o
	g++ -g triagedPatient.o linkedlist.o -o triagedPatient

triagedPatient.o: triagedPatient.cpp linkedlist.h triagedPatient.h
	g++ -g -c triagedPatient.cpp

linkedlist.o: linkedlist.cpp linkedlist.h
	g++ -g -c linkedlist.cpp

clean:
	rm -r *.o triagedPatient
	
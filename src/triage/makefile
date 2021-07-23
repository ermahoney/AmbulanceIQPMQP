CC=g++

all: triagedPatient

triagedPatient: triagedPatient.o linkedlist.o
	$(CC) -g triagedPatient.o linkedlist.o -o triagedPatient

triagedPatient.o: triagedPatient.cpp linkedlist.h triagedPatient.h
	$(CC) -g -c triagedPatient.cpp

linkedlist.o: linkedlist.cpp linkedlist.h
	$(CC) -g -c linkedlist.cpp

clean:
	rm -r *.o triagedPatient
	
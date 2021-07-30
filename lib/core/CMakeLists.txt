cmake_minimum_required(VERSION 3.16.3)

set(This core)

set(Sources
    linkedlist.cpp
    triagedPatient.cpp
)

set(Headers
    linkedlist.hpp
    triagedPatient.hpp
)

add_library(${This} STATIC ${Sources} ${Headers})
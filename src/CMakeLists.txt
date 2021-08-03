cmake_minimum_required(VERSION 3.16.3)

set(THIS src)

# .cpp file locations
add_library(${THIS} 
    common/linkedlist.cpp
    patients/triagedPatient.cpp
)

# .hpp file locations
target_include_directories(${THIS} PUBLIC
    ${CMAKE_CURRENT_SOURCE_DIR}/common
    ${CMAKE_CURRENT_SOURCE_DIR}/patients
)

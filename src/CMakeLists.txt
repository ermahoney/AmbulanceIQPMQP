cmake_minimum_required(VERSION 3.16.3)

set(THIS src)
set(THIS_TEST src_test)

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

# src test executable
add_executable(${THIS_TEST} 
    patients/triagedPatientTest.cpp
)

# src test linker
target_link_libraries(${THIS_TEST} PUBLIC
    gtest_main
    ${THIS}
)

# src test tests
add_test(
    NAME ${THIS_TEST}
    COMMAND ${THIS_TEST}
)

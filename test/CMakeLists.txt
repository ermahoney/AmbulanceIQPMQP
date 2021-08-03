cmake_minimum_required(VERSION 3.16.3)

set(THIS srctest)

add_executable(${THIS} 
    triagedPatientTest.cpp
)

target_link_libraries(${THIS} PUBLIC
    gtest_main
    src
)

add_test(
    NAME ${THIS}
    COMMAND ${THIS}
)
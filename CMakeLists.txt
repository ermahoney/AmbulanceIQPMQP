cmake_minimum_required(VERSION 3.16.3)

set(This AIQPMQP)

project(${This} CXX)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_POSITION_INDEPENDENT_CODE ON)

enable_testing()

add_subdirectory(ext)
add_subdirectory(src)
add_subdirectory(test)
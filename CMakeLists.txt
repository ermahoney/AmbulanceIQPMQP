cmake_minimum_required(VERSION 3.16.3)

# defines project and language
project(AIQPMQP LANGUAGES CXX)

include(CTest)

# adds subdirectories
add_subdirectory(ext)
add_subdirectory(src)
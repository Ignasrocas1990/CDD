
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or (at
# your option) any later version.
#
# This program is distributed in the hope that it will be useful, but
# WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
# General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with GNU Emacs.  If not, see <http://www.gnu.org/licenses/>.
#	Name: Ignas Rocas
#	Student nr: C00135830
#	Purpose: lab 10
#	Date : 17/01/2022
#	Description: used to minimize the debuging flags
	

CFILES= saxpy.cpp
HFILES=
CC=g++
CFLAGS= -std=c++11 -pthread -fopenmp
DEBUGFLAGS = -g -O0


#This rule says that each .o file depends on a .cpp file of the same name
%.o: %.cpp
	$(CC) -c -o $@ $< $(CFLAGS) $(DEBUGFLAGS)

HELLO: hello.o
	$(CC)  -o hello.out hello.o $(CFLAGS) $(DEBUGFLAGS)

SAXPY: saxpy.o
	$(CC) -o saxpy.out saxpy.o $(CFLAGS)

MANDEL: mandelbroit.o
	$(CC) -o mandelbroit.out mandelbroit.o $(CFLAGS) $(DEBUGFLAGS)


DSAXPY: DEBUGFLAGS = -g -O0
DSAXPY: SAXPY


SIMPLESUM: simpleSum.o
	$(CC) -o sum.out simpleSum.o $(CFLAGS)

PRIMES: simplePrimes.o
	$(CC) -o primes.out simplePrimes.o $(CFLAGS)
#this is customary and just deletes all .o files
CLEAN:
	rm *.o

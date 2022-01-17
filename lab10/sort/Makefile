
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
	
CPPFILES= quicksort.cpp
HFILES=
CC=g++
CFLAGS= -std=c++11  -fopenmp

#This rule says that each .o file depends on a .cpp file of the same name
%.o: %.cpp
	$(CC) -c -o $@ $< $(CFLAGS) $(DEBUGFLAGS)

QUICK: quicksort.o
	$(CC) -o qsort.out quicksort.o $(CFLAGS) $(DEBUGFLAGS)


DSORT: DEBUGFLAGS = -g -O0
DSORT: QUICK

#this is customary and just deletes all .o files
CLEAN:
	rm *.o

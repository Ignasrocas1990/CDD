
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
	
CFILES= stencil.cpp
HFILES=
CC=g++
CFLAGS= -std=c++11  -fopenmp

#This rule says that each .o file depends on a .cpp file of the same name
%.o: %.cpp
	$(CC) -c -o $@ $< $(CFLAGS) $(DEBUGFLAGS)

STENCIL: stencil.o
	$(CC) -o stencil.out stencil.o $(CFLAGS) $(DEBUGFLAGS)

MANDEL: mandelbroit.o
	$(CC) -o mandelbroit.out mandelbroit.o $(CFLAGS) $(DEBUGFLAGS)


DSTENCIL: DEBUGFLAGS = -g -O0
DSTENCIL: STENCIL

#this is customary and just deletes all .o files
CLEAN:
	rm *.o

// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or (at
// your option) any later version.
//
// This program is distributed in the hope that it will be useful, but
// WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with GNU Emacs.  If not, see <http://www.gnu.org/licenses/>.

/*
	Name: Ignas Rocas
	Student nr: C00135830
	Date : 17/01/2022
	Purpose: Lab 10, using pragma omp libraby
	Description: 
	Generates random array of values and 
	uses multiple threads while sharing same
	value (sum) to calculate total
	
*/
#include <iostream>
#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time */
#include <limits>
#include <omp.h>

int main(void){
  const unsigned long SIZE=1000000;
  float numberArray[SIZE];
  float sum=0.0;
  /* initialize random seed: */
  srand (time(NULL));
  for(unsigned long long int i=0;i<SIZE;++i){
    /* generate secret number between 1 and 1000: */
    numberArray[i] = rand() % 1000 + 1;
  }
  clock_t begin = clock();
#pragma omp parallel for reduction(+:sum)
  for (unsigned long i=0; i < SIZE; ++i){
      sum=sum+numberArray[i];
  }//for
  clock_t end = clock();
  double timeSec = (end - begin) / static_cast<double>( CLOCKS_PER_SEC );
  std::cout << timeSec << std::endl;
  std::cout << sum << std::endl;
}//main

//
/// simpleSum.cpp ends here

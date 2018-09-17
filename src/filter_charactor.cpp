#include <string>
#include <sstream>
#include <iostream>
#include <cstdlib>

using namespace std;

/*
Incopy source string to destination, but filter out charactors if it's within history_size. 
Distination memory is same size as source memory
History_size < max source size
*/

bool isInHistory( void* tmp, void* target, ){
 
	

}


size_t filter( void * dest, void* source, size_t source_size, size_t history_size){


}

size_t filter_charactors(string input, size_t history_size){
 	vector<char> dest = vector<char>(input.size());
	size_t filter_num = filter(&dest, input.c_src(), input.size(), history_size);
	
}



int main(){
	
 for(string line; getline(cin, line);){
	//std::cout << line << endl;

	stringstream ss(line);


 }
 
 return 0;
}

// Fibonacci, Prime, Palindrome

public class CodeExcercise_Middle{
  
  
  //Fn = Fn-1 + Fn-2
  public Integer fibonacci(Integer n) {
      if ( n == 0 || n ==1 )
        return n;
      return fibonacci(n-1) + fibonacci(n-2);
  }
  
  //A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
  //Write a method that checks if a number is a prime number.
  public Boolean isPrime(Integer n) {
    boolean[] primes = new boolean[n];
    Arrays.fill(primes, true);

    if( n ==1 && n ==0 )
      return false;

    for( int j = 2; j< n ; j++){
      if (primes[j]){
        if(n % j ==0)
          return false;
        for(int i =j; i< n; i= i+j){
          if(i % j ==0){
                primes[i] = false;
            }
        }
      }
    }
    return true;
  }
  
  
  // abccfccba
  public boolean isPalindrome(String word) {
    int i = 0;
    int j = word.length() -1;
    while( j > i){
      if( word.charAt(i++) !=  word.charAt( j--)){
            return false;
        }
    }
    return true;
 }
  
}


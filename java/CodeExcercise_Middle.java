//A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
//Write a method that checks if a number is a prime number.

public class CodeExcercise_Middle{
  
  public Integer fibonacci(Integer n) {
      if ( n == 0 || n ==1 )
        return n;
      return fibonacci(n-1) + fibonacci(n-2);
  }
  
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
}

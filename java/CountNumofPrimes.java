package com.leetcode.easy;
//204. Count Primes

//Count the number of prime numbers less than a non-negative number, n.   
// 
//Input: n = 10  (0~9)
//Output: 4

//Input: n = 0  
//Output: 0
//Input: n = 1  (0)
//Output: 0
//Input: n = 2  (0~1)
//Output: 0
//Input: n = 3  (0~2)
//Output: 1

//sieve of Eratosthenes

class CountNumofPrimes {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        int ans = 0;
        for(int i= 2; i< n ; i++){
            if( primes[i]){
                ans++;
                for(long j= (long)i*i; j< n; j+=i){
                    primes[(int)j] = false;
                }
            }
        }
        return ans;
    
    }
}

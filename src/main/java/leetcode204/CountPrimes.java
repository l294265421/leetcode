package leetcode204;

/**
 * 
Count the number of prime numbers less than a non-negative number, n.
 * @author liyuncong
 *
 */
public class CountPrimes {
	/**
	 * Sieve of Eratosthenes(埃拉托色尼筛选法)：
	 * 1.Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
	 * 2.Initially, let p equal 2, the smallest prime number.
	 * 3.Enumerate the multiples of p by counting to n from 2p in increments of 
	 * p, and mark them in the list (these will be 2p, 3p, 4p, ...; the p itself 
	 * should not be marked).
	 * 4.Find the first number greater than p in the list that is not marked. If 
	 * there was no such number, stop. Otherwise, let p now equal this new number
	 *  (which is the next prime), and repeat from step 3.
	 * 5.When the algorithm terminates, the numbers remaining not marked in the 
	 * list are all the primes below n.
	 * 
	 * The main idea here is that every value given to p will be prime, because 
	 * if it were composite it would be marked as a multiple of some other, 
	 * smaller prime. Note that some of the numbers may be marked more than 
	 * once (e.g., 15 will be marked both for 3 and 5)
	 * As a refinement, it is sufficient to mark the numbers in step 3 starting 
	 * from p^2, as all the smaller multiples of p will have already been marked 
	 * at that point. This means that the algorithm is allowed to terminate in 
	 * step 4 when p2 is greater than n.[1]
	 * Another refinement is to initially list odd numbers only, (3, 5, ..., n), 
	 * and count in increments of 2p from p^2 in step 3, thus marking only odd
	 *  multiples of p. This actually appears in the original algorithm.[1] This 
	 *  can be generalized with wheel factorization, forming the initial list 
	 *  only from numbers coprime with the first few primes and not just from 
	 *  odds (i.e., numbers coprime with 2), and counting in the correspondingly 
	 *  so that only such multiples of p are generated that are coprime with those small 
	 *  primes, in the first place.[6]
	 * @param n
	 * @return
	 */
    public int countPrimes(int n) {
        int counter = 0;
        boolean[] primeFlag = new boolean[n];
        for(int i = 2; i < n; i++) {
        	if (!primeFlag[i]) {
				counter++;
			}
        	for(int j = 2; i * j < n; j++) {
        		primeFlag[i * j] = true;
        	}
        }
        return counter;
    }
    
    public static void main(String[] args) {
		CountPrimes countPrimes = new CountPrimes();
		System.out.println(countPrimes.countPrimes(12));
	}
}

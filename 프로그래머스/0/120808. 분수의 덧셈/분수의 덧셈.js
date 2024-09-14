function cal_gcd(a, b) {
    return a % b === 0 ? b : cal_gcd(b, a % b)
}

function solution(numer1, denom1, numer2, denom2) {
    
    var answer = [];
    var numer = numer1 * denom2 + numer2 * denom1;
    var demom = denom1 * denom2;
    
    answer[0] = numer / cal_gcd(numer, demom);
    answer[1] = demom / cal_gcd(numer, demom);
    return answer;
}


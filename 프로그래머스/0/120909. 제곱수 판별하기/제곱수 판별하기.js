function solution(n) {
    var root = Math.sqrt(n);
    var integerRoot = Math.floor(root);
    return integerRoot * integerRoot === n ? 1 : 2;
}
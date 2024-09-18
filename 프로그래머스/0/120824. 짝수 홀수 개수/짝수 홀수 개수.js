function solution(num_list) {
    var answer = [];
    var even = 0;
    var odd = 0;
    for(var i = 0; i < num_list.length; i++){
        if(num_list[i] % 2 == 0) even++;
        else odd++;
    }
    answer[0] = even;
    answer[1] = odd;
    return answer;
}
function solution(array) {
    var answer = 0;
    var cnt = 0;
    var arr = Array.from({length: 1000}, (v,i) => 0);
    
    for(var i = 0; i < array.length; i++){
        arr[array[i]]++;
    }

    for(var i = 0; i < arr.length; i++){
        if(cnt < arr[i]){
            answer = i;
            cnt = arr[i];
        }
    }
    var total = 0;
    for(var i = 0; i < arr.length; i++){
        if(cnt == arr[i]) total++;
    }
    return total === 1 ? answer : -1;
}
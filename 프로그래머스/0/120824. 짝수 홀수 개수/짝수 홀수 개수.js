function solution(num_list) {
    return num_list.reduce((acc, num) => {
        num % 2 == 0 ? acc[0]++ : acc[1]++;
        return acc;
    }, [0,0]);
}

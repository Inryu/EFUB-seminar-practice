//1부터 5까지 자연수의 배열 생성
const arr=[1,2,3,4,5];

//배열 안의 모든 자연수에 3을 곱한 후 짝수만 출력
const newarr=arr.map(num=>num*3);


newarr.forEach(num=>{
    if(num%2===0) console.log(num);
})

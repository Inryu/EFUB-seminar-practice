const order={
    orderNum : 20210401,
    orderId: 'efubFront',
    name : '이펍',
    address:'서울특별시 서대문구 이화여대길 52'
}

for(let key in order){
    console.log(`${key} : ${order[key]}`);
}

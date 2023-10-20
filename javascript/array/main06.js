// 배열(박스)에 객체를 저장할 수 있다,

// 배열 요소 필터링
[1,2,3,4,5,6,7,8,9,10]
.filter( (value)=>
    // 짝수만 필터
    value%2 === 0)
    .forEach( (val)=>{
        console.log(val)
    });

    let num = [1,2,3,4,5,6,7,8,9,10]
                .filter( (value)=>
                    // 짝수만 필터
                    value%3 === 0);
        //console.log(num);    
                    
        num.forEach( (val)=>{
             console.log(val)
         });
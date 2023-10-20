// 배열(박스)에 객체를 저장할 수 있다.
const userList = [
    {id:11,name:'곰',address:'서울'},
    {id:14,name:'사자',address:'대전'},
    {id:3,name:'호랑이',address:'부산'},
    {id:12,name:'강아지',address:'인천'},
    {id:51,name:'삯',address:'부산'},
];

// 출력요소 연결
const container = document.querySelector('.container');

// userList 배열의 각 요소별 루프 처리
userList.forEach( (userData,idx)=>{
    // 각 요소별 데이터 처리
    container.innerHTML += `
        <div class="card">
            <h2>${userData.name}</h2>
            <h2>${idx+1}</h2>
            <p>지역 : ${userData.address} </p>
        </div>`;
});

        
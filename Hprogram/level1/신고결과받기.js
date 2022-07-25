function solution(id_list, report, k) {
    const answer = [];

    let stay = [];

    id_list.map(el=>{
        stay.push({name:el,list:[],k:0,result:0})
    })


    report.map(el=>{
        let user = el.split(" ");
        let index = stay.find(el=>el.name===user[0]);
        let reportUser = stay.find(el=>el.name===user[1]);
        if(index.list.findIndex(names=>names===user[1]) === -1){
            index.list.push(user[1]);
            reportUser.k += 1;
        }


    });

    stay.map(el=>{
        if(el.k >= k){
            stay.map(els=>{
                if(els.list.findIndex(m=>m===el.name)!==-1){
                    els.result += 1
                }
            })

        }
    })
    stay.map(el=>{
        answer.push(el.result);
    })


    return answer;
}
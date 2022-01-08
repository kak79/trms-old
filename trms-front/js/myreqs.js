getMySubmittedReqs();
//getReqsAjax();

async function getMySubmittedReqs() {
    // let id = parseInt(localStorage.Token);
    let response = await fetch(appUrl + 'reqs/requestor/' + 3);
    // let response = await fetch('http://localhost:8080/reqs/8',{method:'PUT', body:JSON.stringify(reqObj)});
    
    if (response.status === 200) {
        let reqs = await response.json();
        console.log(reqs);
        showReqs(reqs);
    }
}



function showReqs(reqs) {
    let reqsTable = document.getElementById('individualsReqs');

    // for each req in the array of reqs that we got from the back end
    for (let req of reqs) {
        let rowForReq = document.createElement('tr');

        // for each field in the req (yes, we can iterate through fields)
        for (let field in req) {
            let column = document.createElement('td');
             // req[field] gets the value of the field
            column.innerText = req[field];
        }
        rowForReq.appendChild(column);
    }
    reqsTable.appendChild(rowForReq);
        
 }


// checkLogin().then(() => {
//     console.log(loggedInPerson);
//     //debugger
//     if (loggedInPerson.reqs || loggedInPerson.reqs.size > 0){
//         showReqs(loggedInPerson.reqs)
//     }   
//     else {
//         document.getElementById('individualsReqs').remove();

//         let noReqsMsg = document.createElement('p');
//         noReqsMsg.innerText = 'No Reimbursement Requests Yet.  Try Submitting One.';
//         document.getElementsByTagName('main')[0].appendChild(noReqsMsg);
//     }
// });

function showReqs(reqs) {
    let reqsTable = document.getElementById('individualsReqs');

    for (let req of reqs) {
        let rowForReq = document.createElement('tr');

        for (let field in req) {
            let column = document.createElement('td');
            if (field!=='status') {
                column.innerText = req[field];
            }
            rowForReq.appendChild(column);
        }
        reqsTable.appendChild(rowForReq);
    }
}
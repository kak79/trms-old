checkLogin().then(() => {
    console.log(loggedInPerson);
    if (loggedInPerson.reqs || loggedInPerson.reqs.size > 0)
        showReqs(loggedInPerson.reqs)
    else {
        document.getElementById('individualsReqs').remove();

        let noPetsMsg = document.createElement('p');
        noReqsMsg.innerText = 'Hmm... you don\'t have any pets yet! Try adopting some on the available pets page!';
        document.getElementsByTagName('main')[0].appendChild(noReqsMsg);
    }
});

function showPets(reqs) {
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
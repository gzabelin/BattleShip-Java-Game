function fetchData() {

    fetch("/api/games/gameInfo", {
        method: "GET",
        //    headers: {'X-API-Key': "Key goes inside the quotes"}

    }).then(function (response) {
        if (response.ok) {
            return response.json();

        }
        throw new Error(response.statusText);

    }).then(function (json) {
        var gameData = json;

        console.log(gameData);

        createGameList(gameData);

    }).catch(function (error) {
        console.log("Request failed: " + error.message);

    });
}

fetchData();

function createGameList(games){

    for (i=0; i<games.length; i++){

        var gameName = document.createElement("li");

        gameName.textContent = "Game " + (i+1);

        document.getElementById("list").appendChild(gameName);

        var gameInfo= document.createElement("ul");



            var gameid = document.createElement("li");
            var created = document.createElement("li");
            var p1 = document.createElement("li");
            var p2 = document.createElement("li");

            gameid.textContent = "Game ID: " + games[i]["Game ID"];
            created.textContent = "Game created: " + games[i]["Game created"];

            gameInfo.appendChild(gameid);
            gameInfo.appendChild(created);


        if (games[i].Gameplayers.length >=1){
            p1.textContent = "Player 1: " + games[i].Gameplayers[0].player["User Name"];
            gameInfo.appendChild(p1);
        }
        if (games[i].Gameplayers.length ==2){
            p2.textContent = "Player 2: " + games[i].Gameplayers[1].player["User Name"]
            gameInfo.appendChild(p2);
        }




        gameName.appendChild(gameInfo)



    }





}




function fetchData2() {

    fetch("/api/leaderboard", {
        method: "GET",
        //    headers: {'X-API-Key': "Key goes inside the quotes"}

    }).then(function (response) {
        if (response.ok) {
            return response.json();

        }
        throw new Error(response.statusText);

    }).then(function (json) {
        var playerData = json;

        console.log(playerData);

        createLeaderBoard(playerData);

        sortLeaderBoard();

    }).catch(function (error) {
        console.log("Request failed: " + error.message);

    });
}

fetchData2();


function createLeaderBoard(data){

    for(i=0; i<data.length; i++){

        var row = document.createElement("tr");
        document.getElementById("player_scores").appendChild(row);

        var user = document.createElement("td");
        row.appendChild(user);
        user.textContent = data[i].player;
        user.setAttribute("class", "user");

        var score = document.createElement("td");
        row.appendChild(score);
        score.textContent = data[i].total_score;

        var wins = document.createElement("td");
        row.appendChild(wins);
        wins.textContent = data[i].wins;

        var lose = document.createElement("td");
        row.appendChild(lose);
        lose.textContent = data[i].losses;

        var tie = document.createElement("td");
        row.appendChild(tie);
        tie.textContent = data[i].ties;

    }

}


function sortLeaderBoard() {
  var table, rows, switching, i, x, y, shouldSwitch;
  table = document.getElementById("player_scores");
  switching = true;
  while (switching) {

    switching = false;
    rows = table.getElementsByTagName("tr");

    for (i = 0; i < (rows.length); i++) {
      shouldSwitch = false;
      x = rows[i].getElementsByTagName("td")[1];
      y = rows[i + 1].getElementsByTagName("td")[1];

      if (y.innerHTML > x.innerHTML) {
        shouldSwitch = true;
        break;
      }
    }
    if (shouldSwitch) {
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
}


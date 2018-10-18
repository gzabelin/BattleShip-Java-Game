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
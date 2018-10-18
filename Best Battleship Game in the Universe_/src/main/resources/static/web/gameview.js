
let urlParams = new URLSearchParams(window.location.search); // window.location.search contains the whole URL
let myParam = urlParams.get('gp');  // .get is a method of URLSearchParams -> it's looking for what I tell it to look for.

console.log(myParam);   /// this is just for testing :P

var gp = myParam;





function fetchData() {

    fetch("/api/game_view/gp"+gp, {
        method: "GET",

    }).then(function (response) {
        if (response.ok) {
            return response.json();

        }
        throw new Error(response.statusText);

    }).then(function (json) {
        var gameView = json;

        console.log(gameView);

        createGridLines();

        displayView(gameView);
        displayIncomingShots (gameView);
        displayOutgoingShots (gameView);

    }).catch(function (error) {
        console.log("Request failed: " + error.message);

    });
}

fetchData();

function displayView(data){

    for (i=0; i<data.ships.length; i++){

        for (j=0; j<data.ships[i].location.length; j++){

            var coord = data.ships[i].location[j];

            var xCoord = coord.charAt(0); /// this is the letter coordinate in A1
            var yCoord = coord.charAt(1);

            yCoord = parseInt(yCoord, 10); // converts y coordinate from char to number. '10' is mathematical base.

            var coordKey = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];

            for (k=0; k<coordKey.length; k++){
                if(xCoord == coordKey[k]){

                    xCoord = coordKey.indexOf(xCoord);     /// this assigns a number to a letter coordinate
                    xCoord +=1;                         /// this gives A the value of 1 (for example)
                }
            }


            var coordPlot = document.createElement("div");
            document.getElementById("shipsgrid").appendChild(coordPlot);

            var gridCoord = (xCoord+1) +"/"+ (yCoord+1)+"/"+(xCoord+2)+"/"+(yCoord+2);

            coordPlot.setAttribute("style", "background-color: black; grid-area: "+gridCoord);
            coordPlot.setAttribute("class", "shipCoord");

        }

    }

}


function createGridLines(){
    for (x=1; x<11; x++){
        for (y=1; y<11; y++){

            var cell = document.createElement("b");
            document.getElementById("shipsgrid").appendChild(cell);

            var gridCoord = (x+1) +"/"+ (y+1)+"/"+(x+2)+"/"+(y+2);
            cell.setAttribute("style", "border: 1px solid black; grid-area: "+gridCoord);


            var enCell = document.createElement("b");
            document.getElementById("enemygrid").appendChild(enCell);

            enCell.setAttribute("style", "border: 1px solid black; grid-area: "+gridCoord);


        }
    }
}






function displayIncomingShots (data){

    var turns = data.salvoes.player2;

    for (i=0; i<turns.length; i++){
        for (j=0; j<turns[i].location.length; j++){

            var coord = turns[i].location[j];

            var xCoord = coord.charAt(0);
            var yCoord = coord.charAt(1);
            yCoord = parseInt(yCoord, 10);

            var coordKey = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];

            for (k=0; k<coordKey.length; k++){
                if(xCoord == coordKey[k]){

                    xCoord = coordKey.indexOf(xCoord);     /// this assigns a number to a letter coordinate
                    xCoord +=1;                         /// this gives A the value of 1 (for example)
                }
            }


            var coordPlot = document.createElement("div");
            document.getElementById("shipsgrid").appendChild(coordPlot);

            var gridCoord = (xCoord+1) +"/"+ (yCoord+1)+"/"+(xCoord+2)+"/"+(yCoord+2);

            coordPlot.setAttribute("style", "background-color: red; grid-area: "+gridCoord);
            coordPlot.setAttribute("class", "shotCoord");

            coordPlot.textContent= turns[i].turn;

        }
    }

}

function displayOutgoingShots (data){

    var turns = data.salvoes.player1;

    for (i=0; i<turns.length; i++){
        for (j=0; j<turns[i].location.length; j++){

            var coord = turns[i].location[j];

            var xCoord = coord.charAt(0);
            var yCoord = coord.charAt(1);
            yCoord = parseInt(yCoord, 10);

            var coordKey = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];

            for (k=0; k<coordKey.length; k++){
                if(xCoord == coordKey[k]){

                    xCoord = coordKey.indexOf(xCoord);     /// this assigns a number to a letter coordinate
                    xCoord +=1;                         /// this gives A the value of 1 (for example)
                }
            }


            var coordPlot = document.createElement("div");
            document.getElementById("enemygrid").appendChild(coordPlot);

            var gridCoord = (xCoord+1) +"/"+ (yCoord+1)+"/"+(xCoord+2)+"/"+(yCoord+2);

            coordPlot.setAttribute("style", "background-color: red; grid-area: "+gridCoord);
            coordPlot.setAttribute("class", "shotCoord");

            coordPlot.textContent= turns[i].turn;

        }
    }

}
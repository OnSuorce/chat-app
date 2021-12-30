var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#messages").html("");
}

function connect() {
    var socket = new SockJS('/stomp-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/chat/client/'+$("#chatID").val(), function (message) {
            console.log(message);
            showMessage(JSON.parse(message.body).sender,JSON.parse(message.body).content);
        });
        stompClient.subscribe('/chat/client/updates/'+$("#chatID").val(), function (message) {
                    console.log(message);
                    showMessage(JSON.parse(message.body).username,JSON.parse(message.body).type);
        });

    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/chat-app/server/"+$("#chatID").val()+"/connect", {}, JSON.stringify({'username': $("#name").val()}));
}
function sendMessage(){
    stompClient.send("/chat-app/server/"+$("#chatID").val(), {}, JSON.stringify({'sender': $("#name").val(),'content':$("#message").val()}));
}

function showMessage(sender,message) {
    $("#messages").append("<tr><td>" + sender + ": " + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
    $('#sendMessage').click(function() { sendMessage(); });
});
function reloadCompetitions() {
    $.getJSON('/api/competitions')
    .done(function(data) {
        console.log(data);
        data.items.forEach(function(item, index) {
            $("#competitions").append('<tr><td onclick="loadCompetition(' + item.id + ')">' +
                item.title + '</td></tr>');
        });
    });
}

function loadCompetition(id) {
    $('#main_div').load('competition.html', function() {
        if ('' != id) {
            $('#createEventButton').removeAttr('disabled');
            reloadEvents(id);
            $.getJSON('/api/competitions/' + id)
            .done(function(response) {
                console.log(response.title);
                $('#comp_id').html(response.id);
                $('#comp_title').val(response.title);
            });
        }
        else {
            $('#createEventButton').attr('disabled', 'disabled');
        }
    });

}

function saveCompetition(id) {
    var createUrl = '/api/competitions' + ('' != id ? '' : '/' + id);
    var body = '{"title":"' + $('#comp_title').val() + '"}';
    $.ajax(createUrl,{
        method: 'POST',
        contentType: 'application/json',
        data: body,
        dataType: 'json'
    })
    .done(function(data) {
        console.log(data);
        $('#comp_id').html(data);
        $('#createEventButton').removeAttr('disabled');
    });
}

function loadTrack(id) {
    $('#main_div').load('track.html', function() {
        $.getJSON('/api/competitions/' + id)
        .done(function(response) {
            console.log(response.title);
            $('#comp_id').html(response.id);
            $('#comp_title').html(response.title);
        });
    });
}

function trackOne(competitionId, compCount) {
    var n = compCount.html();
    n++;
    compCount.html(n)
    console.log(competitionId + ': ' + n);
    $.post('/api/track/' + competitionId, {
        timestamp: Date.now(),
        count: n
        })
        .always(function(data, textStatus, jqXHR) {
            console.log('Status for ' + n + ' was ' + textStatus);
        });
}

var onTrackOpen = function() {
    $('#track_info').html('Opened. Waiting...');
};

var onTrackMessage = function(message) {
    $('#track_info').html(message.data);
}

function viewTrack(competitionId, userId) {
    $('#track_info').html('Connecting...');
    $.getJSON('/api/track/' + competitionId + '/channel/' + userId, {}, function(data, textStatus, jqXHR) {
        $('#track_info').html('Waiting...');
        console.log('token=' + data);
        $('#track_info').attr('token', data.token);
        var channel = new goog.appengine.Channel(data.token);
        var handler = {
            'onopen': onTrackOpen,
            'onmessage': onTrackMessage,
            'onerror': function() {
                console.log('ERROR');
            },
            'onclose': function() {
                console.log('CLOSE');
                }
        };
        var socket = channel.open(handler);
        socket.onopen = onTrackOpen;
        socket.onmessage = onTrackMessage;
    });
}


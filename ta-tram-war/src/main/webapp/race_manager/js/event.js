function reloadEvents(competitionId) {
    $.getJSON('/api/competitions/' + competitionId + '/events')
    .done(function(data) {
        $('#createEventButton').removeAttr('disabled');
        data.items.forEach(function(item, index) {
            $("#events").append('<tr><td onclick="loadEvent(' + competitionId + ',' + item.id + ')">' +
                item.title + '</td></tr>');
        });
    })
    .fail(function() {
        $('#createEventButton').attr('disabled','disabled');
    });
}

function loadEvent(competitionId, id) {
    $('#main_div').load('event.html', function() {
        $('#comp_id').html(competitionId);
        loadEventInfo(competitionId, id);
    });

}

function loadEventInfo(competitionId, id) {
    console.log('competitionId=' + competitionId + ', eventId=' + id);
    if ('' != id) {
        $.getJSON('/api/events/' + id)
        .done(function(response) {
            console.log(response.title);
            $('#event_id').html(response.id);
            $('#event_title').val(response.title);
        });
        reloadHeats(id);
        $('#createHeatButton').removeAttr('disabled');
    }
    else {
        $('#createHeatButton').attr('disabled','disabled');
    }
}

function saveEvent(competitionId, id) {
    var createUrl = '/api/events' + (0 == id.length ? '' : '/' + id);
    var body = '{' +
        (0 < id.length ? '"id":' + id + ',' : '') +
        '"title":"' + $('#event_title').val() + '","competitionId":' + competitionId + '}';
    $.ajax(createUrl,{
        method: 'POST',
        contentType: 'application/json',
        data: body,
        dataType: 'json'
    })
    .done(function(data) {
        console.log(data);
        $('#event_id').html(data);
        $('#createHeatButton').removeAttr('disabled');
    });
}
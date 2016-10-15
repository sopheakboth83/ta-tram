function reloadHeats(eventId) {
    if ('' != eventId) {
        console.log('reloadHeats for ' + eventId);
        $.getJSON('/api/events/' + eventId + '/heats')
        .done(function(data) {
    //        console.log(data);
            $('#createHeatButton').removeAttr('disabled');
            data.items.forEach(function(item, index) {
                $("#heats").append('<tr><td onclick="loadHeat(' + eventId + ',' + item.id + ')">' +
                    item.title + '</td></tr>');
            });
        })
        .fail(function() {
        });
    }
    else {
        $('#createHeatButton').attr('disabled','disabled');
    }
}

function loadHeat(competitionId, eventId, id) {
    $('#main_div').load('heat.html', function() {
        $('#comp_id').html(competitionId);
        $('#event_id').html(eventId);
        if ('' != id) {
            reloadHeats(id);

            $.getJSON('/api/heats/' + id)
            .done(function(response) {
                console.log(response.title);
                $('#heat_id').html(response.id);
                $('#heat_title').val(response.title);
            });
        }
    });
}

function saveHeat(competitionId, eventId, id) {
    var createUrl = '/api/heats' + ('' != id ? '' : '/' + id);
    var body = '{' +
        (0 < id.length ? '"id":' + id + ',' : '') +
        '"title":"' + $('#heat_title').val() +
        '","competitionId":' + competitionId +
        '","eventId":' + eventId + '}';
    $.ajax(createUrl,{
        method: 'POST',
        contentType: 'application/json',
        crossDomain: true,
        data: body,
        dataType: 'json'
    })
    .done(function(data) {
        console.log(data);
        $('#comp_id').html(data.id);
    });
}